# 💣 Campo Minado

Jogo clássico do Campo Minado desenvolvido em Java com interface gráfica Swing.

## 📋 Descrição

Um jogo de Campo Minado completo implementado em Java, utilizando o padrão Observer para gerenciamento de eventos e uma interface gráfica intuitiva com Swing.

## 🎮 Como Jogar

- **Clique esquerdo**: Abre um campo
- **Clique direito**: Marca/desmarca um campo como mina
- **Objetivo**: Abrir todos os campos que não contêm minas
- **Cuidado**: Se abrir um campo com mina, você perde!

## 🚀 Funcionalidades

- ✅ Tabuleiro configurável (16 linhas x 30 colunas com 50 minas)
- ✅ Sistema de marcação de minas
- ✅ Abertura automática de campos vizinhos quando não há minas ao redor
- ✅ Detecção de vitória e derrota
- ✅ Reinício automático do jogo
- ✅ Interface gráfica responsiva com Swing

## 🛠️ Tecnologias Utilizadas

- **Java SE**
- **Swing** (Interface Gráfica)
- **Padrão Observer** (Gerenciamento de Eventos)

## 📂 Estrutura do Projeto

```
CampoMinado2/
├── src/
│   ├── App.java
│   └── br/com/zaqueo/cm/
│       ├── modelo/
│       │   ├── Campo.java
│       │   ├── CampoEvento.java
│       │   ├── CampoObservador.java
│       │   └── Tabuleiro.java
│       └── visao/
│           ├── BotaoCampo.java
│           ├── PainelTabuleiro.java
│           └── TelaPrincipal.java
├── bin/
└── lib/
```

## 🎯 Arquitetura

### Modelo (Model)

- **Campo**: Representa cada célula do tabuleiro
- **Tabuleiro**: Gerencia o tabuleiro completo, minas e lógica do jogo
- **CampoEvento**: Enumeração dos eventos possíveis
- **CampoObservador**: Interface para o padrão Observer

### Visão (View)

- **TelaPrincipal**: Janela principal do jogo
- **PainelTabuleiro**: Painel que contém todos os botões do tabuleiro
- **BotaoCampo**: Botão customizado para cada campo

## ▶️ Como Executar

### Pré-requisitos

- Java JDK 8 ou superior instalado

### Executando o Jogo

1. Clone o repositório:
```bash
git clone https://github.com/ZAQU3O/campo-minado-2.git
```

2. Navegue até a pasta do projeto:
```bash
cd CampoMinado2
```

3. Compile o projeto:
```bash
javac -d bin src/br/com/zaqueo/cm/**/*.java
```

4. Execute o jogo:
```bash
java -cp bin br.com.zaqueo.cm.visao.TelaPrincipal
```

Ou simplesmente execute a classe `TelaPrincipal.java` pela sua IDE favorita.

## 🎨 Características Técnicas

- **Padrão Observer**: Comunicação entre modelo e visão
- **Programação Funcional**: Uso de Streams e Lambdas
- **Swing Threading**: `SwingUtilities.invokeLater()` para thread-safety
- **Encapsulamento**: Separação clara entre lógica de negócio e interface

## 📝 Configurações

Para alterar o tamanho do tabuleiro e quantidade de minas, edite a classe `TelaPrincipal.java`:

```java
Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas, minas);
// Exemplo: new Tabuleiro(16, 30, 50)
```

## 👨‍💻 Autor

**ZAQU3O**

## 📄 Licença

Este projeto é livre para uso educacional e pessoal.

---

⭐ **Divirta-se jogando Campo Minado!** ⭐
