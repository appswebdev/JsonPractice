package college.edu.tomer.jsonpractice.http;

import java.util.ArrayList;

import college.edu.tomer.jsonpractice.models.Movie;

/**
 * Created by master on 26/06/16.
 */
public interface OnMoviesArrived {
    public void onMoviesArrived(ArrayList<Movie> movies);
}
