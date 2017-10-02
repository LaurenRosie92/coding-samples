import java.util.*;

public class hand
{
    public static void main(String[] args)
    {
	Deck the_deck = new Deck();
	Card[] hand;
	int i;
	Random gen = new Random();

	hand = new Card[10];
	the_deck.shuffle(gen);

	hand = deal_hand(the_deck);

	for ( i = 0; i < hand.length; i ++ )
	    System.out.println(hand[i].toString());
    }

    public static Card[] deal_hand(Deck a_deck)
    {
	int i, j;
	Card[] temp_hand = new Card[10];
	Card temp1, temp2;

	for ( i = 0; i < temp_hand.length; i ++ )
	{
	    temp1 = a_deck.deal();
	 
	    if ( i == 0 )
		temp_hand[i] = temp1;
	    else if ( i > 0 && temp_hand[i-1].compare_cards_value(temp1) < 0 )
		temp_hand[i] = temp1;
	    else if ( i > 0 && temp_hand[i-1].compare_cards_value(temp1) > 0 )
	    {
		temp2 = temp_hand[i-1];
		temp_hand[i-1] = temp1;
		temp_hand[i] = temp2;
	    }


	}
	for ( i = 0; i < temp_hand.length-1; i ++ )
	    for ( j = i+1; j < temp_hand.length; j ++ )
	    {
		if ( temp_hand[i].compare_cards_suit(temp_hand[j]) > 0 )
		{
		    temp2 = temp_hand[i];
		    temp_hand[i] = temp_hand[j];
		    temp_hand[j] = temp2;
		}
	    }
	return temp_hand;
    }
}
