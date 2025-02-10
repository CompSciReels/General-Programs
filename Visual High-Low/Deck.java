public class Deck 
{
		private Card [] deck;
		private int cardsDealt; //keeps track of how many cards have been dealt. Also the counter for what card to deal next. 
		
		public Deck()
		{
			String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
			int d = 0;	//counter for the deck[]

			deck = new Card[52];
			cardsDealt = 0;
			
			for (String suit: suits)
			{
				for (int i = 1; i <= 13; i++)
				{
					deck[d] = new Card(i, suit);
					d++;
				}
			}
		}
		
		public void shuffle() //shuffles a deck of cards randomly
		{
			Card temp;
			int rand;
			
			for (int i = 0; i <= 51; i++)
			{
				//Pick a number from 0 to 51
				rand = (int)(Math.random() * 52);
				
				//Swap Card i with card rand
				temp = deck[rand];

				deck[rand] = deck[i];
				deck[i] = temp;
			}
			cardsDealt = 0;
		}
		
		public Card dealCard()
		{
			if (cardsDealt == 52)
			{
				shuffle();
				throw new IllegalStateException("No cards left in the deck!");
			}

			else
			{
				cardsDealt++;
				return deck[cardsDealt - 1];
			}
		}
}

