package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewModelList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstalments: Int,
    val customerFirstName: String,
    val customerLastName: String,
    val customerid: Long
) {
    constructor(credit:Credit) : this(
        customerFirstName = credit.customer?.FirstName ?: "",
        customerLastName = credit.customer?.LastName ?: "",
        customerid = credit.customer?.id ?: 0,
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstalments = credit.numberOfInstalment
    )
}