package college.edu.tomer.jsonpractice.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import college.edu.tomer.jsonpractice.R;
import college.edu.tomer.jsonpractice.http.MovieHandler;
import college.edu.tomer.jsonpractice.http.OnMoviesArrived;
import college.edu.tomer.jsonpractice.models.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieHandler.queryMovieAsync("star wars", new OnMoviesArrived() {
            @Override
            public void onMoviesArrived(ArrayList<Movie> movies) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Update the UI...
                    }
                });
            }
        });
    }
}
