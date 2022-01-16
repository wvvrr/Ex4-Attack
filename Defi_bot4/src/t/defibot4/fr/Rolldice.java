package t.defibot4.fr;

import java.util.Random;


public class Rolldice {

	public static int getRolldice(int dice_min, int dice_max){
		Random randice = new Random();
		int dice1 = 1;
		int dice2 = 1;
		dice1 = randice.nextInt((dice_max - dice_min) + 1) + dice_min;
		dice2 = randice.nextInt((dice_max - dice_min) + 1) + dice_min;
		int dice = dice1 + dice2;
		return dice;
	}

}
