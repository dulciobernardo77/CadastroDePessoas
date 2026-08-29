# 📋 Cadastro de Pessoas

Um sistema web desenvolvido em **Spring Boot** para gerenciar pessoas e tarefas, com interface visual em Thymeleaf e relacionamento entre entidades. O projeto inclui listagem, cadastro, detalhes e navegação para as telas de pessoas e tarefas, com layout padronizado e correções de fluxo na camada UI.

## 🎯 Funcionalidades

- **Gerenciamento de Pessoas**
  - ✅ Cadastrar novas pessoas
  - ✅ Listar todas as pessoas
  - ✅ Visualizar detalhes completos de uma pessoa
  - ✅ Excluir pessoa do sistema
  - ✅ Visualização de tarefa atribuída em detalhes

- **Gerenciamento de Tarefas**
  - ✅ Criar novas tarefas
  - ✅ Listar todas as tarefas
  - ✅ Visualizar detalhes de uma tarefa
  - ✅ Excluir tarefa
  - ✅ Exibir funcionários vinculados à tarefa

- **Interface Web**
  - ✅ Layout visual consistente nas telas de pessoas e tarefas
  - ✅ Formulários com estrutura moderna e responsiva
  - ✅ Navegação entre listagem, cadastro e detalhes
  - ✅ Correções de rotas, binding de model e links quebrados

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| Java | 17 | Linguagem de programação |
| Spring Boot | 4.0.7 | Framework principal |
| Spring Data JPA | - | ORM e persistência |
| Spring Web MVC | - | API REST |
| Thymeleaf | - | Template HTML |
| Flyway | - | Migração de banco de dados |
| Lombok | - | Redução de boilerplate |
| Maven | - | Gerenciador de dependências |

## 📦 Estrutura do Projeto

```
src/main/java/dev/dulciobernardo7/CadastroDePessoas/
├── Pessoas/
│   ├── PessoaModel.java         # Entidade de Pessoa
│   ├── PessoaDTO.java           # Data Transfer Object
│   ├── PessoaController.java    # API REST
│   ├── PessoaControllerUI.java  # Interface web de pessoas
│   ├── PessoaService.java       # Lógica de negócio
│   ├── PessoaMapper.java        # Mapeamento DTO/Model
│   └── PessoasRepository.java   # Acesso a dados
├── Tarefas/
│   ├── TarefasModel.java        # Entidade de Tarefa
│   ├── TarefasDTO.java          # Data Transfer Object
│   ├── TarefasController.java   # API REST
│   ├── TarefasControllerUI.java # Interface web de tarefas
│   ├── TarefasService.java      # Lógica de negócio
│   ├── TarefasMapper.java       # Mapeamento DTO/Model
│   └── TarefasRepository.java   # Acesso a dados
└── CadastroDePessoaApplication.java # Classe principal

src/main/resources/
├── templates/
│   ├── listaPessoas.html
│   ├── adicionarPessoas.html
│   ├── detalhesPessoas.html
│   ├── listaTarefas.html
│   ├── adicionarTarefas.html
│   └── detalhesTarefas.html
├── static/
├── db/migrations/
└── application.properties
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Banco de dados (H2, PostgreSQL ou MySQL conforme configurado)

### Instalação

1. **Clone o repositório**
```bash
git clone https://github.com/dulciobernardo77/CadastroDePessoas.git
cd CadastroDePessoas
```

2. **Instale as dependências**
```bash
mvn clean install
```

3. **Execute a aplicação**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📡 Endpoints da API

### Pessoas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/pessoas/boavindas` | Mensagem de boas-vindas |
| POST | `/pessoas/cadastrar` | Cadastrar nova pessoa |
| GET | `/pessoas/lista` | Listar todas as pessoas |
| GET | `/pessoas/{id}` | Obter detalhes de uma pessoa |
| PUT | `/pessoas/{id}` | Atualizar pessoa |
| DELETE | `/pessoas/{id}` | Deletar pessoa |

### Tarefas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/tarefas/cadastrar` | Cadastrar nova tarefa |
| GET | `/tarefas/lista` | Listar todas as tarefas |
| GET | `/tarefas/{id}` | Obter detalhes de uma tarefa |
| PUT | `/tarefas/{id}` | Atualizar tarefa |
| DELETE | `/tarefas/{id}` | Deletar tarefa |

### Interface Web

| Rota | Descrição |
|------|-----------|
| `/pessoas/ui/lista` | Página de listagem de pessoas |
| `/pessoas/ui/adicionar` | Formulário de cadastro de pessoa |
| `/pessoas/ui/lista/{id}` | Detalhes de uma pessoa |
| `/tarefas/ui/lista` | Página de listagem de tarefas |
| `/tarefas/ui/adicionar` | Formulário de cadastro de tarefa |
| `/tarefas/ui/lista/{id}` | Detalhes de uma tarefa |

## 📋 Modelo de Dados

### Pessoa
- **ID**: Identificador único
- **Nome**: Nome completo
- **Idade**: Idade em anos
- **Nacionalidade**: País de origem
- **BI**: Documento de identificação
- **Sexo**: Gênero
- **Email**: Email único
- **Telefone**: Número único
- **Nível**: Nível ou cargo
- **Imagem URL**: Link para foto
- **Tarefa**: Referência à tarefa atribuída

### Tarefa
- **ID**: Identificador único
- **Nome da Tarefa**: Descrição/título
- **Dificuldade**: Nível de dificuldade
- **Pessoas**: Lista de funcionários vinculados à tarefa

## 🔄 Migração de Banco de Dados

As migrações são gerenciadas automaticamente pelo Flyway. Novo scripts de migração devem ser adicionados em:
```
src/main/resources/db/migrations/
```

## 🛣️ Roadmap

- [ ] Autenticação e autorização
- [ ] Sistema de roles/permissões
- [ ] Paginação em listagens
- [ ] Filtros avançados
- [ ] Edição de pessoa e tarefa via UI
- [ ] Relatórios em PDF
- [ ] Notificações por email
- [ ] Testes unitários e integração mais robustos
- [ ] Docker support

## 🤝 Contribuição

Contribuições são bem-vindas! Por favor:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

**Dulcio Bernardo**
- GitHub: [@dulciobernardo77](https://github.com/dulciobernardo77)

## 📞 Suporte

Para dúvidas ou problemas, abra uma issue no repositório ou entre em contato através do email.

---

**Última atualização**: 2026-08-29
