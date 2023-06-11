package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}