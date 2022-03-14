package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(Movie movie, int index) {
        movies.set(index, new Movie(movie));  
    }

    /**
     * Name: addMovie
     * 
     * @param movie
     * Inside the function:
     * 1. Adds the movie to the ArrayList
     */
    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }
 
    /**
     * Name: action
     * 
     * @param name
     * @param action
     * 
     * Inside the function:
     * 1. Runs three cases: sell, rent, and return
     *   - sell - Removes the movie that matches the name passed in
     *   - rent - Sets isAvailable equal to false for the  movie that matches the name passed in
     *   - return - Sets isAvailable equal to true for the  movie that matches the name passed in     
     */
    public void action(String name, String action) {
        for (int i=0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                switch(action) {
                    case "sell": 
                    movies.remove(i);
                    break;
                    case "rent":
                    movies.get(i).setIsAvailable(false);
                    break;
                    case "return":
                    movies.get(i).setIsAvailable(true);

                }
            } 
        }
    }

    public String toString() {
        String temp = "";
        for (int i=0; i < movies.size(); i++) {
            temp += movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}