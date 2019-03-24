package com.boss.cuncis.tmdbclient.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
    @SerializedName("title")
    private String title;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("poster_path")
    private String movie_poster;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String movie_description;

    @SerializedName("vote_average")
    private String rating;

    public Movie() {
    }

    protected Movie(Parcel in) {
        title = in.readString();
        popularity = in.readString();
        movie_poster = in.readString();
        release_date = in.readString();
        movie_description = in.readString();
        rating = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getMovie_description() {
        return movie_description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(popularity);
        parcel.writeString(movie_poster);
        parcel.writeString(release_date);
        parcel.writeString(movie_description);
        parcel.writeString(rating);
    }
}
