package com.example.moviestreamingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.moviestreamingapp.models.Movie;
import com.example.moviestreamingapp.adapters.MovieAdapter;
import com.example.moviestreamingapp.adapters.MovieItemClickListener;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Slide;
import com.example.moviestreamingapp.adapters.SliderPagerAdapter;
import com.example.moviestreamingapp.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> slideList;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rvMovies,rv_movies_week;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initSlider();
        initPopularMovies();
        initWeekMovies();

    }

    private void initWeekMovies() {
        MovieAdapter weekMovieAdapter = new MovieAdapter(HomeActivity.this,DataSource.getWeekMovie(),HomeActivity.this);
        rv_movies_week.setAdapter(weekMovieAdapter);
        rv_movies_week.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initPopularMovies() {
        //Recycler view setup


        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovie(),this);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initSlider() {
        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.slide1,"Slide text1 \nmore text here"));
        slideList.add(new Slide(R.drawable.slide2,"Slide text2 \nmore text here"));
        slideList.add(new Slide(R.drawable.slide3,"Slide text3 \nmore text here"));
        slideList.add(new Slide(R.drawable.slide4,"Slide text4 \nmore text here"));

        SliderPagerAdapter sliderAdapter = new SliderPagerAdapter(HomeActivity.this,slideList);
        sliderPager.setAdapter(sliderAdapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),3000,3000);

        indicator.setupWithViewPager(sliderPager,true);
    }

    private void initView() {
        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        rvMovies = findViewById(R.id.rvMovies);
        rv_movies_week = findViewById(R.id.rv_movies_week);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //sending movie info to detail activity
        //transition animation between 2 activities
        Log.d("Hi", "onMovieClick: " + movie.getTitle());

        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                HomeActivity.this,movieImageView,"sharedName"
        );

        startActivity(intent,activityOptions.toBundle());

    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem()<slideList.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
