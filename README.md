# AcademicManager
# Sistema de Gestão de Espaços Acadêmicos

## Descrição

Este projeto é um sistema de gestão de espaços acadêmicos desenvolvido em Java, que permite o cadastro, reserva e gerenciamento de diferentes tipos de espaços em uma instituição de ensino. O sistema possui funcionalidades para administradores e usuários comuns, incluindo:

- Cadastro e gerenciamento de espaços (salas de aula, laboratórios, auditórios, etc.)
- Reserva de espaços por usuários
- Gerenciamento de usuários e permissões
- Geração de relatórios e exportação de dados

## Funcionalidades

### Para Administradores
- Cadastrar, editar e remover espaços
- Gerenciar usuários (criar, promover/rebaixar, desativar)
- Visualizar todas as reservas
- Gerar relatórios estatísticos
- Exportar dados em formato CSV

### Para Usuários Comuns
- Visualizar espaços disponíveis
- Fazer reservas de espaços
- Cancelar suas próprias reservas
- Visualizar suas reservas ativas
- Exportar comprovantes de reserva

## Tecnologias Utilizadas

- Linguagem: Java
- Interface Gráfica: Swing
- Armazenamento: Arquivos TXT (persistência de dados)
- Comunicação: Sockets TCP/IP (cliente-servidor)

## Estrutura do Projeto

```
java_project_space/
├── src/
│   ├── br/edu/espacos/
│   │   ├── model/          # Modelos de dados (Espaco, Usuario, Reserva, etc.)
│   │   ├── view/           # Interfaces gráficas
│   │   ├── client/         # Cliente para comunicação com o servidor
│   │   ├── server/         # Lógica do servidor
│   │   ├── storage/        # Persistência em arquivos
│   │   ├── auth/           # Autenticação de usuários
│   │   ├── util/           # Utilitários (logger, etc.)
│   │   └── App.java        # Classe principal
├── data/                   # Arquivos de dados (criados em tempo de execução)
│   ├── espacos.txt         # Dados dos espaços
│   ├── reservas.txt        # Dados das reservas
│   └── usuarios.txt        # Dados dos usuários
└── README.md               # Este arquivo
```

## Pré-requisitos

- Java JDK 11 ou superior
- IDE de sua preferência (Eclipse, IntelliJ, VS Code, etc.)

## Como Executar

1. **Compilar o projeto**:
   ```bash
   javac -d bin src/br/edu/espacos/*.java src/br/edu/espacos/**/*.java
   ```

2. **Iniciar o servidor**:
   ```bash
   java -cp bin br.edu.espacos.server.EspacosServer
   ```

3. **Iniciar o cliente**:
   ```bash
   java -cp bin br.edu.espacos.App
   ```

## Diagrama de classes

<img width="3432" height="2861" alt="class_diagram" src="https://github.com/user-attachments/assets/8bd8cfc9-8549-473a-b944-259a5d53668a" />

## Diagrama de uso

<img width="3222" height="271" alt="use_case_diagram (2)" src="https://github.com/user-attachments/assets/eeb856a8-285f-4d17-964a-c5310524c6a9" />

## Diagrama de dados

<img width="451" height="463" alt="der_diagram (1)" src="https://github.com/user-attachments/assets/556d2e8a-cfe7-4d83-b51b-3cca7419090e" />





