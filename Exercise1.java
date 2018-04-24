package ass;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ch17811 on 21/03/2018.
 */

public class Exercise1 {
    public static void partA() {
        System.out.println("Part A");
        Random r = new Random();
        int rand1, rand2, ans, prod;
        int score = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            rand1 = r.nextInt(10) + 10;
            rand2 = r.nextInt(10) + 10;
            ans = rand1 * rand2;
            System.out.println("\n" + rand1 + " * " + rand2 + " = ?");
            prod = input.nextInt();
            if (prod == ans) {
                System.out.println("Well done! Your answer was correct!");
                score++;
            } else { System.out.println("Sorry, your answer was wrong..."); }
            System.out.println("Score: " + score + ". Number of questions: " + i + ".");
        }
    }

    public static void partB() {
        System.out.println("\nPart B\nEnter 'q' to quit");
        Random r = new Random();
        int rand1, rand2, ans;
        int i = 1;
        int score = 0;
        boolean state = true;
        Scanner input = new Scanner(System.in);
        while (state) {
            rand1 = r.nextInt(10) + 10;
            rand2 = r.nextInt(10) + 10;
            ans = rand1 * rand2;
            System.out.println("\nQuestion "  + i + "...\n" + rand1 + " * " + rand2 + " = ?");

            String userIn=input.nextLine();
            if (userIn.toLowerCase().equals("q")){
                break;
            }
            try {
                if (Objects.equals(ans, Integer.parseInt(userIn))) {
                    score++;
                    System.out.println("Well done! Your answer was correct!  Score: " + score);
                } else {
                    System.out.println("Sorry, your answer was wrong... The answer was " + ans + "Score: " + score);
                }
                i++;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input! Please input an integer or enter 'q' to quit");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Exercise 1 - Conor Hennessy - ch17811");
        partA();
        partB();
    }
}