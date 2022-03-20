package models;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
     * Function name: contains
     * @param movie
     * @return (boolean)
     * 
     * Inside the function:
     *    1. checks if movies list contains() movie.
     */
    public boolean contains(Movie movie) {
        return this.movies.contains(movie);
    }

    /**
    * Function name: sellMovie
    * @param name (String)
    * 
    * Inside the function:
    *  1. Loop runs through every element
    *  2. Remove
    */
    public void sellMovie(String name) {
        if (!(this.movies.get(getMovieIndex(name)).getIsAvailable())) {
            throw new IllegalStateException("Cannot sell rented movie");
        }
        this.movies.removeIf(movie -> movie.getName().equals(name));
    }

    /**
    * Function name: getMovieIndex 
    * @param name (String) 
    * @return (int)
    * 
    * Inside the function:
    *     1. returns index if it finds a movie. 
    *     2. returns -1000 otherwise.
    * 
    */
    public int getMovieIndex(String name) {
        return IntStream.range(0, this.movies.size())
            .filter(index -> this.movies.get(index).getName().equals(name))
            .findFirst()
            .orElse(-1000);
        // int index = -1000;
        // for (int i = 0; i < this.movies.size(); i++) {
        //     if (movies.get(i).getName().equals(name)) {
        //         index = i;
        //         break;
        //     }
        // }
        // return index;
    }

     /**
    * Function name: rentMovie
    * @param name (String)
    * 
    * Inside the function:
    *  1. Loop runs through every element
    *  2. Set the matching element's availability to false.
    */
    public void rentMovie(String name) {
        this.movies.get(getMovieIndex(name)).setIsAvailable(false);
        // for (int i = 0; i < this.movies.size(); i++) {
        //     if (this.movies.get(i).getName().equals(name)) {
        //         this.movies.get(i).setIsAvailable(false);
        //     }
        // }

    }

     /**
    * Function name: returnMovie
    * @param name (String)
    * 
    * Inside the function:
    *   1. Set the movie's availability to true.
    */
    public void returnMovie(String name) {
        this.movies.get(getMovieIndex(name)).setIsAvailable(true);

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