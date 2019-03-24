package com.boss.cuncis.tmdbclient.data;

import com.boss.cuncis.tmdbclient.data.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbApi {
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);
}
