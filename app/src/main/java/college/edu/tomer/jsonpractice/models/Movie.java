package college.edu.tomer.jsonpractice.models;

/**
 * Created by master on 26/06/16.
 */
public class Movie {
    private String title;
    private String plot = "";
    private String year;
    private String genres="";
    private String actors ="";
    private String imdbID;

    public Movie(String title, String plot, String year, String genres, String actors, String imdbID) {
        this.title = title;
        this.plot = plot;
        this.year = year;
        this.genres = genres;
        this.actors = actors;
        this.imdbID = imdbID;
    }

    public Movie(String title, String year, String imdbID) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
