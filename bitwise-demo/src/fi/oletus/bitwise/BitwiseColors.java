package fi.oletus.bitwise;

/* This file is released to the public domain */

public class BitwiseColors {

	
	static final int RED_MASK = 0xFF0000;
	static final int GREEN_MASK = 0x00FF00;
	static final int BLUE_MASK = 0x0000FF;
	
	public static int mixColors(int c1, int c2, float c1portion) {
		/* TODO: Kirjoita koodi, joka sekoittaa värejä c1 ja c2 siten, 
		että c1:n suhteellinen osuus lopputuloksesta on c1portion
		ja c2:n suhteellinen osuus lopputuloksesta on 1 - c1portion.
		
		c1 ja c2 koostuvat kolmesta 8 bitin komponentista: 
		punainen, vihreä ja sininen, jotka on pakattu yhteen kokonaislukuun.
		Tehtävä onnistuu bitshift-operaattoreilla (>> ja <<)
		sekä binäärisillä & ja | -operaattoreilla. */
		return 0x000000;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int color1 = 0xB23344; // RGB #1
		int color2 = 0x15A1C1; // RGB #2
		
		int color3 = mixColors(color1, color2, 0.5f);
		System.out.println("Red: " + ((color3 & RED_MASK) >> 16));
		System.out.println("Green: " + ((color3 & GREEN_MASK) >> 8));
		System.out.println("Blue: " + (color3 & BLUE_MASK));
		if (checkResult(color3, 99, 106, 130))
		{
			System.out.println("Success!");
		}
		
		color3 = mixColors(color1, color2, 0.75f);
		System.out.println("Red 2: " + ((color3 & RED_MASK) >> 16));
		System.out.println("Green 2: " + ((color3 & GREEN_MASK) >> 8));
		System.out.println("Blue 2: " + (color3 & BLUE_MASK));
		if (checkResult(color3, 138, 78, 99))
		{
			System.out.println("Another success!");
		}
	}
	
	public static boolean checkResult(int color, int redShouldBe, int greenShouldBe, int blueShouldBe)
	{
		int red = ((color & RED_MASK) >> 16);
		int green = ((color & GREEN_MASK) >> 8);
		int blue = (color & BLUE_MASK);
		return Math.abs(red - redShouldBe) < 2 && Math.abs(green - greenShouldBe) < 2 && Math.abs(blue - blueShouldBe) < 2;
	}

}
