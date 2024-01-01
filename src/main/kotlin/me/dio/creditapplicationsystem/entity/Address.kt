package me.dio.creditapplicationsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
   @Column var Street: String = "",
   @Column var Number: String = "",
   @Column var Complement: String = "",
   @Column var City: String = "",
   @Column var State: String = "",
   @Column var Country: String = "",
   @Column var ZipCode: String = "",
)
