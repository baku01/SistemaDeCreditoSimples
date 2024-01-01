package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateModel(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val password: String,
    val zipCode: String,
    val street: String,
) {
    fun toCustomer(customer: Customer) : Customer{
    customer.FirstName = this.firstName
    customer.LastName = this.lastName
    customer.Income = this.income
    customer.Password = this.password
    customer.Address.ZipCode = this.zipCode
    customer.Address.Street = this.street
    return customer
    }

}