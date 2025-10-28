import java.util.Scanner;

/**
 * JavaDoc just for test Mon super jeu Java Guess My Number
 */

public class BaseTP1Game {

	public static void main(String[] args) {
		System.out.println("Bonjour & bienvenue dans mon super jeu Java");
		Scanner sc = new Scanner(System.in);
		int mySecretNumber = 1 + (int) (Math.random() * 100); // random integer between 1 & 100
		int userGuessing = -1; // Initialize to '-1' to enter game loop
		int userRounds = 0;
		boolean keepPlaying = true;

		while (keepPlaying) {
			// reset new game
			mySecretNumber = 1 + (int) (Math.random() * 100);
			userGuessing = -1;
			userRounds = 0;

			while (userGuessing != mySecretNumber) {
				System.out.print("Saisir un entier entre 1 et 100 : ");

				if (sc.hasNextInt()) { // check integer
					userGuessing = sc.nextInt(); // read it
					userRounds++; // add a round

					if (userGuessing < 1 || userGuessing > 100) { // check bounds
						System.out.println("Merci de rester entre 1 et 100.");
					} else if (userGuessing < mySecretNumber) { // too small
						System.out.println("C'est plus.");
					} else if (userGuessing > mySecretNumber) { // too big
						System.out.println("C'est moins.");
					} else { // GG
						System.out.println("Woot GG ! Tu as trouvé en " + userRounds + " coups !");
						break;
					}
				} else { // !integer
					String bad = sc.next(); // consume invalid token
					System.out.println("Entrée invalide : " + bad);
				}
			}

			String playAgainAnswer;

			do { // loop while answer != 'o' || 'n'
				System.out.print("Rejouer ? (o/n) : ");
				playAgainAnswer = sc.next().trim().toLowerCase();
				if (playAgainAnswer.equals("o")) {
					keepPlaying = true; // play again
				} else if (playAgainAnswer.equals("n")) {
					System.out.println("Bye...!");// bye
					keepPlaying = false;
				} else {
					System.out.println("Réponse invalide : o/n.");
				}
			} while (!playAgainAnswer.equals("o") && !playAgainAnswer.equals("n"));
		}

		sc.close(); // free scanner
	}

}
