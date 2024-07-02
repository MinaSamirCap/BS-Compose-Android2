package com.sample.compose_bs_android2.mine.mutex.real

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class BankAccount private constructor() {

    private val mutex = Mutex()

    private var _currentBalance = mutableIntStateOf(0)
    val currentBalance: State<Int> = _currentBalance

    suspend fun deposit(amount: Int = 1000) {
        mutex.withLock {
            delay(1000)
            _currentBalance.intValue += amount
        }
    }

    suspend fun withdraw(amount: Int = 500) {
        mutex.withLock {
            if (_currentBalance.intValue >= amount) {
                delay(1000)
                _currentBalance.intValue -= amount
            }
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: BankAccount? = null

        fun getInstance(): BankAccount {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: BankAccount().also { INSTANCE = it }
            }
        }

    }
}