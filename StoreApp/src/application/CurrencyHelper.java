package application;

import java.text.NumberFormat;

public class CurrencyHelper {
	public static String formatMoney( double money) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(money);
		return moneyString;		
	}
}
