package com.example.moviestreamingapp.adapters;

import android.widget.ImageView;

import com.example.moviestreamingapp.models.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImageView);
}
