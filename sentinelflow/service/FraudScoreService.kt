package com.example.sentinelflow.service

import com.example.sentinelflow.model.Transaction
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class FraudScoreService {
    suspend fun calculateScore(transaction: Transaction): Boolean {
        delay(50)
        val score = Random.nextDouble(0.0, 1.0)
        return score < 0.05
    }
}