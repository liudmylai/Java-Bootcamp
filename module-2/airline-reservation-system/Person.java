import java.util.Arrays;

public class Person{
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

    public Person(String name, String nationality, String dateOfBirth, int seatNumber, String[] passport) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.seatNumber = seatNumber;
        this.passport = Arrays.copyOf(passport,passport.length);
    }
    public Person(Person sourse) {
        this.name = sourse.name;
        this.nationality = sourse.nationality;
        this.dateOfBirth = sourse.dateOfBirth;
        this.seatNumber = sourse.seatNumber;
        this.passport = Arrays.copyOf(sourse.passport, sourse.passport.length);
    }
    public String[] getPassport() {
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public String getName() {
        return this.name;
    }
    public String getNationality() {
        return this.nationality;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    /**
     *  Function name: applyPassport
     *  @return (boolean)
     *
     *  Inside the function:
     *     1. Returns a random boolean of true or false.
     */
    public boolean applyPassport() {
       int number = (int)(Math.random() * 2);
       return (number == 0) ? false : true;
    }
    /**
     *  Function name: chooseSeat
     *
     *  Inside the function:
     *    1. Sets this.seat to a random number between 1 -- 11.
     */
    public void chooseSeat() {
        this.seatNumber = (int)(Math.random() * 11 + 1);
    }
}