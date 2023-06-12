package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}