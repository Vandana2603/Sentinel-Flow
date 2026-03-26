package com.example.sentinelflow.controller
import com.example.sentinelflow.repository.TransactionRepository
import com.example.sentinelflow.model.Transaction
import com.example.sentinelflow.service.TransactionService
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/transactions")
class TransactionController(
    private val transactionService: TransactionService,
    private val transactionRepository: TransactionRepository
) {

    @PostMapping
    suspend fun submitTransaction(@RequestBody transaction: Transaction): String {
        return transactionService.processTransaction(transaction).awaitSingle()
    }

    @GetMapping
    fun getAllTransactions(): Mono<List<Transaction>> {
        return transactionRepository.findAll().collectList()
    }
}