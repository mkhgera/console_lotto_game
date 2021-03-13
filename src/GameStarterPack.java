import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameStarterPack {
    int[] specialNumbers={3,19,40}; //default constant lucky numbers

    //number randomizer
    int randomizer() {
        Random num = new Random();
        return num.nextInt(20);
    }

    //Game greeting
    void intro() {
        System.out.println("Hello!" + "Welcome to our game \n"+
                "Rules:\nAs you enter the game, you will get 9 random numbers. If they match 4 lucky numbers, you will win 10000 tenge.\n" +
                "If they match 4 lucky numbers and 1 special number, you will win 20000 tenge.\n" +
                "If they match 4 lucky numbers and 2 special numbers, you will win 50000 tenge.\n" +
                "If they match 4 lucky numbers and all special numbers, you will win 100000 tenge.\n"+
                "1. Continue \n2. Exit");
    }

    //methods to implement by Game class
    abstract void matchChecker();
    abstract void specialNumChecker() throws SQLException;
}