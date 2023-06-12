package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.presentation.di

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.repository.MessageRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.source.IMessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.source.MessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.repository.IMessageRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.usecase.MessageInteractor
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.usecase.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}