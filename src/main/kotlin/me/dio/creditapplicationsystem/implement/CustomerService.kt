package me.dio.creditapplicationsystem.implement

import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CostumerRepository
import me.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val costumerRepository: CostumerRepository
): ICustomerService {
    override fun SaveCustomer(customer: Customer): Customer =
        this.costumerRepository.save(customer) //Aqui é onde a magica acontece, o spring data jpa vai fazer a persistencia no banco de dados


    override fun FindCustomerById(id: Long): Customer =
        this.costumerRepository.findById(id).orElseThrow()
        {
            throw RuntimeException("O id $id não foi encontrado") //Aqui e feito uma verificação para ver se o id existe, caso não exista é lançado uma exceção
        }


    override fun DeleteCustomerById(id: Long): Customer {
        val customer: Customer = this.costumerRepository.findById(id).orElseThrow()
        {
            throw RuntimeException("O id $id não foi encontrado") //Aqui e feito uma verificação para ver se o id existe, caso não exista é lançado uma exceção
        }
        this.costumerRepository.deleteById(id)
        return customer
    }
}






//Nesse momemnto o projeto tem o serviço distribuido em 3 camadas, a camada de controller, a camada de service e a camada de repository
//Toda logica de negocio fica na camada de service, a camada de controller serve para receber as requisições e a camada de repository serve para fazer a interação com o banco de dados
