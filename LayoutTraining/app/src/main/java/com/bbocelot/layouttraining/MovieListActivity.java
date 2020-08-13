package com.bbocelot.layouttraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private List<Movie> movies;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movies = generateMovieList();
        setContentView(R.layout.activity_movie_list);
        setupRecyclerView();
        setupFloatingButton();
    }

    private void setupFloatingButton() {
        FloatingActionButton fab = findViewById(R.id.activity_movie_list__fb_add);
        fab.setOnClickListener(v -> this.onAddClick());
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.activity_movie_list__rv_movies);
        movieAdapter = new MovieAdapter(movies, this::onMovieClick);
        recyclerView.setAdapter(movieAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private void onMovieClick(Movie movie) {
        Toast.makeText(MovieListActivity.this, movie.name, Toast.LENGTH_SHORT).show();
    }

    private void onAddClick() {
        movies.add(generateNewMovie());
        movieAdapter.notifyDataSetChanged();
    }

    private Movie generateNewMovie() {
        return new Movie("Cat pic", "you've asked for", R.drawable.silver_the_cat);
    }

    private List<Movie> generateMovieList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "movie no 1", 0));
        movies.add(new Movie("2", "movie no 2", 0));
        movies.add(new Movie("3", "movie no 3", 0));
        movies.add(new Movie("4", "movie no 4", 0));
        movies.add(new Movie("5", "movie no 5", 0));
        movies.add(new Movie("6", "movie no 6", 0));
        return movies;
    }


}