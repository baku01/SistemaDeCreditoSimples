package me.dio.creditapplicationsystem.controller

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.implement.CreditService
import me.dio.creditapplicationsystem.model.CreditModel
import me.dio.creditapplicationsystem.model.CreditViewModel
import me.dio.creditapplicationsystem.model.CreditViewModelList
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping("/create")
    fun SaveCredit(@RequestBody CreditModel: CreditModel): ResponseEntity<String> {
        val credit: Credit = this.creditService.Save(CreditModel.toCredit())
        return ResponseEntity.status(HttpStatus.CREATED).body("Crédito cadastrado com sucesso, para o cliente ${credit.customer?.FirstName} ${credit.customer?.LastName} CPF: ${credit.customer?.CPF} e Email: ${credit.customer?.Email}!")
    }

    @GetMapping("/query/{id}")
    fun FindAllByCustomer(@PathVariable id: Long): ResponseEntity<List<CreditViewModelList>> {
        val CreditView: List<CreditViewModelList> = this.creditService.findAllByCustomer(id).stream().map { credit -> CreditViewModelList(credit) }.toList()
        return ResponseEntity.status(HttpStatus.OK).body(CreditView)
    }

    @GetMapping("/query/bycode/{id}/{creditCode}")
    fun finAllByCreditCode(@PathVariable creditCode: UUID, @PathVariable id: Long): ResponseEntity<CreditViewModel> {
        val credit: Credit = this.creditService.findAllByCreditCode(creditCode, id)
        return ResponseEntity.status(HttpStatus.OK).body(CreditViewModel(credit))
    }
}