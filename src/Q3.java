import java.util.Scanner;
import java.util.Random;

public class Q3 {
    public static int generateSecret(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);

    }

    public static String getHint(int guess, int secret) {
        if (guess > secret) {
            return "Too high!";
        } else if (guess < secret) {
            return "Too low!";
        } else {
            return "Correct!";
        }
    }

    public static int calculateScore(int attempts){
        int score = 110 - (attempts * 10);

        if (score < 0) {
            return 0;
        }

        return score;
    }

    public static int playRound(Scanner scanner){
        int secret = generateSecret(1, 100);
        int attempts = 0;
        boolean correct = false;

        System.out.println("I'm thinking of a number between 1 and 100.");

        while (!correct) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            // Invalid guesses don't count
            if (guess < 1 || guess > 100) {
                System.out.println("Please guess between 1 and 100.");
                continue;
            }

            attempts++;

            String hint = getHint(guess, secret);
            System.out.println(hint);

            if (hint.equals("Correct!")) {
                correct = true;
            }
        }

        int score = calculateScore(attempts);

        System.out.println("You got it in " + attempts + " attempts!");
        System.out.println("Score: " + score);

        return attempts;
    }
    public static boolean askPlayAgain(Scanner sc) {

        System.out.print("Play again? (y/n): ");
        String answer = sc.next();

        return answer.equalsIgnoreCase("y");
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int roundsPlayed = 0;
        int totalScore = 0;
        int bestScore = 0;

        boolean playAgain = true;

        while (playAgain) {

            int attempts = playRound(sc);

            int score = calculateScore(attempts);

            roundsPlayed++;
            totalScore += score;

            if (score > bestScore) {
                bestScore = score;
            }

            playAgain = askPlayAgain(sc);
        }

        System.out.println();
        System.out.println("Game over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore);
        System.out.println("Best score: " + bestScore);

        sc.close();
    }
}



