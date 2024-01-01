package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerModel(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val password: String,
    val email: String,
    val zipCode: String,
    val street: String,
    ) {
    fun toCustomer(): Customer  = Customer(
        FirstName = firstName,
        LastName = lastName,
        CPF = cpf,
        Income = income,
        Password = password,
        Email = email,
        Address = Address(
            ZipCode = zipCode,
            Street = street
        )
    )

}

