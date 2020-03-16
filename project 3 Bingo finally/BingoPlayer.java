import java.util.*;
public class BingoPlayer
{
	private String First;
	private String Last;
	private Double Amount;
	private ArrayList<BingoCard> bingoCards = new ArrayList<BingoCard>();
	private ArrayList<BingoCard> winners = new ArrayList<BingoCard>();
	private int theCardnumber = 0; 


	public BingoPlayer(String first)
	{
		First = first;
		Last = "";
		Amount = 0.0;
	}

	public BingoPlayer(String first, String last, double amount)
	{
		// constructs a Bingo player with with a given first name, last name, and the initial amount of money. 
		// Note that initially the hand of a Bingo player is empty (no Bingo cards)
		First = first;
		Last = last;
		Amount = amount;
	}

	public String getFullName()
	{
		//returns the string representation of the full name of a
		//Bingo player (first name a blank and last name)
		String name = First + " " + Last;
		return name;
	}

	public String getFullInfo()
	{
		//returns the string representation of the full information 
		//(full name and the current amount of money) of a Bingo player (see example below)
		String info = First + " " + Last + " ($" +  Double.toString(Amount) + ")";
		return info;
	}

	public String toString()
	{
		//returns a string representation of a Bingo player together with his/her Bingo cards in his/her hand.
		String fullInfo = First + " " + Last + " ($" +  Double.toString(Amount) + ") \n";

		String[] output = new String[12];


		for(int i = 0; i < bingoCards.size(); i++)
		{
			BingoCard card = bingoCards.get(i);
			String stringify = card.toString();
			String[] lines = stringify.split("\n");
			for(int j = 0; j < 12; j++)
			{
				if(output[j] == null)
					output[j] = lines[j];
				else
					output[j] += " " + lines[j];
			}
		}
		for(int i = 0; i < 12; i++)
		{
			fullInfo += output[i] + "\n";
		}

		return fullInfo;
	}
		

	public BingoCard[] getBingoCards()
	{	
		//BingoCard[] aCard = new BingoCard[2];
		//BingoCard[0] = BingoCard[theCardnumber];
		
		BingoCard[] cards = winners.toArray(new BingoCard[0]);
		//cards[0].toSideBySideString();
		BingoCard oldCard = cards[0];
		System.out.println(oldCard.toSideBySideString());
		for(int i = 1; i < cards.length; i++) {
			if(!oldCard.toString().equals(cards[i].toString())) {
				System.out.println(cards[i].toSideBySideString());
			}
		}
		return cards;
		
		//return bingoCards.toArray(new BingoCard[0]);
		//toSideBySideString()
		//returns an array of type BingoCard that are winning cards. 
		//This method will be called by the host to verify whether the card(s) is the winning card(s).
	}

	public void clear()
	{
		//clears the player’s hand which must be called before starting a new round of game.
		bingoCards = new ArrayList<BingoCard>(Arrays.asList(getBingoCards()));
		
	}

	public void addBingoCards(BingoCard[] cards)
	{
		//adds Bingo cards into the player’s hand in the form of an array of BingoCard. 
		//Note that the parameter is an array of type BingoCard. 
		//The size of the array must be exactly the number of Bingo cards that the player wants to buy (and have enough money).
		for(int i = 0; i < cards.length; i++)
		{
			bingoCards.add(cards[i]);
		}
	}

	public int remove(int amount)
	{
		//remove a given amount of money
		if(Amount > amount)
		{
			Amount -= amount;
			return amount;
		}
		else
		{
			int amountRemove = Amount.intValue();
			Amount -= amountRemove;
			return amountRemove;
		}
	}

	public void add(double amount) 
	{
		//adds more money into the player’s pocket.
		Amount += amount;
	}

	
	public void marks(int number)
	{
		//marks all Bingo cards in the player’s hand that contain the given number.
		for(BingoCard card : bingoCards)
		{
			card.mark(number);
		}
	}
	
	public boolean isBingo()
	{
		//returns true or false whether the player has one or more winning card(s).
		/*
		for(int i = 0; i < bingoCards.size(); i++) {
			BingoCard card = bingoCards.get(i);
		}
		BingoCard card : bingoCards
		*/

		for(int i = 0; i < bingoCards.size(); i++)
		{
			//card.getNumber(row,column).isMarked()
			BingoCard card = bingoCards.get(i);
			outer: for(int row = 0; row < 5; row++)
			{
				for(int col = 0; col < 5; col++)
				{
					if(!card.getNumber(row,col).isMarked())
					{
						continue outer;
					}
				}
				//if we got here, all cards in this column must of been marked.
				winners.add(card);
				return true;				
			}

			outer: for(int col = 0; col < 5; col++)
			{
				for(int row = 0; row < 5; row++)
				{
					if(!card.getNumber(row,col).isMarked())
					{
						continue outer;
					}
				}
				//if we got here, all cards in this column must of been marked.
				winners.add(card);
				return true;
			}

			boolean foundUnmarked = false;
			for(int row = 0, col = 0; row < 5 && col < 5; row++, col++)
			{
				if(!card.getNumber(row,col).isMarked())
				{
					foundUnmarked = true;
				}
			}
			if(foundUnmarked == false)
			{
				winners.add(card);
				return true;
			}
				


			foundUnmarked = false;
			for(int row = 0, col = 4; row < 5 && col >= 0; row++, col--)
			{
				if(!card.getNumber(row,col).isMarked())
				{
					foundUnmarked = true;
				}
			}
			if(foundUnmarked == false)
			{
				winners.add(card);
				return true;
			}
		}
		return false;	
	}
}