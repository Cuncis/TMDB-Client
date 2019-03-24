package com.boss.cuncis.tmdbclient.view.main;

import com.boss.cuncis.tmdbclient.data.ApiClient;
import com.boss.cuncis.tmdbclient.data.TheMovieDbApi;
import com.boss.cuncis.tmdbclient.data.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter {
    private TheMovieDbApi theMovieDbApi;
    private MovieView view;

    public MoviePresenter(MovieView view) {
        this.view = view;
        theMovieDbApi = ApiClient.getTheMovieDbApi();
    }

    public void getAllPopularMovies(String apiKey) {
        view.showLoading();
        theMovieDbApi.getPopularMovies(apiKey)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        view.hideLoading();
                        if (response.isSuccessful()) {
                            view.showSuccess(response.body());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        view.hideLoading();
                        view.showError(t.getMessage());
                    }
                });
    }
}
