# Gerenciador de Ingressos Concorrente

Projeto desenvolvido em Java puro com foco em concorrência, comunicação em rede com sockets TCP e controle seguro de recursos compartilhados.

O sistema simula um servidor de venda de ingressos onde múltiplos clientes podem se conectar simultaneamente para realizar compras. Para garantir consistência, foi utilizado `ReentrantLock` na seção crítica.

---

## 🎯 Objetivo

Demonstrar na prática conceitos importantes como:

- Comunicação cliente-servidor via TCP
- Concorrência com múltiplas threads
- Sincronização com Lock
- Controle de recursos compartilhados
- Containerização com Docker

---

## 🛠 Tecnologias utilizadas

- Java
- Socket TCP
- Threads
- ReentrantLock
- Docker

---

## 📂 Estrutura do projeto

- **Program**  
  Inicializa o servidor

- **ServidorIngressos**  
  Abre a porta e aceita conexões

- **ClienteHandler**  
  Trata cada cliente em uma thread separada

- **Bilheteria**  
  Controla os ingressos e aplica sincronização

---

## ⚙️ Funcionamento

O servidor inicia com uma quantidade de ingressos disponíveis.

Quando um cliente envia:

```text
COMPRAR

O sistema:

Recebe a requisição
Cria uma thread para o cliente
Tenta realizar a compra
Retorna o resultado

Exemplo de resposta:

Ingresso comprado

ou

Ingresso indisponível
Concorrência

Cada cliente é tratado em uma thread independente.

A operação crítica de decremento dos ingressos é protegida por Lock, evitando problemas como:

Race condition
Venda duplicada
Inconsistência de dados

👨‍💻 Autor
Marlon Reis
---
