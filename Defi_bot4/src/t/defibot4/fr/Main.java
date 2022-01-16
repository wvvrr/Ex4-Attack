package t.defibot4.fr;

import java.util.Random;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Player player1 = new Player(null, 100);
		Bot bot1 = new Bot();
		Scanner s = new Scanner(System.in);
		Random randice = new Random();
		Random randf = new Random();

		
		System.out.print("Quel est votre pseudo ? ");
		String pseudo = s.next();
		player1.setPseudo(pseudo);
		
		Scanner scanner = new Scanner(System.in);
		String readString = "";
		boolean isAlive = true;
		int min = 1;
		int max = 2;
		int level = 1;
		
		while (isAlive) {
			int tour = 1;
			System.out.println("------------------------------------------------------------");
			System.out.println("STAT DU BOT de niveau " + level +  " | Force du bot : " + bot1.getStrength() + " | Point de vie du bot : " + bot1.getHealth() + "%");
			System.out.println("STAT DE " + player1.getPseudo() +": " + " Force de " + player1.getPseudo() + " : " + player1.getStrength() + " | Point de vie de " + player1.getPseudo() + " : " + player1.getHeatlh() + "%");
			System.out.println("------------------------------------------------------------");
			do {
				int first_attack = randf.nextInt((max - min) + 1) + min;
				int botattack = Rolldice.getRolldice(1,6);
				if(first_attack == 1) {
					int attack = 0;
					boolean answer = true;
					while(answer) {
						System.out.println("Choisis 1 attaque parmis c'est 3 :");
						System.out.println("1. Estoc (Dégats aléatoire entre 1 et 12 fois votre force)");
						System.out.println("2. Une-deux (75% de chance de réussite, enleve 25HP, mais donne un tour gratuit et fais 15 de dégats)");
						System.out.println("3. Retraite (Récupère aléatoirement entre 3 et 10 hp fois votre force)");
						System.out.print("Quel attaquqe, 1, 2 ou 3 ? "); 
						Scanner sc = new Scanner(System.in);
						if(sc.hasNextInt()) {
							attack = sc.nextInt();
						}
							if(attack == 1) {
							System.out.println("vous utilisez Estoc");
								do{
									System.out.print(player1.getPseudo() + ", appuyer sur entrée pour lancer les dés");
									scanner.nextLine();
								}while(scanner.nextLine() != readString);
								double dice = Attack.estocPlayer(bot1.getHealth(), player1.getStrength());
								double n_bot_hlt = bot1.getHealth() - dice;
								bot1.setHealth(n_bot_hlt);
								Attack.estocMessage(player1.getPseudo(), dice, level, player1.getStrength(), bot1.getHealth(), tour);
								tour++;
								answer = false;
							}
							
							
							else if(attack == 2) {
								if(player1.getHeatlh() > 0 && bot1.getHealth() > 0) {
									Random random = new Random();
									int rmin = 1;
									int rmax = 4;
									int percentage = random.nextInt((rmax - rmin) + 1)  + rmin;
									if(percentage == 1 || percentage == 2 || percentage == 3) {
										System.out.println("vous utilisez Une-deux");
										int[] unedeux  = Attack.unedeuxPlayer(15, 25);
										double n_player_hlt = player1.getHeatlh() - unedeux[1];
										double n_bot_hlt = bot1.getHealth() - unedeux[0];
										player1.setHeatlh(n_player_hlt);
										bot1.setHealth(n_bot_hlt);
										Attack.unedeuxMessage(player1.getPseudo(), level, player1.getStrength(), tour, bot1.getHealth(), player1.getHeatlh());
										tour++;
									}
									
									else {
										System.out.println("Dommage votre attaque ne fonctionne pas");
										answer = false;
									}
								}
								else {
									break;

								}
							}
							
							else if(attack == 3) {
								System.out.println("vous utilisez Retraite");
								double retraite = Attack.retraitePlayer(player1.getStrength());
								double recup_hlt = player1.getHeatlh() + retraite;
								player1.setHeatlh(recup_hlt);
								Attack.retraiteMessage(player1.getPseudo(), player1.getHeatlh(), tour, retraite);
								tour++;
								answer = false;
							}
						}
					}

				else {
					double dice_bot = botattack * bot1.getStrength();
					System.out.println("Bot de niveau " + level + " lance les dés... " + dice_bot);
					System.out.println("Bot de niveau " + level + " assène un coup sur " + player1.getPseudo() + " avec une force de " + dice_bot);
					double resulthealth_player = player1.getHeatlh() - dice_bot;
					player1.setHeatlh(resulthealth_player);
					System.out.println(player1.getPseudo() + " - Santé " + player1.getHeatlh() + "%");
					System.out.println("Fin du tour " + tour);
					System.out.println("------------------------------------------------------------");
					tour++;
				}
			}while(player1.getHeatlh() > 0 && bot1.getHealth() > 0);
			
			if(player1.getHeatlh() <= 0) {
				System.out.println("VOUS AVEZ PERDU");
				isAlive = false;
			}
			else if(bot1.getHealth() <= 0) {
				System.out.println("VOUS AVEZ GAGNER");
				double[] xpbot = Victory.ifVictoryPlayer(1.3, 2.0);
				double xpplayer[] = Victory.ifVictoryPlayer(1.3, 2.0);
				bot1.setHealth(100);
				player1.setHeatlh(100);
				level++;
				double new_health_bot = (bot1.getHealth() + (xpbot[1]) * level);
				double new_strength_bot = xpbot[0] * level;
				double new_health_player = (player1.getHeatlh() + (xpplayer[1]) * level);
				double new_strength_player = xpplayer[0] * level;
				player1.setHeatlh(new_health_player);
				player1.setStrength(new_strength_player);
				bot1.setHealth(new_health_bot);
				bot1.setStrength(new_strength_bot);
				Victory.sendVictoryPlayer(level);
				System.out.println("------------------------------------------------------------");
			}
		}
	}
}
					