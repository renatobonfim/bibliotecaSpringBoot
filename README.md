# Accenture Java Project
Esse projeto tem como objetivo a criação de um sistema de locação de livros em uma biblioteca com gerenciamento por API's

# Membros do grupo
- Renato Bonfim Pereira https://www.linkedin.com/in/renato-bonfim-pereira-9337a0133/
- Rodrigo Azevedo Martins https://www.linkedin.com/in/rodrigoazevedomartins/

# Membros do grupo

# Diagrama de entidades
![img](https://drive.google.com/file/d/1GbOrp5wi2-omi0qdxHyJEYA1DHaK8d1W/view?usp=sharing)

# Técnologias usadas
- [SpringBoot](https://spring.io/projects/spring-boot#)
- [Spring Data](https://spring.io/projects/spring-data-jpa#)
- [Swagger](https://swagger.io/#)
- [Securing a Web Application](https://spring.io/guides/gs/securing-web/#)
- [JSON Web Tokens](https://jwt.io/#)
- [MySql](https://www.mysql.com/#)

# Métodos disponiveis
- User Controller

  Endpoint: /login POST
  
 ```sh
   
  Parametros 
        Name: user      Value: user 
        Name: password  Value: password 
        
   Retorno
   "string"
```
- Cadastro Controller

  Endpoint(Responsavel pelo cadastro de novos usuarios): /cadastro POST
   
  ```sh


  Body
  {
    "cpf": "string",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "ibge": 0,
      "localidade": "string",
      "logradouro": "string",
      "uf": "string"
    },
    "id": 0,
    "login": "string",
    "nome": "string",
    "senha": "string",
    "telefone": "string"
  }
  
  Retorno
  "string"

  ```
  Endpoint(Responsavel por recuperar uma lista de cadastro): /cadastro/buscar GET
  
   ```sh
   
  Header 
        Name: Authorization  Value: Retorno da User Controller

  
  Retorno
   [Cadastro{
  "cpf": "string",
  "email": "string",
  "endereco": {
    "bairro": "string",
    "cep": "string",
    "ibge": 0,
    "localidade": "string",
    "logradouro": "string",
    "uf": "string"
  },
  "id": 0,
  "login": "string",
  "nome": "string",
  "senha": "string",
  "telefone": "string"
  }]
  ```

   Endpoint(Responsavel por recuperar um unico cadastro): /cadastro/buscar/{id} GET
   
   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
    
    Retorno
    {
    "cpf": "string",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "ibge": 0,
     "localidade": "string",
     "logradouro": "string",
     "uf": "string"
   },
   "id": 0,
   "login": "string",
   "nome": "string",
   "senha": "string",
   "telefone": "string"
  }
   ```

 - Livro Controller

  Endpoint(Responsavel pelo cadastro de um livro): /livro POST
  
   ```sh
  
  Header 
        Name: Authorization  Value: Retorno da User Controller

  Body
  {
  "exemplares": 0,
  "id": 0,
  "isbn": "string",
  "reservados": 0,
  "titulo": "string",
  "valorDiaria": 0
  }

  Retorno 
  "string"
  
  ```

  Endpoint(Responsavel por recuperar todos os livors cadastrados): /livro/buscar GET
  
   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
  
  Retorno
  [
    livros{
    "exemplares": 0,
   "id": 0,
   "isbn": "string",
   "reservados": 0,
    "titulo": "string",
    "valorDiaria": 0
  }]
  ```

  Endpoint(Responsavel por recuperar um unico livro): /livro/buscar/{id} GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
        
   Retorno
  {
   "exemplares": 0,
   "id": 0,
   "isbn": "string",
   "reservados": 0,
    "titulo": "string",
    "valorDiaria": 0
    }

  ```

  - Locação Controller
  
   Endpoint(Responsavel por cadastrar uma locação): /locacao/agendar POST
  
   ```sh
   
  Header 
        Name: Authorization  Value: Retorno da User Controller

  Body
  {
  "cadastro": {
    "cpf": "string",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "ibge": 0,
      "localidade": "string",
      "logradouro": "string",
      "uf": "string"
    },
    "id": 0,
    "login": "string",
    "nome": "string",
    "senha": "string",
    "telefone": "string"
  },
  "dataAgendamento": "2021-04-05T16:14:28.787Z",
  "dataFinalizacao": "2021-04-05T16:14:28.787Z",
  "dataRetirada": "2021-04-05T16:14:28.787Z",
  "id": 0,
  "itens": [
    {
      "dataEntrega": "2021-04-05T16:14:28.787Z",
      "dataPrevisaoEntrega": "2021-04-05T16:14:28.787Z",
      "diarias": 0,
      "id": 0,
      "livro": {
        "exemplares": 0,
        "id": 0,
        "isbn": "string",
        "reservados": 0,
        "titulo": "string",
        "valorDiaria": 0
      },
      "valorLocacao": 0
    }
  ],
  "locacaoStatus": "RESERVADA",
  "valorTotal": 0
}

  Retorno 
  "string"
  
 ```
 
  Endpoint(Responsavel por recuperar todas as locacões): /locacao/buscar GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller

  Retorno
  [Locacao{
  "cadastro": {
    "cpf": "string",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "ibge": 0,
      "localidade": "string",
      "logradouro": "string",
      "uf": "string"
    },
    "id": 0,
    "login": "string",
    "nome": "string",
    "senha": "string",
    "telefone": "string"
  },
  "dataAgendamento": "2021-04-05T18:34:04.994Z",
  "dataFinalizacao": "2021-04-05T18:34:04.994Z",
  "dataRetirada": "2021-04-05T18:34:04.994Z",
  "id": 0,
  "itens": [
    {
      "dataEntrega": "2021-04-05T18:34:04.994Z",
      "dataPrevisaoEntrega": "2021-04-05T18:34:04.994Z",
      "diarias": 0,
      "id": 0,
      "livro": {
        "exemplares": 0,
        "id": 0,
        "isbn": "string",
        "reservados": 0,
        "titulo": "string",
        "valorDiaria": 0
      },
      "valorLocacao": 0
    }
  ],
  "locacaoStatus": "RESERVADA",
  "valorTotal": 0
}]
  ```
   Endpoint(Responsavel por recuperar uma unica locação): /locacao/buscar/{id} GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
  
  Retorno
  {
  "cadastro": {
    "cpf": "string",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "ibge": 0,
      "localidade": "string",
      "logradouro": "string",
      "uf": "string"
    },
    "id": 0,
    "login": "string",
    "nome": "string",
    "senha": "string",
    "telefone": "string"
  },
  "dataAgendamento": "2021-04-05T18:34:04.994Z",
  "dataFinalizacao": "2021-04-05T18:34:04.994Z",
  "dataRetirada": "2021-04-05T18:34:04.994Z",
  "id": 0,
  "itens": [
    {
      "dataEntrega": "2021-04-05T18:34:04.994Z",
      "dataPrevisaoEntrega": "2021-04-05T18:34:04.994Z",
      "diarias": 0,
      "id": 0,
      "livro": {
        "exemplares": 0,
        "id": 0,
        "isbn": "string",
        "reservados": 0,
        "titulo": "string",
        "valorDiaria": 0
      },
      "valorLocacao": 0
    }
  ],
  "locacaoStatus": "RESERVADA",
  "valorTotal": 0
}
  ```
  
   Endpoint(Responsavel por recuperar locação filtrando por data de agendamento): /locacao/buscarDataAgendada/{data} GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
        
    Retorno
    [
  {
    "cadastro": {
      "cpf": "string",
      "email": "string",
      "endereco": {
        "bairro": "string",
        "cep": "string",
        "ibge": 0,
        "localidade": "string",
        "logradouro": "string",
        "uf": "string"
      },
      "id": 0,
      "login": "string",
      "nome": "string",
      "senha": "string",
      "telefone": "string"
    },
    "dataAgendamento": "2021-04-05T18:35:06.272Z",
    "dataFinalizacao": "2021-04-05T18:35:06.272Z",
    "dataRetirada": "2021-04-05T18:35:06.272Z",
    "id": 0,
    "itens": [
      {
        "dataEntrega": "2021-04-05T18:35:06.272Z",
        "dataPrevisaoEntrega": "2021-04-05T18:35:06.272Z",
        "diarias": 0,
        "id": 0,
        "livro": {
          "exemplares": 0,
          "id": 0,
          "isbn": "string",
          "reservados": 0,
          "titulo": "string",
          "valorDiaria": 0
        },
        "valorLocacao": 0
      }
    ],
    "locacaoStatus": "RESERVADA",
    "valorTotal": 0
  }
]

  ```
  
   Endpoint(Responsavel por recuperar locação filtrando por data de retirada): /locacao/buscarDataRetirada/{data} GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
    
    Retorno
    [
  {
    "cadastro": {
      "cpf": "string",
      "email": "string",
      "endereco": {
        "bairro": "string",
        "cep": "string",
        "ibge": 0,
        "localidade": "string",
        "logradouro": "string",
        "uf": "string"
      },
      "id": 0,
      "login": "string",
      "nome": "string",
      "senha": "string",
      "telefone": "string"
    },
    "dataAgendamento": "2021-04-05T18:35:06.272Z",
    "dataFinalizacao": "2021-04-05T18:35:06.272Z",
    "dataRetirada": "2021-04-05T18:35:06.272Z",
    "id": 0,
    "itens": [
      {
        "dataEntrega": "2021-04-05T18:35:06.272Z",
        "dataPrevisaoEntrega": "2021-04-05T18:35:06.272Z",
        "diarias": 0,
        "id": 0,
        "livro": {
          "exemplares": 0,
          "id": 0,
          "isbn": "string",
          "reservados": 0,
          "titulo": "string",
          "valorDiaria": 0
        },
        "valorLocacao": 0
      }
    ],
    "locacaoStatus": "RESERVADA",
    "valorTotal": 0
  }
]
  ```
  
   Endpoint(Responsavel por recuperar locação filtrando por status): /locacao/buscarStatus/{status} GET

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
    
    Retorno
    [
  {
    "cadastro": {
      "cpf": "string",
      "email": "string",
      "endereco": {
        "bairro": "string",
        "cep": "string",
        "ibge": 0,
        "localidade": "string",
        "logradouro": "string",
        "uf": "string"
      },
      "id": 0,
      "login": "string",
      "nome": "string",
      "senha": "string",
      "telefone": "string"
    },
    "dataAgendamento": "2021-04-05T18:35:06.272Z",
    "dataFinalizacao": "2021-04-05T18:35:06.272Z",
    "dataRetirada": "2021-04-05T18:35:06.272Z",
    "id": 0,
    "itens": [
      {
        "dataEntrega": "2021-04-05T18:35:06.272Z",
        "dataPrevisaoEntrega": "2021-04-05T18:35:06.272Z",
        "diarias": 0,
        "id": 0,
        "livro": {
          "exemplares": 0,
          "id": 0,
          "isbn": "string",
          "reservados": 0,
          "titulo": "string",
          "valorDiaria": 0
        },
        "valorLocacao": 0
      }
    ],
    "locacaoStatus": "RESERVADA",
    "valorTotal": 0
  }
]
  ```
  
   Endpoint(Responsavel por alterar o status da locação por efetivado): /locacao/efetivar/{id} POST

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
     
    Retorno
    "string"
  ```
  
   Endpoint(Responsavel por alterar o status da locação por finalizado): /locacao/finalizar/{id} POST

   ```sh
   
    Header 
        Name: Authorization  Value: Retorno da User Controller
    
    Retorno
    "string"
    
  ```
  



