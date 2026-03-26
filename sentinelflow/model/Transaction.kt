package com.example.sentinelflow.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("transactions")
data class Transaction(
    @Id
    val id: UUID = UUID.randomUUID(),
    val userId: String,
    val amount: Double,
    val merchant: String,
    val timestamp: Long = System.currentTimeMillis()
)