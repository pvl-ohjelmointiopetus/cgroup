import java.math.BigInteger;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

// This file is released to the public domain

public class Ackermann {
	
	// T‰ss‰ on esimerkin vuoksi k‰ytetty BigInteger-luokkaa,
	// vaikka funktiosta ei tulekaan niin hyv‰‰, ett‰ sit‰ oikeasti tarvittaisiin.
	// Muutamia BigInteger-vakioita:
	static final BigInteger ZERO = BigInteger.ZERO;
	static final BigInteger ONE = BigInteger.ONE;
	static final BigInteger MINUSONE = new BigInteger("-1");
	
	// V‰litulokset tallennetaan ackValues-mappiin.
	// Mapista saa avaimen (key) perusteella haettua siihen liittyv‰n
	// arvon (value), javassa metodilla get()
	
	// T‰ss‰ ulompaan Map-rakenteeseen on tarkoitus laittaa avaimeksi
	// m:n arvoja, ja sisemp‰‰n n:n arvoja.
	// N‰in voidaan hakea Ackermannin funktion tallennettuja arvoja sisemm‰st‰ mapista
	// k‰ytt‰m‰ll‰ m:‰‰ ja n:‰‰ avaimina.
	static Map<BigInteger, HashMap<BigInteger, BigInteger>> ackValues = 
			new TreeMap<BigInteger, HashMap<BigInteger, BigInteger>>(); 
	static long calculations = 0;
	static BigInteger biggestN = ZERO;
	
	public static BigInteger ack(BigInteger m, BigInteger n)
	{
		BigInteger returnValue = null;
				
		HashMap<BigInteger, BigInteger> mValues = ackValues.get(m);
		// TODO: Tarkista, lˆytyykˆ tallennettu tulos n:n kohdalta
		// mValues-mapista, ja jos lˆytyy, palauta se.
		
		// Varsinainen Ackermannin funktio
		if (m.equals(ZERO))
		{
			returnValue = n.add(ONE);
		}
		else if (n.equals(ZERO))
		{
			returnValue = ack(m.add(MINUSONE), ONE);
		}
		else {
			returnValue = ack(m.add(MINUSONE), ack(m, n.add(MINUSONE))); 
		}
		
		// Ker‰t‰‰n tilastoja siit‰, montako laskua tehtiin ja mik‰ oli isoin n:n arvo
		++calculations;
		if (n.compareTo(biggestN) > 0)
		{
			biggestN = n;
		}
		
		// TODO: V‰lituloksen tallennus
		// Tallenna t‰ss‰ paluuarvo mValues-mappiin,
		// tai jos mValues-mappia ei ole, luo uusi
		// mValues-mappi ja tallenna paluuarvo sinne
		
		return returnValue;
	}
	
	public static BigInteger ack(int m, int n) // Helpommin k‰ytett‰v‰ rajapinta ack-funktiolle
	{
		return ack(new BigInteger(Integer.toString(m)), new BigInteger(Integer.toString(n)));
	}
	
	public static void main(String[] args)
	{
		// ƒl‰ muokkaa t‰t‰ main-metodia, jos haluat s‰ilytt‰‰ tarkistusominaisuudet.
		
		initCache();
		
		long startTime = System.currentTimeMillis();
		
		BigInteger result = ack(3, 10);
		
		if (result.equals(new BigInteger("8189")))
		{
			System.out.print("You got the correct result for ack(3,10): ");
		}
		else {
			System.out.print("You got the wrong result for ack(3,10): ");
		}
		System.out.println(result);
		
		System.out.println("calculations done: " + calculations + ", biggest n: " + biggestN);
		
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Milliseconds spent: " + (timeSpent));
		
		// Tarkistuskoodi:
		if (calculations == 43107449l)
		{
			System.out.println("Hurrah! Correctly implemented fetching saved values from the map");
		}
		else if (calculations == 20281l)
		{
			System.out.println("Hurrah! Correctly implemented saving values to the map");
		}
		try {
			if (timeSpent < 500 && ack(3,11).equals(new BigInteger("16381")) && ack(3, 12).equals(new BigInteger("32765")))
			{
				System.out.println("Complete success!");
			}
		}
		catch (StackOverflowError e)
		{
			System.out.println("Fail! Stack overflow with ack(3,11) or ack(3, 12)");
		}
	}
	
	public static void initCache()
	{
		// Tallennetaan muutama ackermannin funktion tulos testitarkoituksiin.
		HashMap<BigInteger, BigInteger> mValues = new HashMap<BigInteger, BigInteger>();
		for (int i = 0; i < 100; ++i)
		{
			mValues.put(new BigInteger(Integer.toString(i)), new BigInteger(Integer.toString(i + 2)));
		}
		ackValues.put(ONE, mValues);
	}
}
