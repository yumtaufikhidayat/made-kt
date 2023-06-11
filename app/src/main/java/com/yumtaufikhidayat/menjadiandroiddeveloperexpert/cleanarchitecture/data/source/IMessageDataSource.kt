package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.data.source

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}