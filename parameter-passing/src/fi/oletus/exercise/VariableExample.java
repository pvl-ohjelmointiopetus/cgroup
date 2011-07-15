package fi.oletus.exercise;

public class VariableExample {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int i = 0;
		Integer javaInteger = new Integer(0);
		MyInteger myInteger = new MyInteger(0);
		increase(i);
		increase(javaInteger);
		increase(myInteger);
		System.out.println("primitive type: " + i);
		System.out.println("java integer type: " + javaInteger);
		System.out.println("my integer type: " + myInteger);
		myInteger = new MyInteger(0);
		increaseClone(myInteger);
		System.out.println("my integer type after cloning: " + myInteger);
	}
	
	private static void increase(int x) {
		++x;
	}
	
	private static void increase(Integer x) {
		x = x + 1;
	}
	
	private static void increase(MyInteger x) {
		x.increase();
	}
	
	private static void increaseClone(MyInteger x) {
		x = (MyInteger) x.clone();
		x.increase();
	}

}
