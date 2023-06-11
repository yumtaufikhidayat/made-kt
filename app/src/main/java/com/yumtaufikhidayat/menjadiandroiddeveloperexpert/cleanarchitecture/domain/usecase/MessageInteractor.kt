package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.repository.IMessageRepository

class MessageInteractor(private val messageRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}