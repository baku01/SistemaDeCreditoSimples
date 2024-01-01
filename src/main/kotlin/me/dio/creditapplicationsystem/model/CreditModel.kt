package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditModel(
    val creditValue: BigDecimal,
    val dayFirstInstalment: LocalDate,
    val numberOfInstalment: Int,
    val customerId: Long
)
{
    fun toCredit(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstInstalment = this.dayFirstInstalment,
    numberOfInstalment = this.numberOfInstalment,
    customer = Customer(id = this.customerId)
    ) //Função para criar um novo crédito
}
