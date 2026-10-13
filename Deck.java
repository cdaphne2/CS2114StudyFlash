/**
 * Represents a deck of flashcards.
 *
 * @author Daphne
 * @version 2026.10.12
 */

public class Deck
{
    private String name;
    private LinkedChain<Flashcard> cards;

    /**
     * Creates an empty deck.
     *
     * @param name
     *            the deck name
     */
    public Deck(String name)
    {
        this.name = name;
        cards = new LinkedChain<Flashcard>();
    }


    /**
     * Gets the deck name.
     *
     * @return the deck name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Adds a card to the deck.
     *
     * @param card
     *            the card to add
     * @return true if added
     */
    public boolean addCard(Flashcard card)
    {
        return cards.add(card);
    }


    /**
     * Removes a card from the deck.
     *
     * @param card
     *            the card to remove
     * @return true if removed
     */
    public boolean removeCard(Flashcard card)
    {
        return cards.remove(card);
    }


    /**
     * Checks if the deck contains a card.
     *
     * @param card
     *            the card to find
     * @return true if found
     */
    public boolean containsCard(Flashcard card)
    {
        return cards.contains(card);
    }


    /**
     * Gets the number of cards in the deck.
     *
     * @return number of cards
     */
    public int getSize()
    {
        return cards.getCurrentSize();
    }


    /**
     * Checks if the deck is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }


    /**
     * Gets the cards in the deck as an array.
     *
     * @return array containing the cards
     */
    public Flashcard[] getCardsSnapshot()
    {
        Flashcard[] result = new Flashcard[cards.getCurrentSize()];

        return cards.toArray(result);
    }
}
