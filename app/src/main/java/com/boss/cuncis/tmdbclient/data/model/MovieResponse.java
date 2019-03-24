package com.boss.cuncis.tmdbclient.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    List<Movie> movieResults;

    public List<Movie> getMovieResults() {
        return movieResults;
    }
}
