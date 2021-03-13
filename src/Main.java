import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

//Driver code
public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Game gameIntro=new Game("start");
        while (true) {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Game game = new Game();

                case 2:
                    return;
            }
        }
    }
}
