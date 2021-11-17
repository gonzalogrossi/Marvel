package com.MarvelAPI.Marvel.Controllers.Response;


import java.util.List;

public class ResponseComic {
    private List<ResponseItem> items;

    public List<ResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ResponseItem> items) {
        this.items = items;
    }
}
