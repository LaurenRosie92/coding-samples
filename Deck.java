import java.util.*;

public class Deck
{
    //   - array of cards ( arrary of card pointers )
    private Card[] _the_cards;
    //   - number of cards dealt  
    private int    _num_dealt;

    // methods:
    //   - name: constructor
    //     desc: allocate the array of card pointers, and
    //           then for each pointer, allocate a unique card 
    // 	         object. 
    //     params: none
    //     return: n/a
    //     1) allocate an array of 52 card pointers
    //     2) fill the first 13 pointers with Clubs
    //     3) fill the second 13 pointers with Diamonds
    //     4) fill the next 13 pointers with Hearts
    //     5) fill the last 13 pointers with Spades
    //     6) set the number of cards dealt to zero
    public Deck()
    {
	int i;

	_the_cards = new Card[52];  // step 1

	for ( i = 0; i < 13; i ++ ) // step 2
	    _the_cards[i] = new Card(i+1, 'C');

	for ( i = 0; i < 13; i ++ ) // step 3
	    _the_cards[i+13] = new Card(i+1, 'D');

	for ( i = 0; i < 13; i ++ ) // step 4
	    _the_cards[i+26] = new Card(i+1, 'H');

	for ( i = 0; i < 13; i ++ ) // step 5
	    _the_cards[i+39] = new Card(i+1, 'S');
	
	_num_dealt = 0;  // step 6
    }


    //   - name: toString
    //     desc: returns a big string that contains the toString results
    //           for each card in the deck
    //     params: none
    //     return: String
    //     1) create a return string, call it display, set it the empty string
    //     2) for each card in the array, do step 3-4                          (L)
    //     3)  call the toString method on that card, add the result to display
    //     4)  add a newline character to display
    //     5) return display
    public String toString()
    {
	int i;
	String display = "";  // step 1
	
	for ( i = 0; i < _the_cards.length; i ++ )       // step 2
	    display += _the_cards[i].toString() + "\n";  // steps 3 and 4

	return display;       // step 5
    }

    //   - name: shuffle
    //     desc: assign each card a random number, then sort the cards by their random
    //           numbers, and set the number of cards dealt to zero
    //     params: Random gen
    //     return: void
    //     1) for each card, give it a random number
    //     2) sort the cards by their random numbers
    //     3) set the number of cards dealt to zero
    public void shuffle(Random gen)
    {
	int i, j;
	Card temp;

	for ( i = 0; i < _the_cards.length; i ++ )             // step 1
	    _the_cards[i].set_random_number( gen.nextInt() );

	for ( i = 0; i < _the_cards.length - 1; i ++ )         // step 2
	    for ( j = i + 1; j < _the_cards.length; j ++ )
		if ( _the_cards[i].get_random_number() > _the_cards[j].get_random_number() )
		{
		    temp = _the_cards[i];
		    _the_cards[i] = _the_cards[j];
		    _the_cards[j] = temp;
		}

	_num_dealt = 0;
    }

    //   - name: deal 
    //     desc: returns the address of the next card
    //     params: none
    //     return: Card - the address of a card object or a pointer to a card object
    //     1) grab the address whose index is the number of cards dealt
    //     2) add one to the number of cards dealt
    //     3) return the address we grabbed in step 1
    public Card deal()
    {
	return _the_cards[_num_dealt++];
    }

}
