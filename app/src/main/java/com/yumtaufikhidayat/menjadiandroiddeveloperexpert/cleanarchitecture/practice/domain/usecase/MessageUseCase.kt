package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.usecase

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.domain.entity.MessageEntity

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}