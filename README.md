# Sistema de Solicitação de Crédito API 🚀

Este projeto é uma API para gerenciar solicitações de crédito e informações de clientes. A API oferece endpoints para criar, recuperar, atualizar e excluir informações de clientes e créditos.

## Repositórios 🗃️

### `CreditRepository`

- Busca um crédito pelo código único (`UUID`).
  ```kotlin
  fun findByCreditCode(creditCode: UUID): Credit?
  ```

- Retorna uma lista de créditos associados a um cliente específico de forma segura, evitando SQL Injection.
  ```kotlin
  fun findAllByCustomer_Id(customerId: Long): List<Credit>
  ```

### `CustomerRepository`

- Operações CRUD básicas para clientes.
  ```kotlin
  // Salvar um novo cliente
  val savedCustomer = customerRepository.save(customer)

  // Recuperar um cliente por ID
  val customer = customerRepository.findById(customerId).orElse(null)

  // Atualizar um cliente
  customer.firstName = "Julia"
  customerRepository.save(customer)

  // Excluir um cliente por ID
  customerRepository.deleteById(customerId)
  ```

### `CreditService`

- Implementa a lógica de negócios relacionada a créditos.
- Usa o `CreditRepository` e `CustomerRepository` para interagir com o banco de dados.
- No método `Save`, associa um cliente existente ao crédito antes de salvar no banco de dados.
  ```kotlin
  override fun Save(credit: Credit): Credit {
      credit.apply {
          customer = costumerRepository.findById(credit.customer?.id!!).orElseThrow()
          {
              throw RuntimeException("O id ${credit.customer?.id} não foi encontrado")
          }
      }
      return creditRepository.save(credit)
  ```

### `CustomerService`

- Implementa a lógica de negócios relacionada a clientes.
- Usa o `CustomerRepository` para interagir com o banco de dados.
- Métodos como `SaveCustomer`, `FindCustomerById` e `DeleteCustomerById` oferecem operações CRUD para clientes.
  ```kotlin
  override fun SaveCustomer(customer: Customer): Customer =
      this.costumerRepository.save(customer)

  override fun FindCustomerById(id: Long): Customer =
      this.costumerRepository.findById(id).orElseThrow()
      {
          throw RuntimeException("O id $id não foi encontrado")
      }

  override fun DeleteCustomerById(id: Long): Customer {
      val customer: Customer = this.costumerRepository.findById(id).orElseThrow()
      {
          throw RuntimeException("O id $id não foi encontrado")
      }
      this.costumerRepository.deleteById(id)
      return customer
  ```

## Repositório `CreditRepository` Atualizado 🔄

O repositório `CreditRepository` foi atualizado para evitar SQL Injection. Agora, a consulta utiliza a convenção de nomenclatura do Spring Data JPA.
```kotlin
@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?
    fun findAllByCustomer_Id(customerId: Long): List<Credit> // Boa prática
}
```

## Funcionalidades Principais 🌐

- Operações CRUD: Ambos os repositórios (`CreditRepository` e `CustomerRepository`) oferecem funcionalidades básicas de CRUD para suas respectivas entidades.
- Lógica de Negócios: A camada de serviço (`CreditService` e `CustomerService`) implementa a lógica de negócios, enquanto a camada de controller (`CreditController` e `CustomerController`) lida com as requisições HTTP.
- Segurança: A segurança é implementada através da interface `JpaRepository`, que fornece métodos padrão para trabalhar com entidades no banco de dados.

## Tecnologias Utilizadas 💻

- Spring Boot
- Kotlin
- Actuator (Habilitado para facilitar o desenvolvimento no IntelliJ IDEA)
- Outras dependências (listadas no arquivo build.gradle)

## Como Executar o Projeto ▶️

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd seu-projeto
   ```

3. Execute o projeto:
   ```bash
   ./gradlew bootRun
   ```

## Utilizando a Documentação no Postman

Para facilitar o teste e a interação com a API de Solicitação de Crédito, fornecemos uma coleção de requisições no Postman. Siga as instruções abaixo para utilizá-la:

1. Baixe e instale o [Postman](https://www.postman.com/downloads/).

2. Abra o Postman e clique em "Import" no canto superior esquerdo.

3. Procure o arquivo `API de Solicitação de Crédito.postman_collection.json` no diretório raiz do projeto e clique em "Open".

## Contribuição 🤝

Sinta-se à vontade para contribuir, abrindo problemas (issues) ou enviando pull requests. Todas as contribuições são bem-vindas!