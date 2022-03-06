package com.example.demo.service;

import com.example.demo.dto.HeroeDto;
import com.example.demo.dto.RespuestaDto;
import com.example.demo.persist.Conexion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
public class HeroesService {

  @Value("${marvel.url}")
  public String marvelUrl;

  @Value("${publicKey}")
  public String publicKey;

  @Value("${privateKey}")
  public String privateKey;

  private final RestTemplate restTemplate;

  public HeroesService(RestTemplateBuilder restTemplate) {
    this.restTemplate = restTemplate.build();
  }

  public List<HeroeDto> encontrarHeroePorNombre(String nombre, int offset){
    List<HeroeDto> heroeDtoList = new ArrayList<>();
    RespuestaDto respuesta = restTemplate.getForObject(generarUrl() + "&nameStartsWith=" + nombre + "&offset=" + offset + "&limit=10", RespuestaDto.class);

    heroeDtoList = Arrays.asList(respuesta.getData().getResults());

    return heroeDtoList;
  }

  public String generarUrl(){
    long ts = System.currentTimeMillis();
    return marvelUrl + "characters?ts=" + ts + "&apikey=" + publicKey + "&hash=" + hashGenerator(ts);
  }

  private String hashGenerator(Long ts){
    String password = ts + privateKey + publicKey;
    return DigestUtils.md5Hex(password);
  }

  public String guardarLike(int id) {
    Conexion conexion = new Conexion();

    conexion.guardaLike(id);
  return "OK";
  }
}
