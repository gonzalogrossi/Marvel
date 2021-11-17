package com.MarvelAPI.Marvel.Controllers.Response;



import java.util.List;


public class ResponseData {
    private List<ResponseResult> results;

    public List<ResponseResult> getResults() {
        return results;
    }

    public void setResults(List<ResponseResult> results) {
        this.results = results;
    }
}
