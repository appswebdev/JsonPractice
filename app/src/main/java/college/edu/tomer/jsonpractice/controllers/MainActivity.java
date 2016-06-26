package college.edu.tomer.jsonpractice.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import college.edu.tomer.jsonpractice.R;
import college.edu.tomer.jsonpractice.http.MovieHandler;
import college.edu.tomer.jsonpractice.http.OnMoviesArrived;
import college.edu.tomer.jsonpractice.models.Movie;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        MovieHandler.queryMovieAsync("dolly", new OnMoviesArrived() {
            @Override
            public void onMoviesArrived(final ArrayList<Movie> movies) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Movie m : movies) {
                            LayoutInflater inflater = getLayoutInflater();
                            View movieView = inflater.inflate(R.layout.movie_item, layout, false);

                            TextView tvTitle = (TextView) movieView.findViewById(R.id.tvTitle);
                            TextView tvPlot = (TextView) movieView.findViewById(R.id.tvPlot);
                            TextView tvYear = (TextView) movieView.findViewById(R.id.tvYear);

                            tvTitle.setText(m.getTitle());
                            tvPlot.setText(m.getPlot());
                            tvYear.setText(m.getYear());
                            layout.addView(movieView);
                        }
                    }
                });
            }
        });
    }
}
