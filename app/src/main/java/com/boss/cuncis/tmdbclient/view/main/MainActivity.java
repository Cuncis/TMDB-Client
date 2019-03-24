package com.boss.cuncis.tmdbclient.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.boss.cuncis.tmdbclient.R;
import com.boss.cuncis.tmdbclient.adapter.MovieAdapter;
import com.boss.cuncis.tmdbclient.data.model.Movie;
import com.boss.cuncis.tmdbclient.data.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieView{
    private static final String API_KEY = "d72e964a8778ea63c83ee06adaf4c1f7";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private MoviePresenter presenter;
    private MovieAdapter adapter;

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Movie Popular Today");
        movies = new ArrayList<>();

        progressBar = findViewById(R.id.progressbar);
        recyclerView = findViewById(R.id.recyclerview_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        presenter = new MoviePresenter(this);
        presenter.getAllPopularMovies(API_KEY);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(MovieResponse result) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        movies.addAll(result.getMovieResults());
        adapter = new MovieAdapter(movies, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
