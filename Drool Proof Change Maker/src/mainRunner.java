import java.util.*;
import java.io.*;

public class mainRunner {
	
	public static int[] currency = new int[8];
	public static String currencyName;
	
	public static void main(String[] args) throws IOException 
	{
		fillCurrencyValues();
		calculateChange();
	}
	
	public static void fillCurrencyValues() throws IOException
	{
		Scanner file = new Scanner ( new File("currency.txt"));
		System.out.println("Which currency are we operating with? Select 1 for dollars, 2 for prime, 3 for binary, and 4 for mu--, I-I mean Base 3.");
		Scanner currencyChoice = new Scanner(System.in);
		int choice = currencyChoice.nextInt();
		
		if (choice == 1)
		{
			currencyName = "US Dollars";
			while (file.hasNext())
			{
				if(file.next().equals("US"))
				{
					for (int i = 0; i < 8; i++)
					{
						int value = Integer.parseInt(file.next());
						currency[i] = value;
						System.out.println(currency[i]);
					}
				}
			}
		}
		
		else if (choice == 2)
		{
			currencyName = "Primes";
			while (file.hasNext())
			{
				if(file.next().equals("Prime"))
				{
					for (int i = 0; i < 8; i++)
					{
						int value = Integer.parseInt(file.next());
						currency[i] = value;
						System.out.println(currency[i]);
					}
				}
			}
		}
		
		else if (choice == 3)
		{
			currencyName = "Binarys";
			while (file.hasNext())
			{
				if(file.next().equals("Binary"))
				{
					for (int i = 0; i < 8; i++)
					{
						int value = Integer.parseInt(file.next());
						currency[i] = value;
						System.out.println(currency[i]);
					}
				}
			}
		}
		
		else if (choice == 4)
		{
			currencyName = "Base-3s";
			while (file.hasNext())
			{
				if(file.next().equals("Base-3"))
				{
					for (int i = 0; i < 8; i++)
					{
						int value = Integer.parseInt(file.next());
						currency[i] = value;
						System.out.println(currency[i]);
					}
				}
			}
		}
		
		System.out.println("You have selected " + currencyName + " as your currency.");
		
	}
	
	public static void calculateChange()
	{
		int cost = 0;
		int amountPaid = 0;
		int[] changeBills = new int[8];
		
		System.out.println(" ");
		System.out.println("What is the price of the item you are trying to buy?");
		Scanner priceInput = new Scanner(System.in);
		cost = priceInput.nextInt();
		
		System.out.println("What are you paying for said item?");
		Scanner payInput = new Scanner(System.in);
		amountPaid = payInput.nextInt();
		
		int changeRequired = amountPaid - cost;
		System.out.println("Your change is " + changeRequired + " " + currencyName);
		System.out.println("");
		System.out.println("Change Returned:");
		
		for (int i = 7; i >= 0; i--)
		{
			if (changeRequired % currency[i] == 0)
			{
				int billsThatFit = changeRequired / currency[i];
				changeBills[i] = billsThatFit;
				System.out.println("Number of " + currency[i] + "'s: " + changeBills[i] );
				break;
			}
			else
			{
				int billsThatFit = changeRequired / currency[i];
				changeBills[i] = billsThatFit;
				changeRequired = changeRequired % currency[i];
				System.out.println("Number of " + currency[i] + "'s: " + changeBills[i] );
			}
			
		}
	}

}
