package fi.oletus;

import java.text.DecimalFormat;

/* This file is released to the public domain. */

public class VendingMachine {

	enum PaymentMethod { CELLPHONE, COINS };
	
	// TODO: Lisää luokka OutOfSolaException, jonka periytät luokasta Exception.
	
	int solaCount = 5;
	int profit = 0;
	
	void ostaSolaa(PaymentMethod m)
	{
		// TODO: Heitä OutOfSolaException, jos solaa ei ole.
		--solaCount;
		if (m == PaymentMethod.CELLPHONE)
		{
			profit += 199;
		}
		else {
			profit += 170;
		}
	}
	
	void kerroTilanne()
	{
		System.out.println("Solaa jäljellä: " + solaCount + " pulloa");
		DecimalFormat myFormat = new DecimalFormat("00");
		System.out.println("Tuottoa: " + (profit / 100) + "e " + myFormat.format(profit % 100) + "snt");
		
		if (solaCount == 0 && profit == 170*5) {
			System.out.println("Success!");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int solanTarve = 10; 
		VendingMachine solamaatti = new VendingMachine();
		while (solanTarve > 0)
		{
			// TODO: Nappaa OutOfSolaException
			solamaatti.ostaSolaa(PaymentMethod.COINS);
			--solanTarve;
		}
		solamaatti.kerroTilanne();
	}

}
