package com.MarvelAPI.Marvel.Controllers;

import com.MarvelAPI.Marvel.Controllers.Response.HeroResponse;
import com.MarvelAPI.Marvel.Controllers.Response.ResponseItem;
import com.MarvelAPI.Marvel.Logic.Hero;
import com.google.gson.Gson;
import org.springframework.util.DigestUtils;

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

    public Hero getID(String id) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/url.properties"));
        String hash = DigestUtils.md5DigestAsHex((1 + properties.getProperty("privateKey") + properties.getProperty("publicKey")).getBytes());
        String url = properties.getProperty("server") + properties.getProperty("port") +properties.getProperty("getHero") + id + 1 + properties.getProperty("publicKey")+ hash ;
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



    public String getMarvelHero (String receivedUrl) throws IOException {
        URL url = new URL(receivedUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        if (httpURLConnection.getResponseCode() != 200) {
            System.out.println(httpURLConnection.getResponseCode());
            // si algo sale mal , hago algo
            //throwExceptionByResponseCode(httpURLConnection.getResponseCode());
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String output = bufferedReader.readLine();
        httpURLConnection.disconnect();
        return output;
    }
}

