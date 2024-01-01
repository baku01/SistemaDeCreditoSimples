package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreditViewModel(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val Status: Status,
    val numberOfInstalments: Int,
    val dayFirstInstalment: LocalDate,
    val customerFirstName: String,
    val customerLastName: String,
    val customerCPF: String,
    val customerEmail: String
)
{
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        Status = credit.status,
        numberOfInstalments = credit.numberOfInstalment,
        dayFirstInstalment = credit.dayFirstInstalment,
        customerFirstName = credit.customer?.FirstName ?: "",
        customerLastName = credit.customer?.LastName ?: "",
        customerCPF = credit.customer?.CPF ?: "",
        customerEmail = credit.customer?.Email ?: ""
    )
}
