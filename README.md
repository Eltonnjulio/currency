# Currency Exchange API
### Não necessita de autenticação

- ##### Consultar câmbio de uma determinada moeda - GET - /api/v1/rates/{baseCurrencyId}/exchange - `use o baseCurrencyId:1 para teste` 

- ##### Atualizar câmbios - PATCH - /api/v1/rates/{id} - Autenticação necessária
Se adicionar o câmbio MZN-USD de acordo com a variação diária do câmbio só poderá atualizar, consultando depois o histórico de variação desse câmbio, que é registado a cada atualização.

- ##### Verificar histórico de Câmbio - GET - /api/v1/rates/{rateId}/history 
Na verificação do histórico pode ainda filtrar os históricos do câmbio por datas `startDate e endDate -  dd-MM-YYYY` podendo colocar uma ou ambas datas. Sendo que, ao colocar apenas startDate irá buscar histórico de datas iguais ou superior e colocando apenas endDate igual ou inferior.

- ##### Gerir Moedas, Câmbios, Provedores 
  Também é possivel adicionar, eliminar, listar todos, buscar, eliminar apenas um(por id), moedas, provedores(de câmbio)

## Como executar?

Na raiz do projecto:
- `mvnw clean install -DskipTests`
- `java -jar target/currency-0.0.1-SNAPSHOT.jar`


-Poderá encontrar uma documentação mais interativa da API no endereço `http://localhost:8080/swagger-ui/`

## Alternativa para executar

Executar na raiz do projecto:
- `mvn Spring-boot:run .`

