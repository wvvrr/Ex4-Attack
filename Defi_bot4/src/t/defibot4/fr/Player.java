package t.defibot4.fr;

public class Player {
	public String pseudo = null;
	public double health = 100;
	public double strength = 1;
		
	public Player(String pseudo, int health) {
		this.pseudo = pseudo;
		this.health = health;
	}


	public String getPseudo() {
		return pseudo;
	}
		
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
		
	public double getStrength(){
		return strength;
	}
	
	public void setStrength(double new_strength_player) {
		this.strength = new_strength_player;
	}
	
	public double getHeatlh(){
		return health;
	}

	public void setHeatlh(double new_health_player) {
		this.health = new_health_player;
		
	}

}

