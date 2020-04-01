package com.example.moviestreamingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.adapters.CastAdapter;
import com.example.moviestreamingapp.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieThumbImg;
    private ImageView movieCoverImg;
    private TextView tv_title;
    private TextView tv_desc;
    private FloatingActionButton play_fab;
    private RecyclerView rvCast;

    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        initViews();

        //Setup Cast Item
        setupRvCast();


    }

    private void setupRvCast() {
        List<Cast> mData = new ArrayList<>();
        mData.add(new Cast("Ant Man",R.drawable.antman));
        //mData.add(new Cast("Iron Man",R.drawable.ironman));
        mData.add(new Cast("Thor",R.drawable.thor));
        mData.add(new Cast("Captain America",R.drawable.captain_america));
        mData.add(new Cast("Spider Man",R.drawable.spiderman));

        castAdapter = new CastAdapter(MovieDetailActivity.this,mData);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(MovieDetailActivity.this,LinearLayoutManager.HORIZONTAL,false));

    }

    void initViews(){
        rvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);

        String movieTitle = getIntent().getExtras().getString("title");
        int movieImgURL = getIntent().getExtras().getInt("imgURL");
        int movieCoverImgURL = getIntent().getExtras().getInt("imgCover");

        movieThumbImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(movieImgURL).into(movieThumbImg);
        movieThumbImg.setImageResource(movieImgURL);

        movieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(movieCoverImgURL).into(movieCoverImg);

        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);

        getSupportActionBar().setTitle(movieTitle);

        tv_desc = findViewById(R.id.detail_movie_desc);

        //setup animation
        movieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }
}
