package com.boss.cuncis.tmdbclient.view.main;

import com.boss.cuncis.tmdbclient.data.model.MovieResponse;

public interface MovieView {
    void showLoading();
    void hideLoading();
    void showSuccess(MovieResponse result);
    void showError(String errorMessage);
}
