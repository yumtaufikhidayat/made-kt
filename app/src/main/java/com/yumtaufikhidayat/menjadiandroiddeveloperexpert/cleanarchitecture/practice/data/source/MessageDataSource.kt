package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.source

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity

class MessageDataSource: IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }
}