package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.data.source

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}