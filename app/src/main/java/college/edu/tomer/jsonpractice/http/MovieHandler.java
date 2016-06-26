package college.edu.tomer.jsonpractice.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import college.edu.tomer.jsonpractice.models.Movie;

/**
 * Created by master on 26/06/16.
 */
public class MovieHandler {
    public static ArrayList<Movie> queryMovie(String movieName) throws IOException, JSONException {

        ArrayList<Movie> movieList = new ArrayList<>();
        String API = "http://www.omdbapi.com/?y=&plot=full&r=json&s=" + movieName;
        String apiAddress = String.format("%s%s", API, movieName);
        String json = HttpHandler.getUrl(apiAddress);

        JSONObject jsonObject = new JSONObject(json);
        JSONArray moviesArr = jsonObject.getJSONArray("Search");
        for (int i = 0; i < moviesArr.length(); i++) {
            JSONObject movieObject = moviesArr.getJSONObject(i);

            String title = movieObject.getString("Title");
            String year = movieObject.getString("Year");
            String imdbID = movieObject.getString("imdbID");

            Movie m = new Movie(title, year, imdbID);
            movieList.add(m);
        }
        return movieList;
    }

    public static void  queryMovieAsync(final String query, final OnMoviesArrived listener){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ArrayList<Movie> movies = queryMovie(query);
                    listener.onMoviesArrived(movies);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }
}
