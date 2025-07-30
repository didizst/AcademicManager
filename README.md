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

1. **Clonar o projeto**:
   ```bash
   git clone https://github.com/didizst/AcademicManager.git
   cd AcademicManager
   ```

2. **Compilar o projeto**:
   ```bash
   javac -d bin src/main/java/br/edu/espacos/auth/*.java src/main/java/br/edu/espacos/client/*.java src/main/java/br/edu/espacos/model/*.java src/main/java/br/edu/espacos/server/*.java src/main/java/br/edu/espacos/storage/*.java src/main/java/br/edu/espacos/view/*.java src/main/java/br/edu/espacos/App.java
   ```

3. **Iniciar o servidor**:
   ```bash
   java -cp bin br.edu.espacos.server.EspacosServer
   ```

4. **Iniciar o cliente**:
   ```bash
   java -cp bin br.edu.espacos.App
   ```

## Diagrama de classes

[Diagrama de Classes aqui](https://drive.google.com/file/d/1vA-TKxi2TvhuhqtbEnUCgr29XbcBLmm1/view?usp=drive_link)

## Diagrama de uso

[Diagrama de Uso aqui](https://drive.google.com/file/d/1jicyrXl7YjLzNtYMQ_k-JesdkJyVM5UC/view?usp=drive_link)

## Diagrama de dados

[Diagrama de Dados aqui](https://drive.google.com/file/d/14rJDOS_flgMN9AAxB69GwTuYMnTLrlDn/view?usp=drive_link)




