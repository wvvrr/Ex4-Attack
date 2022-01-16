package t.defibot4.fr;

public class Victory {
	
	public static double[] ifVictoryPlayer(double xp_dmg, double xp_hp) {
		return new double[] {xp_dmg, xp_hp};
		
	}
	
	public static void sendVictoryPlayer(int i) {
		System.out.println("NOUVEAU BOT DE NIVEAU " + i);
	}
	
}
	


