package t.defibot4.fr;

public class Bot {
	private String bot = "Tarpaud";
	private double strength = 1;
	private double health = 100;
	
	public Bot() {
	}
	
	public String getBot(){
		return bot;
	}
	
	public double getStrength(){
		return strength;
	}
	
	public void setStrength(double new_strength_bot) {
		this.strength = new_strength_bot;
	}
			
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double new_health_bot) {
		this.health = new_health_bot;
	}
	
}

