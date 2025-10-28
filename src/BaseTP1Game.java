import java.util.Scanner;

public class BaseTP1Game {

	public static void main(String[] args) {
		System.out.println("Bonjour & bienvenue dans mon super jeu Java");
		Scanner sc = new Scanner(System.in);
		int mySecretNumber = 1 + (int) (Math.random() * 100);
		int userGuessing = -1;
		int userRounds = 0;

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
					System.out.println("Woot GG ! Tu as trouvé en " + userRounds + " coups...!");
					break;
				}
			} else { // !integer
				String bad = sc.next(); // consume invalid token
				System.out.println("Entrée invalide : " + bad);
			}

		}
		sc.close();// free scanner
	}

}
