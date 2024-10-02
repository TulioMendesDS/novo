
# Gerenciamento de Pessoas - API 🚀

Este projeto é uma API desenvolvida para facilitar o gerenciamento de informações de pessoas, permitindo realizar operações essenciais como cadastro, consulta e exclusão de registros. Utilizando **Spring Boot**, a API foi construída com **Spring Web** para os endpoints RESTful, **Spring Data JPA** para a persistência de dados em **MySQL**, e **Lombok** para otimizar o código em Java.

A proposta é criar uma solução que possa ser utilizada em ambientes acadêmicos, empresariais ou em qualquer sistema que precise gerenciar dados de indivíduos de maneira eficiente.

### A entidade central da aplicação é **Pessoa**, que contém os seguintes atributos:
- **nome** (String): O nome completo da pessoa.
- **cpf** (String): O CPF da pessoa, que deve ser único no sistema.
- **idade** (Integer): A idade da pessoa.

### Funcionalidades
A API fornece operações básicas de CRUD (Create, Read, Update, Delete) para a entidade **Pessoa**, com os seguintes endpoints:
- **POST** `/persons`: Para criar uma nova Pessoa no banco de dados.
- **GET** `/persons/{id}`: Para retornar os detalhes de uma Pessoa usando seu ID.
- **DELETE** `/persons/{id}`: Para remover uma Pessoa do banco de dados com base em seu ID.

---

## Estrutura do Projeto 📚
1. **Requisitos Necessários** ⚙️
2. **Instruções de Instalação** 📦
3. **Configuração do Banco de Dados**🗄️
4. **Desenvolvimento** 🔨
   - Implementação da Entidade
   - Implementação do Repositório
   - Implementação do DTO
   - Implementação do Controlador
5. **Testando a API** 🧪
6. **Tecnologias Empregadas** 💻

---

## Requisitos Necessários ⚙️
Antes de começar, garanta que você tenha os seguintes componentes instalados em sua máquina:
- **Java Development Kit (JDK) 17 ou superior**
- **Maven 3.8 ou superior**
- **MySQL 8 ou superior**
- **IntelliJ IDEA** ou outra IDE de sua preferência

## Instruções de Instalação 📦
1. Clone o repositório para seu ambiente local:

    ```bash
   git clone https://github.com/TulioMendesDS/people-management-api.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd people-management-api
   ```

3. Instale as dependências necessárias:

   ```bash
   mvn clean install
   ```

4. Certifique-se de que o seu servidor MySQL está em funcionamento.

---

## Configuração do Banco de Dados🗄️

Para que a aplicação funcione corretamente com o MySQL, você deve configurar as variáveis de conexão no arquivo `application.properties`, localizado em `src/main/resources`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/personDb
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

Essa configuração assegura que o banco de dados será automaticamente atualizado, criando a tabela correspondente à entidade Pessoa caso ela não exista.

---

## Desenvolvimento 🔨

### 1. Implementação da Entidade:

A classe Pessoa será mapeada como uma tabela no banco de dados. Utilize a anotação `@Entity` para definir essa classe, que conterá os atributos `id`, `nome`, `cpf` e `idade`.


Exemplo:

```java
@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private Integer idade;

    // Getters e Setters
}
```

### 2. Implementação do Repositório:

Implemente a interface **PessoaRepository**, que deve estender **JpaRepositor**. Essa interface facilita a interação com o banco de dados, oferecendo métodos prontos para realizar operações de CRUD.

```java
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
```

### 3. Implementação do DTO

Crie a classe **PessoaDTO**, que será utilizada para transferir dados da entidade **Pessoa** entre as camadas da aplicação, sem expor diretamente a entidade que representa a tabela no banco.

```java
public class PessoaDTO {
    
    private String nome;
    private String cpf;
    private Integer idade;

    // Getters e Setters
}
```

### 4. Implementação do Controlador

O controlador **PessoaController** é responsável por expor os endpoints da API. Utilize a anotação `@RestController` e implemente os métodos POST, GET e DELETE para as operações correspondentes.


---

## Testando a API 🧪

Para testar os endpoints da API, você pode utilizar ferramentas como **Postman** ou **Insomnia**.

1. **POST** `/persons`: Para criar uma nova Pessoa, envie um JSON no corpo da requisição:
   
   ```json
   {
     "nome": "Maria Oliveira",
     "cpf": "987.654.321-00",
     "idade": 25
   }
   ```

**GET** `/persons/{id}`: Retorna os dados de uma Pessoa existente usando seu ID.
**DELETE** `/persons/{id}`: Remove uma Pessoa do banco de dados de acordo com seu ID.

---

## Tecnologias Empregadas 💻


- ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) **Spring Data JPA**: Para a persistência e gerenciamento das operações com o banco de dados.
- ![MySQL](https://img.shields.io/badge/MySQL-%234479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) **MySQL**: Sistema de gerenciamento de banco de dados utilizado na aplicação.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?style=for-the-badge&logo=spring-boot&logoColor=white) **Spring Boot**: Framework que simplifica o desenvolvimento da API.
- ![Maven](https://img.shields.io/badge/Apache%20Maven-%234B8B3B.svg?style=for-the-badge&logo=apache-maven&logoColor=white) **Maven**: Ferramenta de automação e gerenciamento de dependências.
- ![Lombok](https://img.shields.io/badge/Project%20Lombok-%2300BFFF.svg?style=for-the-badge&logo=lombok&logoColor=white) **Lombok**: Biblioteca que ajuda a minimizar o código boilerplate em Java.


## Autor

<!-- Fotos autores -->
<table>
  <tr>
   <td align="center">
      <a href="https://github.com/TulioMendesDev">
        <img src="https://avatars.githubusercontent.com/u/167912036?v=4" width="100px;" alt="Foto do Túlio"/><br>
        <sub>
          <b>Túlio Mendes</b>
        </sub>
      </a>
   </td>
    
  </tr>
</table>
</table>
