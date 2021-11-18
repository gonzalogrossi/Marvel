package com.MarvelAPI.Marvel.Logic;

import java.util.List;

public class Hero {
    private String id, name, description;
    private List<String> comics;

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

    public List<String> getComics() {
        return comics;
    }

    public void setComics(List<String> comics) {
        this.comics = comics;
    }


    public boolean Compare (Hero hero){
        return (hero.getId().equals(this.id) && hero.getName().equals(this.name) &&
                hero.getDescription().equals(this.getDescription()) && hero.getComics().equals(this.comics));
        }
}
