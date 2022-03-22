package models;
import java.util.Arrays;

public class Team {
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    public Team (String house, String keeper, String seeker, String[] chasers) {
        if (house == null || house.isBlank()) {
            throw new IllegalArgumentException("house cannot be null or blank");
        }
        this.house = house;
        if (keeper == null || keeper.isBlank()) {
            throw new IllegalArgumentException("keeper cannot be null or blank");
        }
        this.keeper = keeper;
        if (seeker == null || seeker.isBlank()) {
            throw new IllegalArgumentException("seeker cannot be null or blank");
        }
        this.seeker = seeker;
        if (chasers.length != 3) {
            throw new IllegalArgumentException("chasers number must be equal 3");
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team (Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    public String getHouse() {
        return house;
    }
    public String getKeeper() {
        return keeper;
    }
    public String getSeeker() {
        return seeker;
    }
    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    public void setHouse(String house) {
        this.house = house;
    }
    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }
    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }
    public void setChasers(String[] chasers) {
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +         
                "Seeker: "  + this.seeker + "\n" +         
                "Chasers: " + Arrays.toString(this.chasers) + "\n"; 
    }

    /**
    * Function name: hasNull
    * @param array
    * @return (boolean)
    * 
    * Inside the function:
    *    1. return false;
    */
    public static boolean hasNull(String[] array) {
        // for (String value : array) {
        //     if (value == null) {
        //         return true;
        //     }
        // }
        // return false;
        return Arrays.stream(array)
            .anyMatch(value -> value == null);
    }
}
