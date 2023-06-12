package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.source.IMessageDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.repository.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromSource(name)
    }
}