package com.b2w.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwapiServiceTest {

    @Test
    public void deveObterRespostaDaApiStarWars(){
        SwapiService swapiService = new SwapiService();
        Integer quantidade = swapiService.quantidadeFilmesPorPlaneta("Tatooine");
        Assertions.assertEquals(new Integer(5), quantidade);
    }

    @Test
    public void deveObterRespostaDaApiStarWarsComPlanetaInexistente(){
        SwapiService swapiService = new SwapiService();
        Integer quantidade = swapiService.quantidadeFilmesPorPlaneta("Tatooine12356");
        Assertions.assertEquals(null, quantidade);
    }

}
