package com.b2w.service;

import com.b2w.excecao.SwapiException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiService {

    public static final String API_URL = "https://swapi.dev/api/planets/?search=";

    public Integer quantidadeFilmesPorPlaneta(String nomePlaneta){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response
                    = restTemplate.getForEntity(API_URL + nomePlaneta, String.class);
            return this.prepararResultado(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SwapiException();
        }
    }

    private Integer prepararResultado(ResponseEntity<String> response){

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonObject jsonObject = this.deserialize(response.getBody());
            JsonArray resultado = jsonObject.get("results").getAsJsonArray();

            if (resultado.size() == 1) {
                JsonElement objeto = resultado.get(0);
                JsonArray filmes = objeto.getAsJsonObject().get("films").getAsJsonArray();
                return filmes.size();
            }
        }

        return null;
    }

    private JsonObject deserialize(String json) {
        Gson gson = new Gson();
        JsonObject jsonClass = gson.fromJson(json, JsonObject.class);
        return jsonClass;
    }
}
