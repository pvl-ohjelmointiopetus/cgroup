package fi.oletus;

import java.util.ArrayList;
import java.util.List;

/* This file is released to the public domain */

public class PrimeGenerator {
	
	public static List<Long> primes = new ArrayList<Long>();

	public static void generatePrimes(Long upTo)
	{
		// TODO: tee alkulukugeneraattori, joka t‰ydent‰‰ 
	    // primes-taulukkoon alkulukuja, kunnes seuraava lis‰tt‰v‰ alkuluku
		// olisi suurempi kuin upTo.
		
		// Tee generaattorista sellainen, ett‰ se jatkaa alkulukujen generointia
		// suurimmasta primes-taulukossa valmiiksi olevasta luvusta.
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long upTo = new Long(1000); // Alkulukuja generoidaan t‰h‰n arvoon asti
		primes.add(new Long(2));
		primes.add(new Long(3)); // Lis‰t‰‰n muutama luku valmiiksi, ett‰ p‰‰st‰‰n nihkeist‰ erikoistapauksista eroon
		generatePrimes(upTo);
		System.out.println(primes.size());
		if (primes.size() == 168)
		{
			System.out.println("Success!");
		}
	}

}
