import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends GameStarterPack{
    List<Integer> numsOfGamer=new ArrayList<>(9); //random users' numbers
    List<Integer> luckyNums = new ArrayList<>(4); //random numbers to match in order to win
    User user=new User();
    Points points=new Points();
    Scanner scanner=new Scanner(System.in);

    //Starting a game
    Game(String start){
        intro();
    }
    //Interaction with user
    Game() throws SQLException {
        System.out.println("Enter your name:");
        user.setFirstName(scanner.nextLine());
        System.out.println("Enter your age:");
        user.setAge(scanner.nextInt());
        try {
            if (user.age < 18)
                throw new AgeException("Your age must be over or equal 18");
            else
                System.out.println("You can play this game");
        } catch (AgeException e) {
            System.out.println("Age must be greater than 18");
            System.exit(0);
            user.age = scanner.nextInt();
        }
        System.out.println("Your numbers:");
        for (int i = 0; i < 9; i++) {
            numsOfGamer.add(randomizer());
            System.out.print(numsOfGamer.get(i) + " ");
        }
        //interface randomizer to add find 4 lucky numbers
        RandomNum r =()->{
            for (int i = 0; i < 4; i++) {
                luckyNums.add(randomizer());
            }
        };
        r.luckyNumsRandom();
        matchChecker();
        specialNumChecker();
    }
    //Method to check regular matches
    public void matchChecker(){
            for (int i = 0; i < 4; i++) {
                System.out.println("\n" + (i + 1) + " lucky number: " + luckyNums.get(i));
                if (numsOfGamer.contains(luckyNums.get(i))) {
                    System.out.print("You got a match!");
                    points.implMatches();
                } else {
                    System.out.print("Unfortunately,you didnt get a match;");
                }
            }
            System.out.println("\nYou have "+points.getAmountOfMatches()+" matches. \n");
        }
        int choice;
    //Method to check special constant matches
        public void specialNumChecker() throws SQLException {
            if (points.getAmountOfMatches() >= 4) {
                System.out.println("Special numbers are 9,17 and 40");
                for (int i = 0; i < 3; i++) {
                    if (numsOfGamer.contains(specialNumbers[i])) {
                        points.implLuckyNum();
                    }
                }
                if(points.getAmountOfLuckyNum()<=1) {
                    System.out.println("You have " + points.getAmountOfLuckyNum() + " special number!");
                }else {
                    System.out.println("You have " + points.getAmountOfLuckyNum() + " special numbers!");
                }
                user.setUserMoney(points);
                System.out.println("You have won " + user.getUserMoney());
                user.insertUser(user);
                System.out.println("Continue game?\n1. Yes\n2. No");
                while(true){
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            numsOfGamer.clear();
                            System.out.println("Your numbers:");
                            for (int i = 0; i < 9; i++) {
                                numsOfGamer.add(randomizer());
                                System.out.print(numsOfGamer.get(i) + " ");
                            }
                            luckyNums.clear();
                            RandomNum r =()->{
                                for (int i = 0; i < 4; i++) {
                                    luckyNums.add(randomizer());
                                }
                            };
                            r.luckyNumsRandom();
                            matchChecker();
                            specialNumCheckerStartOver();
                            break;
                        case 2: break;
                    }
                }
            } else {
                System.out.println("Unfortunately,you didnt get at least 4 matches,so game is over.\n" +
                        "1. Play again\n2. Exit");
                while(true){
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            numsOfGamer.clear();
                            System.out.println("Your numbers:");
                            for (int i = 0; i < 9; i++) {
                                numsOfGamer.add(randomizer());
                                System.out.print(numsOfGamer.get(i) + " ");
                            }
                            //interface randomizer to add find 4 lucky numbers
                            luckyNums.clear();
                            RandomNum r =()->{
                                for (int i = 0; i < 4; i++) {
                                    luckyNums.add(randomizer());
                                }
                            };
                            r.luckyNumsRandom();
                            matchChecker();
                            specialNumChecker();
                            break;
                        case 2: return;
                    }
                }
            }
        }
    //Method to start game again
    public void specialNumCheckerStartOver() throws SQLException {
        if (points.getAmountOfMatches() >= 4) {
            System.out.println("Special numbers are 9,17 and 40");
            for (int i = 0; i < 3; i++) {
                if (numsOfGamer.contains(specialNumbers[i])) {
                    points.implLuckyNum();
                }
            }
            if(points.getAmountOfLuckyNum()<=1) {
                System.out.println("You have " + points.getAmountOfLuckyNum() + " special number!");
            }else {
                System.out.println("You have " + points.getAmountOfLuckyNum() + " special numbers!");
            }
            user.setUserMoney(points);
            System.out.println("You have won " + user.getUserMoney());
            user.updateUser(user);
            System.out.println("You have won that game!Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Unfortunately,you didnt get at least 4 matches,so game is over.\n" +
                    "1. Play again\n2. Exit");
            while(true){
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        numsOfGamer.clear();
                        System.out.println("Your numbers:");
                        for (int i = 0; i < 9; i++) {
                            numsOfGamer.add(randomizer());
                            System.out.print(numsOfGamer.get(i) + " ");
                        }
                        luckyNums.clear();
                        RandomNum r =()->{
                            for (int i = 0; i < 4; i++) {
                                luckyNums.add(randomizer());
                            }
                        };
                        r.luckyNumsRandom();
                        matchChecker();
                        specialNumChecker();
                        break;
                    case 2: return;
                }
            }
        }
    }




}
