package com.example.sentinelflow.service

import com.example.sentinelflow.model.Transaction
import com.example.sentinelflow.repository.TransactionRepository
import kotlinx.coroutines.reactor.mono
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TransactionService(
    private val fraudScoreService: FraudScoreService,
    private val transactionRepository: TransactionRepository
) {
    fun processTransaction(transaction: Transaction): Mono<String> = mono {
        val isFraud = fraudScoreService.calculateScore(transaction)

        // Save the transaction to PostgreSQL
        transactionRepository.save(transaction).subscribe()

        // Return result
        if (isFraud) "FRAUD" else "SAFE"
    }
}