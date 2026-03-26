package com.example.sentinelflow.repository

import com.example.sentinelflow.model.Transaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionRepository : ReactiveCrudRepository<Transaction, UUID>