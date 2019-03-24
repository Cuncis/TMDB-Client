package com.boss.cuncis.tmdbclient.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.tmdbclient.R;
import com.boss.cuncis.tmdbclient.data.model.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgMovieLarge;
    private TextView tvTitle, tvSynopsis, tvRating, tvReleaseDate;

    private Movie movie;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movie = new Movie();

        imgMovieLarge = findViewById(R.id.img_movie_large);
        tvTitle = findViewById(R.id.tv_title);
        tvSynopsis = findViewById(R.id.tv_synopsis);
        tvRating = findViewById(R.id.tv_rating);
        tvReleaseDate = findViewById(R.id.tv_release_date);

        Intent intent = getIntent();

        if (intent.hasExtra("MOVIE_NAME")) {
            movie = getIntent().getParcelableExtra("MOVIE_NAME");
            Toast.makeText(this, "" + movie.getTitle(), Toast.LENGTH_SHORT).show();

            image = movie.getMovie_poster();
            String imgPath = "https://image.tmdb.org/t/p/w500" + image;
            Picasso.get().load(imgPath).into(imgMovieLarge);

            setTitle(movie.getTitle());
        }

        tvTitle.setText(movie.getTitle());
        tvSynopsis.setText(movie.getMovie_description());
        tvRating.setText(movie.getRating());
        tvReleaseDate.setText(movie.getRelease_date());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
