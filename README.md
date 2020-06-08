# Desafio B2W Woman

## Instruções

Criar a imagem do Mongodb:

```
docker build -t mongo-b2w .
```

Criar o container do Mongodb:

```
docker run --name anafrancielle -p 27017:27017 mongo-b2w
```

Executar aplicação:

- Linux
```
./mvnw spring-boot:run
```

- Windows
```
mvnw spring-boot:run
```
## Endpoints

| Método | Endpoint  
| ------------- | -------------
| GET | /planetas
| GET | /planetas/{id}
| GET | /planetas/busca={palavraChave}
| POST | /planetas
| PUT | /planetas/{id}
| DELETE | /planetas/{id}


Request:
```
{
    "nome": "Bespin",
    "clima": "temperate",
    "terreno": "gas giant", 
}
```
Response:
```
{
    "erro": null,
    "dados": [
        {
            "id": 5edda6861e6ce215c8473f54
            "nome": "Bespin",
            "clima": "temperate",
            "terreno": "gas giant",
            "qtdFilmes": 2
        }
    ]
}
```
Erro:
```
{
    "erro": "Ooops..alguma coisa deu errada.",
    "dados": null
}
```
