package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Customer

interface ICustomerService {

    fun SaveCustomer(customer: Customer): Customer
    fun FindCustomerById(id: Long): Customer
    fun DeleteCustomerById(id: Long) : Customer


}

//Service serve para fazer a ponte entre o controller e o repository
