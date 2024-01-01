package me.dio.creditapplicationsystem.implement

import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.repository.CostumerRepository
import me.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val costumerRepository: CostumerRepository) : ICreditService {
    override fun Save(credit: Credit): Credit {
        credit.apply {
            customer = costumerRepository.findById(credit.customer?.id!!).orElseThrow()
            {
                throw RuntimeException("O id ${credit.customer?.id} não foi encontrado")
            }
        }
        return creditRepository.save(credit)

    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomer_Id(customerId)
    override fun findAllByCreditCode(creditCode: UUID, customerId: Long): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("O código $creditCode não foi encontrado"))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contate o administrador do sistema!")
    }
}