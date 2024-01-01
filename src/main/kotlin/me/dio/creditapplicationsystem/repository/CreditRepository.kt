package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?

    //@Query("SELECT credits FROM Credit credits WHERE credits.customer.id = :customerId") // Inseguro SQL Injection
    //fun findAllByCustomerID(customerId: Long): List<Credit>

    //@Query("SELECT credit FROM Credit credit WHERE credit.customer.id = :customerId") //Inseguro SQL Injection
    //fun findAllByCustomerId(@Param("customerId") customerId: Long): List<Credit>

    fun findAllByCustomer_Id(customerId: Long): List<Credit> //Boa prática

}

