package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException ("Name must contain a value");
        }
        this.name = name;
        if (!(format.equalsIgnoreCase("Blue-Ray") || format.equalsIgnoreCase("DVD"))) {
            throw new IllegalArgumentException ("Format must be Blue-Ray or DVD");
        }
        this.format = format;
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException ("Invalid rating");
        }
        this.rating = rating;
        this.isAvailable = true;
        setSellingPrice(format);
        setRentalPrice(format);
    }

    public Movie (Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
    }

    
    public String getName() {
        return this.name;
    }
    public String getFormat() {
        return this.format;
    }
    public double getRating() {
        return this.rating;
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    public double getSellingPrice() {
        return this.sellingPrice;
    }
    public double getRentalPrice() {
        return this.rentalPrice;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException ("Name must contain a value");
        }
        this.name = name;
    }
    public void setFormat(String format) {
        if (!(format.equalsIgnoreCase("Blue-Ray") || format.equalsIgnoreCase("DVD"))) {
            throw new IllegalArgumentException ("Format must be Blue-Ray or DVD");
        }
        this.format = format;
        setSellingPrice(format);
        setRentalPrice(format);
    }
    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException ("Invalid rating");
        }
        this.rating = rating;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    private void setSellingPrice (String format) {
        this.sellingPrice = ("Blue-Ray".equals(format)) ?  4.25 :  2.25;
    }
    private void setRentalPrice(String format) {
        this.rentalPrice = ("Blue-Ray".equals(format)) ? 1.99 : 0.99;
    }

    public String toString() {
        return "\t Name: " + this.name + "\n" +

               "\t Format: " + this.format + "\n" +

               "\t Rating: " + this.rating + "\n" +

               "\t Selling Price: " + this.sellingPrice + "\n" +

               "\t Rental Price: " + this.rentalPrice + "\n" +

               "\t Availability: " +  (isAvailable ? "in-stock" : "rented") + "\n";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) obj;
        return this.name.equals(movie.name) &&
               this.format.equals(movie.format) &&
               this.rating == movie.rating &&
               this.sellingPrice == movie.sellingPrice &&
               this.rentalPrice == movie.rentalPrice &&
               this.isAvailable == movie.isAvailable;
    }


}