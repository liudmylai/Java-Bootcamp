public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        this.name = name;
        this.format = format;
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
        this.name = name;
    }
    public void setFormat(String format) {
        this.format = format;
        setSellingPrice(format);
        setRentalPrice(format);
    }
    public void setRating(double rating) {
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


}