package com.example.ayyan

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.ayyan.preseentation.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val movieListViewModel by viewModels<MovieListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel.movieList.observe(this, Observer { movieData ->
            //Log.e("TESTING", " ${movieData.get(0).imageUrl}")
        })
        //Toast.makeText(this, "None", Toast.LENGTH_SHORT).show()
    }
}