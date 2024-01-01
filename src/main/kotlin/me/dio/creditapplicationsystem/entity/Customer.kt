package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "Cliente")
data class Customer(
    @Column(nullable = false) var FirstName: String = "",
    @Column(nullable = false) var LastName: String = "",
    @Column(nullable = false) var Income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false, unique = true) val CPF: String = "",
    @Column(nullable = false, unique = true) var Email: String = "", //UNIQUE = TRUE para não permitir duplicidade
    @Column(nullable = false) var Password: String = "",
    @Column(nullable = false) @Embedded var Address: Address = Address(),
    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE), mappedBy = "customer") val Credits: List<Credit> = mutableListOf(), //CascadeType.REMOVE para remover os créditos do cliente caso o cliente seja removido
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null //ID gerado automaticamente
)