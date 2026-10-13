import student.TestCase;

/**
 * Tests the Deck class.
 *
 * @author Daphne
 * @version 2026.10.12
 */

public class DeckTest
    extends TestCase
{
    private Deck deck;
    private Flashcard card1;
    private Flashcard card2;

    /**
     * Sets up the tests.
     */
    public void setUp()
    {
        deck = new Deck("CS 2114");

        card1 = new Flashcard("What is Java?", "A language.");

        card2 = new Flashcard("What is recursion?", "A method calling itself.");
    }


    /**
     * Tests getName.
     */
    public void testGetName()
    {
        assertEquals("CS 2114", deck.getName());
    }


    /**
     * Tests a new empty deck.
     */
    public void testEmptyDeck()
    {
        assertTrue(deck.isEmpty());
        assertEquals(0, deck.getSize());
    }


    /**
     * Tests adding a card.
     */
    public void testAddCard()
    {
        assertTrue(deck.addCard(card1));

        assertEquals(1, deck.getSize());

        assertTrue(deck.containsCard(card1));
    }


    /**
     * Tests adding two cards.
     */
    public void testAddTwoCards()
    {
        deck.addCard(card1);
        deck.addCard(card2);

        assertEquals(2, deck.getSize());

        assertTrue(deck.containsCard(card1));

        assertTrue(deck.containsCard(card2));
    }


    /**
     * Tests adding a duplicate card.
     */
    public void testDuplicateCard()
    {
        deck.addCard(card1);
        deck.addCard(card1);

        assertEquals(2, deck.getSize());

        assertTrue(deck.containsCard(card1));
    }


    /**
     * Tests removing a card.
     */
    public void testRemoveCard()
    {
        deck.addCard(card1);

        assertTrue(deck.removeCard(card1));

        assertEquals(0, deck.getSize());

        assertFalse(deck.containsCard(card1));

        assertTrue(deck.isEmpty());
    }


    /**
     * Tests removing a card that is not there.
     */
    public void testRemoveMissingCard()
    {
        deck.addCard(card1);

        assertFalse(deck.removeCard(card2));

        assertEquals(1, deck.getSize());

        assertTrue(deck.containsCard(card1));
    }


    /**
     * Tests looking for a missing card.
     */
    public void testContainsMissingCard()
    {
        assertFalse(deck.containsCard(card1));
    }


    /**
     * Tests isEmpty after adding a card.
     */
    public void testNotEmpty()
    {
        deck.addCard(card1);

        assertFalse(deck.isEmpty());
    }


    /**
     * Tests getting the cards as an array.
     */
    public void testGetCardsSnapshot()
    {
        deck.addCard(card1);
        deck.addCard(card2);

        Flashcard[] cards = deck.getCardsSnapshot();

        assertEquals(2, cards.length);

        assertTrue(deck.containsCard(cards[0]));

        assertTrue(deck.containsCard(cards[1]));
    }


    /**
     * Tests getting cards from an empty deck.
     */
    public void testGetCardsSnapshotEmpty()
    {
        Flashcard[] cards = deck.getCardsSnapshot();

        assertEquals(0, cards.length);
    }
}
