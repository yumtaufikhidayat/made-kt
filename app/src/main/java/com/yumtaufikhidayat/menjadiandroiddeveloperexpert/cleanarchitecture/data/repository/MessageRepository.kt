package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.source.IMessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.repository.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromSource(name)
    }
}