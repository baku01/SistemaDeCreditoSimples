package me.dio.creditapplicationsystem.controller

import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.model.CustomerModel
import me.dio.creditapplicationsystem.implement.CustomerService
import me.dio.creditapplicationsystem.model.CustomerUpdateModel
import me.dio.creditapplicationsystem.model.CustomerViewModel
import org.hibernate.sql.Update
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/customers")

class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping("/create")
    fun CreateCustomer(@RequestBody CustomerModel: CustomerModel): ResponseEntity<String> {
    val SavedCustomer =  this.customerService.SaveCustomer(CustomerModel.toCustomer())
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente id ${SavedCustomer.id} ${SavedCustomer.FirstName} ${SavedCustomer.LastName} cadastrado com sucesso!")
    }

    @GetMapping("/query/{id}")
    fun FindById(@PathVariable id: Long):ResponseEntity<CustomerViewModel> {
    val CustomerQuery : Customer = this.customerService.FindCustomerById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViewModel(CustomerQuery))
    }

    @DeleteMapping("/delete/{id}")
        fun DeleteById(@PathVariable id: Long): ResponseEntity<String> {
        val CustomerQuery : Customer = this.customerService.DeleteCustomerById(id)
        return ResponseEntity.status(HttpStatus.OK).body(" O cliente ${CustomerQuery.FirstName} ${CustomerQuery.LastName} id ${CustomerQuery.id}  deletado com sucesso!")
    }

    @PutMapping("/update/{id}")
    fun UpdateCustomer(@PathVariable id: Long,
                       @RequestBody CustomerUpdateModel: CustomerUpdateModel): ResponseEntity<CustomerViewModel> {
        val CustomerQuery : Customer = this.customerService.FindCustomerById(id)
        val CustomerUpdated : Customer = CustomerUpdateModel.toCustomer(CustomerQuery)
        val CustomerView : Customer = this.customerService.SaveCustomer(CustomerUpdated)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViewModel(CustomerView))
    }
}
