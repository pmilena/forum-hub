<h1>Bem-vindo ao FórumHub</h1>


## 📖 Sobre o Projeto

O **FórumHub** é uma aplicação desenvolvida para simular o funcionamento de um fórum no nível de back-end. Fóruns são espaços onde participantes podem fazer perguntas e obter respostas sobre diversos assuntos. 

Foi desenvolvida uma **API RESTful** que gerencia os tópicos do fórum, permitindo operações de **CRUD**: 
- Criar novos tópicos.
- Consultar tópicos existentes.
- Atualizar tópicos.
- Deletar tópicos.

A aplicação foi desenvolvida com foco em boas práticas de desenvolvimento, incluindo validação de regras de negócio, persistência de dados em banco relacional e implementação de autenticação/autorização.

## 🎯 Funcionalidades da API

1. **Criar Tópicos**: Permitir que os usuários criem novos tópicos no fórum.
2. **Listar Tópicos**: Exibir todos os tópicos criados.
3. **Consultar Tópico Específico**: Obter os detalhes de um tópico específico.
4. **Atualizar Tópicos**: Editar as informações de um tópico existente.
5. **Deletar Tópicos**: Remover tópicos que não são mais necessários.

## 🛠️ Tecnologias Utilizadas

- **Java** com **Spring Framework**: Para implementação da API REST.
- **Banco de Dados MYSQL**: Para persistência das informações.
- **Autenticação e Autorização com Spring Security e JWT**: Para garantir a segurança e controle de acesso aos dados.


## 🛡️ Segurança e Validações

A API implementa:

- **Validações de Regras de Negócio**: Para garantir que os dados fornecidos pelos usuários estão corretos e dentro dos padrões esperados.
- **Autenticação/Autorização**: Restrição de acesso aos dados com base em permissões do usuário.

