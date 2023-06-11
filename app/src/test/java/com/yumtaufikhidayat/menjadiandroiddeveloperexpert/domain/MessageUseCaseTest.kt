package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.domain

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.repository.IMessageRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase.MessageInteractor
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.domain.usecase.MessageUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class MessageUseCaseTest {

    private lateinit var messageUserCase: MessageUseCase

    @Mock
    private lateinit var messageRepository: IMessageRepository

    @Before
    fun setUp() {
        messageUserCase = MessageInteractor(messageRepository)
        val dummyMessage = MessageEntity("Hello $NAME Welcome to Clean Architecture")
        `when`(messageRepository.getWelcomeMessage(NAME)).thenReturn(dummyMessage)
    }

    @Test
    fun `should get data from repository`() {
        val message = messageUserCase.getMessage(NAME)
        verify(messageRepository).getWelcomeMessage(NAME)
        verifyNoMoreInteractions(messageRepository)
        assertEquals("Hello $NAME Welcome to Clean Architecture", message.welcomeMessage)
    }

    companion object {
        const val NAME = "Dicoding"
    }
}