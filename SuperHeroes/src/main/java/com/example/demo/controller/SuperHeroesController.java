package com.example.demo.controller;

import com.example.demo.dto.HeroeDto;
import com.example.demo.service.HeroesService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SuperHeroesController {

  private HeroesService heroesService;

  public SuperHeroesController(HeroesService heroesService){
    this.heroesService = heroesService;
  }

  @GetMapping("/heroe/buscarPorNombre/{nombre}/{offset}")
  public List<HeroeDto> encontrarHeroePorNombre(@PathVariable String nombre, @PathVariable int offset) {
    return heroesService.encontrarHeroePorNombre(nombre, offset);
  }

  @PostMapping("/like/{id}")
  public String guardarLike(@PathVariable int id) {
    return heroesService.guardarLike(id);
  }

}