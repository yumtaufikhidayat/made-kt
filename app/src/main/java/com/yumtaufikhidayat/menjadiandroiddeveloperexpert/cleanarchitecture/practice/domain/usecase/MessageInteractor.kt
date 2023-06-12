package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.usecase

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.repository.IMessageRepository

class MessageInteractor(private val messageRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}