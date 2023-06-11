package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.presentation.di

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.repository.MessageRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.source.IMessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.source.MessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.repository.IMessageRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase.MessageInteractor
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase.MessageUseCase

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