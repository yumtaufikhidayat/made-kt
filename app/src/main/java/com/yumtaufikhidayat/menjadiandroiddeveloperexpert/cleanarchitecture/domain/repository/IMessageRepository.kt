package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}