package t.defibot4.fr;
import java.util.Random;


public class Attack {
	public static double estocPlayer(double setbothealth, double strength){ //Random
		double estoc = Rolldice.getRolldice(1,6) * strength;
		double result_health = setbothealth - estoc;
		return estoc;
	}
	
	public static void estocMessage(String playerpseudo, double estoc, int level, double strength, double bothealth, int tour) {
		System.out.println("------------------------------------------------------------");
		System.out.println(playerpseudo + " lance les dés... " + estoc);
		System.out.println(playerpseudo + " assène un coup de " + estoc + " sur le bot de niveau " + level + " avec une force de " + strength);
		System.out.println("BOT de niveau " + level + " - Santé " + bothealth + "%");
		System.out.println("Fin du tour " + tour);
		System.out.println("------------------------------------------------------------");
		tour++;
	}
	
	public static int[] unedeuxPlayer(int unedeux, int hlt) {
		return new int[] {unedeux, hlt};
	}
	
	public static void unedeuxMessage(String playerpseudo, int level, double strength, int tour, double bothealth, double playerhealth) {
		System.out.println("------------------------------------------------------------");
		System.out.println(playerpseudo + " empèche que le bot de niveau " + level + " attaque au prochain tour"  );
		System.out.println(playerpseudo + " assène un coup sur le bot de niveau " + level + " avec une force de " + strength);
		System.out.println("BOT de niveau " + level + " - Santé " + bothealth + "%");
		System.out.println(playerpseudo + " - Santé " + playerhealth + "%");
		System.out.println("Fin du tour " + tour);
		System.out.println("------------------------------------------------------------");
		
	}
	
	public static double retraitePlayer(double strength) {
		Random randhealth = new Random();
		int regen_min = 3;
		int regen_max = 10;
		double regen = randhealth.nextInt((regen_max - regen_min) + 1 ) + regen_min * strength;
		return regen;
	}
	
	public static void retraiteMessage(String playerpseudo, double playerhealth, int tour, double playerrecuphealth) {
		System.out.println("------------------------------------------------------------");
		System.out.println(playerpseudo + " recule pour récuperer de la vie " + playerrecuphealth);
		System.out.println(playerpseudo + " - Santé " + playerhealth + "%");
		System.out.println("Fin du tour " + tour);
		System.out.println("------------------------------------------------------------");
	}

}
