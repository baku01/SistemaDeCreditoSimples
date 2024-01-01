package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository: JpaRepository<Customer, Long> {

}


            //As interfaces sao usadas para intermediação entre o banco de dados e a aplicação
            // a segurança e feita pela interface JpaRepository que é uma interface do Spring Data JPA que fornece métodos CRUD padrão para trabalhar com entidades.
            // @Repository é uma anotação que indica que a classe é um repositório, ou seja, é responsável por armazenar, recuperar, atualizar e excluir objetos.