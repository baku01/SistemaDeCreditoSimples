package me.dio.creditapplicationsystem.model

import me.dio.creditapplicationsystem.entity.Customer

data class CustomerViewModel(
    val firstName: String,
    val lastName: String,
    val Id: Long? = null
    //Model para visualização dos dados do cliente
    ) {
    constructor(customer: Customer) : this(
        firstName = customer.FirstName,
        lastName = customer.LastName,
        Id = customer.id
    )
}
