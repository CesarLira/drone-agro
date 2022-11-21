# Drone Agro
Solução web que recebe dados enviados por drones utilizados para coletar dados de agronegócio via sensores.


### Tecnologias Utilizadas

- Spring 

- Spring Mail

- H2 Database
  -> Utilizamos o H2 Database por atender as necessidade de armazenamento proposto no nosso projeto. É um banco de dados embutido e de facil integração
  com o Spring. Integramos com o H2 utilizando Spring Data JPA, caso seja necessário utilizar outro solução de banco de dados, teremos a 
  possibilidade de migração sem grandes problemas. 

- Spring Data JPA

- RabbitMQ

### Como rodar o projeto
```
mvn spring-boot:run
```

### Acessar documentação da API
-  Acesse o swagger -> http://localhost:8080/swagger-ui/index.html


### Acessar console do banco de dados 
- Acesse -> http://localhost:8080/h2-console
- JDBC URL : jdbc:h2:mem:droneagro-db
- User: sa 
- Pass: password

### Explicando a aplicação:
- A aplicação simula o recebimento de dados dos sensores de um drone. Ao gravar esses dados (aqui representados pela entidade "Analise"), produzimos uma mensagem para uma fila RabbitMQ.
- A mesma aplicação se encarrega de consumir a mensagem produzida (poderia ser outro microserviço). Através da mensagem recebida, a aplicação valida se os dados recebidos estão dentro dos padrões. Caso a temperatura seja maior que 35º ou menor que 0º ou a umidade seja menor que 15%, será emitido um alerta via e-mail.

### Como testar a aplicação:
- Utilizar o POST via swagger do endpoint _/drone_ para cadastrar um drone.

```Exemplo JSON inserção drone

  {
    "ativarRastreamento": true,
    "descricao": "Primeiro Drone"
  }
```
- Utilizar o POST via swagger do endpoint _/analise_ para simular a inserção de dados dos sensores do drone.

```Exemplo JSON inserção analise que dispara alerta

  {
    "ativarRastreamento": true,
    "descricao": "Primeiro Drone"
  }
```

> Note: Para a gravação do vídeo, fiz o teste utilizando um e-mail pessoal. Caso queira executar o teste completo, alterar a classe ConsumerQueue.java, na linha 39 o primeiro parâmetro é o e-mail de destino do alerta.

### Vídeo exemplo funcionamento aplicação

https://www.loom.com/share/48614601010c4be7b38bc20cb75d3ae6



https://user-images.githubusercontent.com/69155212/203151492-7818051b-6771-4e66-a1cc-4778cf2ec6af.mp4

