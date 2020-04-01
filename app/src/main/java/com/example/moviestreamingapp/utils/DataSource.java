package com.example.moviestreamingapp.utils;

import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovie(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Avenger", R.drawable.slide1,R.drawable.slide1));
        movieList.add(new Movie("1917",R.drawable.slide2,R.drawable.slide2));
        movieList.add(new Movie("Venom",R.drawable.slide3,R.drawable.slide3));
        movieList.add(new Movie("Replicas",R.drawable.slide4,R.drawable.slide4));

        return movieList;
    }

    public static List<Movie> getWeekMovie(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Replicas",R.drawable.slide4,R.drawable.slide4));
        movieList.add(new Movie("Venom",R.drawable.slide3,R.drawable.slide3));
        movieList.add(new Movie("1917",R.drawable.slide2,R.drawable.slide2));
        movieList.add(new Movie("Avenger", R.drawable.slide1,R.drawable.slide1));

        return movieList;
    }

}
