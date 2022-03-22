import models.*;

public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("GRYFFINDOR", "Oliver", "Harry", 
        new String[] {"Angelina", "Ginny", "Katie"});
    
        Team team2 = new Team("SLYTHERIN", "Vincent",  "Draco", 
        new String[] {"Bridget", "Harper", "Malcolm"});

        System.out.println(team1);
        System.out.println(team2);
    }
    
}
