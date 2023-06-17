package com.yumtaufikhidayat.menjadiandroiddeveloperexpert

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ActivityReactiveXBinding
import io.reactivex.Observable
import io.reactivex.functions.Function3

class ReactiveXActivity : AppCompatActivity() {

    private val binding by lazy { ActivityReactiveXBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewStream()
    }

    @SuppressLint("CheckResult")
    private fun initViewStream() {
        binding.apply {
            val emailStream = RxTextView.textChanges(edEmail)
                .skipInitialValue()
                .map { email ->
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                }

            emailStream.subscribe {
                showEmailExistAlert(it)
            }

            val passwordStream = RxTextView.textChanges(edPassword)
                .skipInitialValue()
                .map { password ->
                    password.length < 6
                }
            passwordStream.subscribe {
                showPasswordMinimalAlert(it)
            }

            val password = RxTextView.textChanges(edPassword)
                .map { password ->
                    password.toString() != edConfirmPassword.text.toString()
                }

            val confirmPassword = RxTextView.textChanges(edConfirmPassword)
                .map { confirmPassword ->
                    confirmPassword.toString() != edPassword.text.toString()
                }

            val passwordConfirmationStream = Observable.merge(
                password, confirmPassword
            )
            passwordConfirmationStream.subscribe {
                showPasswordConfirmationAlert(it)
            }

            validateButton(emailStream, passwordStream, passwordConfirmationStream)
        }
    }

    @SuppressLint("CheckResult")
    private fun validateButton(
        emailStream: Observable<Boolean>?,
        passwordStream: Observable<Boolean>?,
        passwordConfirmationStream: Observable<Boolean>?
    ) {
        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            passwordConfirmationStream,
            Function3 { emailInvalid: Boolean, passwordInvalid: Boolean, passwordConfirmInvalid: Boolean ->
                !emailInvalid && !passwordInvalid && !passwordConfirmInvalid
            })

        invalidFieldStream.subscribe { isValid ->
            binding.btnRegister.apply {
                if (isValid) {
                    isEnabled = true
                    setBackgroundColor(ContextCompat.getColor(this@ReactiveXActivity, R.color.purple_500))
                } else {
                    isEnabled = false
                    setBackgroundColor(ContextCompat.getColor(this@ReactiveXActivity, android.R.color.darker_gray))
                }
            }
        }
    }

    private fun showEmailExistAlert(isNotValid: Boolean) {
        binding.edEmail.error = if (isNotValid) getString(R.string.email_not_valid) else null
    }

    private fun showPasswordMinimalAlert(isNotValid: Boolean) {
        binding.edPassword.error = if (isNotValid) getString(R.string.password_not_valid) else null
    }

    private fun showPasswordConfirmationAlert(isNotValid: Boolean) {
        binding.edConfirmPassword.error = if (isNotValid) getString(R.string.password_not_same) else null
    }
}