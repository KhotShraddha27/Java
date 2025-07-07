package com.dkte;
	public class Array
	{
	    public static void main(String[] args)
	    {
	        String[] array1 = {"red", "green", "blue", "yellow"};
	        String[] array2 = {"orange", "green", "purple", "red"};

	        System.out.println("Common values between the arrays:");
	        for (String s1 : array1)
	        {
	            for (String s2 : array2)
	            {
	                if (s1.equals(s2))
	                {
	                    System.out.println(s1);
	                }
	            }
	         }
	    }
	}	