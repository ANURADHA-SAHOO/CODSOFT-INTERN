import java.util.Random;
import java.util.Scanner;
class NumberGame{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 10000;
        int maxAttempts = 10;
        int totalRounds = 3; // You can change the number of rounds as needed

        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + " - Guess the number between " + minRange + " and " + maxRange);

            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1; // Increase score based on attempts left
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + targetNumber);
            }
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}