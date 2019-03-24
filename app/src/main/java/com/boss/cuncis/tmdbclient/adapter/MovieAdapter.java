package com.boss.cuncis.tmdbclient.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.cuncis.tmdbclient.R;
import com.boss.cuncis.tmdbclient.data.model.Movie;
import com.boss.cuncis.tmdbclient.view.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        String imgPath = "https://image.tmdb.org/t/p/w500";

        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(movie.getRating());
        Picasso.get().load(imgPath + movie.getMovie_poster())
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvRating;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Movie selectedMovie = movieList.get(position);

                        Intent i = new Intent(context, DetailActivity.class);
                        i.putExtra("MOVIE_NAME", selectedMovie);
                        context.startActivity(i);
                    }
                }
            });
        }
    }

}
