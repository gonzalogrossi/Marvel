package com.MarvelAPI.Marvel.Controllers;

import com.MarvelAPI.Marvel.Logic.Exceptions.InternalServerError;
import com.MarvelAPI.Marvel.Logic.Exceptions.NotAuthorized;
import com.MarvelAPI.Marvel.Logic.Exceptions.NotFoundException;
import com.MarvelAPI.Marvel.Logic.Hero;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
@RequestMapping("API/Marvel")
public class Controller {

    Service service = new Service();

   // @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getHeroID/{id}")
    public ResponseEntity<Hero> getHeroID(@PathVariable String id) {
        try {
            Hero hero = service.getID(id);
            return new ResponseEntity<>(hero, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NotAuthorized notAuthorized) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (IOException | InternalServerError internalServerError) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
