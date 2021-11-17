package com.MarvelAPI.Marvel.Controllers.Response;


public class ResponseResult {
    private String id, name, description;
    private ResponseComic comics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ResponseComic getComics() {
        return comics;
    }

    public void setComics(ResponseComic comics) {
        this.comics = comics;
    }
}
