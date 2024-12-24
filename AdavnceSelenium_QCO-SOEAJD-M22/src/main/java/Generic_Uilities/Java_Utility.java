package Generic_Uilities;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid duplicate values
	 * @author Shobha
	 * @return
	 */
	public int getRandomNum() {

		Random ran = new Random();
		int value = ran.nextInt(2000);
		return value;

	}
}
