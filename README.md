# Java Weather App

Aplicação de meteorologia desenvolvida em Java, executada no console, que utiliza a API Open-Meteo para pesquisar cidades e consultar informações meteorológicas em tempo real.

O projecto tem como objectivo praticar o consumo de APIs REST, o processamento de dados JSON, a programação orientada a objectos e o controlo de versões com Git e GitHub.

## Funcionalidades

- Pesquisa de cidades através do nome.
- Obtenção de coordenadas geográficas: latitude e longitude.
- Consulta de dados meteorológicos através de uma API externa.
- Apresentação da temperatura, humidade relativa e velocidade do vento.
- Apresentação da hora da medição meteorológica.
- Menu interactivo no console.
- Tratamento de entradas inválidas e falhas nas consultas, conforme implementado.

## Tecnologias utilizadas

| Tecnologia     | Finalidade |
|----------------|---|
| Java 23        | Linguagem de programação |
| Maven          | Gestão de dependências e construção do projecto |
| Jackson        | Processamento de respostas JSON |
| HttpClient     | Realização de requisições HTTP |
| Open-Meteo API | Obtenção de dados geográficos e meteorológicos |
| Git            | Controlo de versões |
| GitHub         | Alojamento do código-fonte |

## Como funciona

A aplicação executa o seguinte fluxo:

1. O utilizador introduz o nome de uma cidade.
2. O `GeocodingService` envia uma requisição à API de geocodificação.
3. A aplicação obtém as coordenadas geográficas da cidade.
4. O `WeatherService` utiliza as coordenadas para consultar a API meteorológica.
5. Os dados JSON são processados com Jackson.
6. As informações meteorológicas são apresentadas no console.

## Arquitectura do projecto

```text
java-weather-app/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── mz/
                └── co/
                    └── lxrd/
                        ├── Main.java
                        ├── model/
                        │   ├── CityData.java
                        │   └── WeatherData.java
                        └── services/
                            ├── GeocodingService.java
                            └── WeatherService.java
```

### Responsabilidades das classes

- **Main:** apresenta o menu e coordena a interacção com o utilizador.
- **CityData:** representa os dados da cidade, incluindo o nome, o país e as coordenadas geográficas.
- **WeatherData:** representa os dados meteorológicos obtidos.
- **GeocodingService:** pesquisa cidades e obtém as respectivas coordenadas.
- **WeatherService:** consulta a API meteorológica e processa a resposta.

## Requisitos

Antes de executar a aplicação, certifica-te de que tens:

- JDK 17 ou superior.
- Apache Maven instalado ou suporte Maven no IDE.
- Ligação à Internet.
- Acesso à API Open-Meteo.

## Instalação e execução

### 1. Clonar o repositório

```bash
git clone https://github.com/TEU-UTILIZADOR/java-weather-app.git
```

Substitui `TEU-UTILIZADOR` pelo teu nome de utilizador do GitHub.

### 2. Entrar no projecto

```bash
cd java-weather-app
```

### 3. Compilar o projecto

```bash
mvn clean package
```

### 4. Executar a aplicação

Abre o projecto no teu IDE e executa a classe `mz.co.lxrd.Main`.

Se o projecto estiver configurado com o Maven Exec Plugin, também podes executar:

```bash
mvn exec:java -Dexec.mainClass="mz.co.lxrd.Main"
```

## Exemplo de utilização

```text
===== JAVA WEATHER APP =====
1 - Consultar meteorologia
2 - Sair
Escolha uma opção: 1

Digite o nome da cidade: Maputo

===== RESULTADO METEOROLÓGICO =====
Cidade: Maputo
País: Moçambique
Temperatura: 19.9 °C
Humidade: 91%
Velocidade do vento: 4.0 km/h
Hora da medição: 2026-10-11T22:45
```

*Os valores apresentados são meramente ilustrativos. Os dados reais variam conforme a localização e a hora da consulta.*

## API utilizada

O projecto utiliza os seguintes serviços da Open-Meteo:

- [Geocoding API](https://open-meteo.com/en/docs/geocoding-api) — pesquisa de cidades e coordenadas geográficas.
- [Weather Forecast API](https://open-meteo.com/en/docs) — consulta de condições meteorológicas.

A aplicação depende de uma ligação à Internet para obter novos dados.

Consulta as condições de utilização da API antes de utilizar o projecto comercialmente.

## Persistência de dados

A versão actual não utiliza uma base de dados. As consultas são realizadas directamente à API e os resultados são processados durante a execução da aplicação.

## Testes e validação

Os testes devem abranger:

- Pesquisa de cidades existentes.
- Pesquisa de cidades inexistentes.
- Entradas vazias ou inválidas.
- Falhas de ligação à Internet.
- Respostas HTTP com erro.
- Processamento de respostas JSON.

## Desenvolvimento

O projecto é desenvolvido incrementalmente, com Git e GitHub para registar a evolução através de commits descritivos.

Exemplos de mensagens de commit:

```text
feat: implement console menu
feat: implement city geocoding
feat: fetch current weather
fix: handle invalid city search
docs: improve project README
```

## Melhorias futuras

- Previsão meteorológica para vários dias.
- Pesquisa de cidades favoritas.
- Cache das consultas meteorológicas.
- Testes automatizados.
- Melhorias no tratamento de erros.

## Autor

**Jaime Fernando**

Estudante de Engenharia de Tecnologias e Sistemas de Informação, com interesse no desenvolvimento de software e na construção de aplicações práticas em Java.
