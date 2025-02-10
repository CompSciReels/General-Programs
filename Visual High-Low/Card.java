public class Card 
{
	//Fields
	private int value;
	private String suit;
	
	public Card()
	{
		value = -1;
		suit = "suit";
	}
	
	public Card(int v, String s)
	{
		value = v;
		suit = s;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String showValue()
	{
		switch (value)
		{
		case 1: 
			return "Ace";
			
		case 2:
			return "Two";
			
		case 3:
			return "Three";
			
		case 4:
			return "Four";
			
		case 5:
			return "Five";
			
		case 6:
			return "Six";
			
		case 7:
			return "Seven";
		
		case 8:
			return "Eight";
			
		case 9:
			return "Nine";
			
		case 10:
			return "Ten";
		
		case 11:
			return "Jack";
			
		case 12:
			return "Queen";
		
		default:
			return "King";
		}
	}
}
