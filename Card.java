import java.util.*;

public class Card
{
    private int  number; // 2, 3, ..,10, J=11, Q=12, K=13, A=1
    private char suit;  // C=Clubs, D=diamonds, H=Hearts, S=Spades
    private int  _random_number;

    // name: generate_random_values
    // desc: randomly assigns a value for number and suit
    // params: Card c, Random gen
    // return: void 
    // 1) generate a random integer between 2 and 14 for the card's number
    // 2) generate a random integer between 0 and 3 for the suit, 
    //    0 means C, 1 means D,
    //    2 means H, 3 means S. 

    // access method
    public void set_random_number(int r)
    {
	_random_number = r;
    }

    public int get_random_number()
    {
	return _random_number;
    }

    // 14 to 2
    // num % ( 14 - 2 + 1) + 2
    // num % ( 13 ) + 2
    // [0...12] + 2
    // [2...14]
    public Card(Random gen)
    {
	int num;

	this.number = Math.abs( gen.nextInt() ) % 13 + 1;

	num = Math.abs( gen.nextInt() ) % 4;
	
	if ( num == 0 )
	    this.suit = 'C';
	else if ( num == 1 )
	    this.suit = 'D';
	else if ( num == 2 )
	    this.suit = 'H';
	else
	    this.suit = 'S';
    }

    public Card(int number, char suit)
    {
	this.number = number;
	this.suit   = suit;
    }
    // name: toString
    // desc: returns a string that can be printed.  It will be a more verbose
    //           user-friendly format.  ex: Ace of Spades, King of 
    //           Hearts, 3 of Diamonds. 
    // params: Card c
    // return: String
    // 1) create a string, set it to the empty string
    // 2) if the number is 14, add "Ace" to the string,
    // 3) else if the number is 13, add "King" to the string,
    // 4) else if the number is 12, add "Queen" to the string,
    // 5) else if the number is 11, add "Jack" to the string,
    // 6) else add the number to the string. 
    // 7) add " of " to the string. 
    // 8) if the suit is C, add "Clubs" to the string
    // 9) else if the suit is D, add "Diamonds" to the string
    // 10) else if the suit is H, add "Hearts" to the string
    // 11) else add "Spades" to the string
    // 12) return the string
    public String toString()
    {
	String display = "";

	if ( this.number == 1 )
	    display += "Ace";
	else if ( this.number == 13 )
	    display += "King";
	else if ( this.number == 12 )
	    display += "Queen";
	else if ( this.number == 11 )
	    display += "Jack";
	else
	    display += this.number;

	display += " of ";

	if ( this.suit == 'C' )
	    display += "Clubs";
	else if ( this.suit == 'D' )
	    display += "Diamonds";
	else if ( this.suit == 'H' )
	    display += "Hearts";
	else 
	    display += "Spades";
	
	return display;
    }


    // name: compare cards
    // desc: compares two cards.  uses the number first.  
    //        breaks ties with the suit. 
    // params: Card a, Card b
    // return: int - return 1 if a > b, return -1 a < b, return 0 if a == b
    // 1) if a's number is greater than b's number, return 1
    // 2) if a's number is less than b's number, return -1
    // 3) if a's suit is greater than b's suit, return 1
    // 4) if a's suit is less than b's suit, return -1
    // 5) return 0
    public int compare_cards(Card b)
    {
	if ( this.number > b.number )
	    return 1;
	if ( this.number < b.number )
	    return -1;

	if ( this.suit > b.suit )
	    return 1;
	if ( this.suit < b.suit )
	    return -1;

	return 0;
    }

    public int compare_cards_value(Card b)
    {
	if ( this.number > b.number )
	    return 1;
	if ( this.number < b.number )
	    return -1;

	return 0;
    }

    public int compare_cards_suit(Card b)
    {
	if ( this.suit > b.suit )
	    return 1;
	if ( this.suit < b.suit )
	    return -1;

	return 0;
    }

}
