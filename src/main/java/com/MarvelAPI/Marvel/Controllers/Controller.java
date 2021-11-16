package com.MarvelAPI.Marvel.Controllers;

import com.MarvelAPI.Marvel.Logic.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;


import java.io.IOException;

@RestController
@RequestMapping("API/Marvel")
public class Controller {


    @GetMapping("/getHeroID/{id}")
    public ResponseEntity<Hero> getHeroID(@PathVariable String id){
        try{
            Hero hero = new Hero();
            return new ResponseEntity<>(hero,HttpStatus.OK);
        } catch( HttpServerErrorException.InternalServerError e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
