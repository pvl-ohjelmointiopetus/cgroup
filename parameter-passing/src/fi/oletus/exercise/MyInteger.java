package fi.oletus.exercise;

/* This file is released in the public domain */

public class MyInteger implements Cloneable {

	private int i = 0;
	public MyInteger(int a) {
		i = a;
	}
	
	public String toString()
	{
		return Integer.toString(i);
	}
	
	public void increase()
	{
		++i;
	}
	
	public Object clone()
	{
		try {
			return (MyInteger)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}
}
