package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Credit
import java.util.UUID


//Interface que diz oque o serviço deve fazer
interface ICreditService {
    fun Save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findAllByCreditCode(creditCode: UUID, customerId: Long): Credit

}