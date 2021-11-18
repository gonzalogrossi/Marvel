package com.MarvelAPI.Marvel.Controllers;

import com.MarvelAPI.Marvel.Controllers.Response.HeroResponse;
import com.MarvelAPI.Marvel.Controllers.Response.ResponseItem;
import com.MarvelAPI.Marvel.Logic.Exceptions.InternalServerError;
import com.MarvelAPI.Marvel.Logic.Exceptions.NotAuthorized;
import com.MarvelAPI.Marvel.Logic.Exceptions.NotFoundException;
import com.MarvelAPI.Marvel.Logic.Hero;
import com.google.gson.Gson;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.HttpServerErrorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Service {

    public Hero getID(String id) throws IOException, NotFoundException, NotAuthorized, InternalServerError {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/url.properties"));
        Properties properties2 = new Properties();
        properties2.load(new FileReader("src/main/resources/configuration.properties"));
        String hash = DigestUtils.md5DigestAsHex((1 + properties2.getProperty("privateKey") + properties2.getProperty("publicKey")).getBytes());
        String url = properties2.getProperty("server") +":"+properties2.getProperty("port")+properties.getProperty("getHero")+"/" + id +"?ts="+ 1 +"&apikey="+ properties2.getProperty("publicKey")+"&hash="+ hash ;
        String jsonHero = getMarvelHero(url);
        Gson gson = new Gson();
        HeroResponse heroResponse = gson.fromJson(jsonHero,HeroResponse.class);
        Hero hero = new Hero();
        hero.setId(heroResponse.getData().getResults().get(0).getId());
        hero.setDescription(heroResponse.getData().getResults().get(0).getDescription());
        hero.setName(heroResponse.getData().getResults().get(0).getName());
        List<String> comics = new ArrayList<>();
        for (ResponseItem item : heroResponse.getData().getResults().get(0).getComics().getItems()){
            comics.add(item.getName());
        }
        hero.setComics(comics);
        return hero;
    }



    public String getMarvelHero (String receivedUrl) throws IOException, NotFoundException, NotAuthorized, InternalServerError {
        URL url = new URL(receivedUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        if (httpURLConnection.getResponseCode() != 200) {
            if(httpURLConnection.getResponseCode() == 401) {
                throw new NotAuthorized();
            }
            if(httpURLConnection.getResponseCode() == 500) {
                throw new InternalServerError();
            }
            if(httpURLConnection.getResponseCode() == 404) {
                throw new NotFoundException();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String output = bufferedReader.readLine();
        httpURLConnection.disconnect();
        return output;
    }
}

