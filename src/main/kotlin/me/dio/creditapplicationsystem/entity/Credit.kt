package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credito")
data class Credit(
   @Column(nullable = false) val creditCode: UUID = UUID.randomUUID(),
   @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
   @Column(nullable = false) val dayFirstInstalment: LocalDate,
   @Column(nullable = false) val numberOfInstalment: Int = 0,
   @Enumerated val status: Status = Status.IN_PROGRESS, //ENUM para definir o status do crédito
   @ManyToOne var customer: Customer? = null, //ManyToOne para definir que um cliente pode ter vários créditos
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
) {
}