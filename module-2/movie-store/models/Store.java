package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }
    public Movie getMovie(String name) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                return new Movie(this.movies.get(i));
            }
        }
        return null;
    }

    public void setMovie(Movie movie, int index) {
        this.movies.set(index, new Movie(movie));  
    }

    /**
     * Name: addMovie
     * 
     * @param movie
     * Inside the function:
     * 1. Adds the movie to the ArrayList
     */
    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
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
        if (movies.isEmpty()) {
            throw new IllegalStateException("Store not in a valid state to perform action");
        }
        if (!(action.equalsIgnoreCase("sell") || action.equalsIgnoreCase("rent") || action.equalsIgnoreCase("return"))) {
            throw new IllegalArgumentException("Action must be sell, rent or return");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        for (int i=0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sell": 
                    if (!(movies.get(i).getIsAvailable())) {
                        throw new IllegalStateException("Cannot sell movie that was rented out"); 
                    }
                    this.movies.remove(i);
                    break;
                    case "rent":
                    this.movies.get(i).setIsAvailable(false);
                    break;
                    case "return":
                    this.movies.get(i).setIsAvailable(true);
                    break;
                }
            } 
        }
    }

    public String toString() {
        String temp = "";
        for (int i=0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}