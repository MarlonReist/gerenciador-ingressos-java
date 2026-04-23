# Gerenciador de Ingressos Concorrente

Projeto desenvolvido em Java puro com foco em programação concorrente, comunicação em rede com sockets TCP e controle seguro de recursos compartilhados.

O sistema simula um servidor de venda de ingressos, no qual múltiplos clientes podem se conectar simultaneamente para realizar compras. Para garantir consistência no acesso à quantidade de ingressos disponíveis, foi utilizado `Lock` (`ReentrantLock`) na seção crítica.

## Objetivo

O objetivo deste projeto é demonstrar, na prática, conceitos importantes de desenvolvimento back-end e sistemas concorrentes, como:

- comunicação cliente-servidor via sockets TCP
- atendimento simultâneo de múltiplos clientes com threads
- sincronização de acesso a variável compartilhada
- prevenção de condição de corrida (race condition)
- containerização da aplicação com Docker

## Tecnologias utilizadas

- Java
- Socket TCP
- Threads
- Lock / ReentrantLock
- Docker

## Estrutura do projeto

- `Program`  
  Classe principal responsável por iniciar o servidor.

- `Bilheteria`  
  Classe que controla a quantidade de ingressos disponíveis e protege a seção crítica com `Lock`.

- `ServidorIngressos`  
  Responsável por abrir a porta do servidor e aceitar conexões de clientes.

- `ClienteHandler`  
  Classe que trata cada cliente em uma thread separada.

## Como funciona

O servidor inicia com uma quantidade definida de ingressos disponíveis.

Quando um cliente se conecta e envia o comando `COMPRAR`, o servidor:

1. recebe a requisição
2. cria uma thread para atender o cliente
3. tenta realizar a compra de forma sincronizada
4. retorna uma resposta informando se a compra foi concluída ou se os ingressos acabaram

## Exemplo de fluxo

Cliente envia:

```text
COMPRAR
