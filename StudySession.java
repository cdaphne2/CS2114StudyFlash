public class StudySession
{
    private Deck deck;

    private LinkedChain<Flashcard> missedCards;

    private LinkedChain<StudyResult> history;

    private int reviewed;

    private InputReader input;

    /**
     * Creates a study session.
     *
     * @param deck the deck being studied
     */
    public StudySession(Deck deck)
    {
        this(deck, new InputReader());
    }


    /**
     * Package-private constructor for testing.
     *
     * @param deck deck to study
     * @param input controlled input source
     */
    StudySession(Deck deck, InputReader input)
    {
        if (deck == null)
        {
            throw new IllegalArgumentException(
                "Deck cannot be null.");
        }

        if (input == null)
        {
            throw new IllegalArgumentException(
                "InputReader cannot be null.");
        }

        this.deck = deck;
        this.input = input;

        missedCards =
            new LinkedChain<Flashcard>();

        history =
            new LinkedChain<StudyResult>();

        reviewed = 0;
    }


    /**
     * Runs one study round.
     */
    public void startStudy()
    {
        if (deck.isEmpty())
        {
            System.out.println(
                "There are no flashcards to study.");

            return;
        }

        Flashcard[] cards =
            deck.getCardsSnapshot();

        for (Flashcard card : cards)
        {
            System.out.println();

            System.out.println(
                "Question: " + card.getQuestion());

            System.out.println(
                "Press Enter to reveal the answer.");

            input.getLine();

            System.out.println(
                "Answer: " + card.getAnswer());

            System.out.println("1. Correct");
            System.out.println("2. Missed");

            System.out.print("Choice: ");

            int choice = getStudyChoice();

            if (choice == 1)
            {
                markCorrect(card);
            }
            else
            {
                markMissed(card);
            }

            reviewed++;
        }

        System.out.println();

        System.out.println(
            "Study round complete. Reviewed "
                + reviewed
                + " card(s).");

        printHistory();
    }


    /**
     * Records a correct result.
     *
     * @param card flashcard answered correctly
     */
    public void markCorrect(Flashcard card)
    {
        if (card == null)
        {
            return;
        }

        card.markCorrect();

        history.addToEnd(
            new StudyResult(
                card.getQuestion(),
                true));
    }


    /**
     * Records a missed result.
     *
     * @param card missed flashcard
     */
    public void markMissed(Flashcard card)
    {
        if (card == null)
        {
            return;
        }

        card.markMissed();

        missedCards.addToEnd(card);

        history.addToEnd(
            new StudyResult(
                card.getQuestion(),
                false));
    }


    /**
     * Reviews all cards missed during this session.
     */
    public void reviewMissed()
    {
        if (missedCards.isEmpty())
        {
            System.out.println(
                "There are no missed cards to review.");

            return;
        }

        Flashcard[] cards =
            missedCards.toArray(
                new Flashcard[
                    missedCards.size()]);

        System.out.println(
            "Reviewing missed cards:");

        for (Flashcard card : cards)
        {
            System.out.println();

            System.out.println(
                "Question: "
                    + card.getQuestion());

            System.out.println(
                "Press Enter to reveal the answer.");

            input.getLine();

            System.out.println(
                "Answer: "
                    + card.getAnswer());
        }
    }


    /**
     * Returns how many cards were reviewed.
     *
     * @return reviewed count
     */
    public int getReviewed()
    {
        return reviewed;
    }


    /**
     * Determines whether cards were missed.
     *
     * @return true when at least one card was missed
     */
    public boolean hasMissedCards()
    {
        return !missedCards.isEmpty();
    }


    /**
     * Package-private snapshot for tests.
     *
     * @return study history
     */
    StudyResult[] getHistorySnapshot()
    {
        return history.toArray(
            new StudyResult[
                history.size()]);
    }


    /**
     * Package-private snapshot for tests.
     *
     * @return missed cards
     */
    Flashcard[] getMissedCardsSnapshot()
    {
        return missedCards.toArray(
            new Flashcard[
                missedCards.size()]);
    }


    /**
     * Reads a valid 1 or 2 study choice.
     *
     * @return valid choice
     */
    private int getStudyChoice()
    {
        while (true)
        {
            int choice = input.getInt();

            if (choice == 1
                || choice == 2)
            {
                return choice;
            }

            System.out.println(
                "Invalid choice. "
                    + "Enter 1 for Correct "
                    + "or 2 for Missed.");

            System.out.print("Choice: ");
        }
    }


    /**
     * Displays the stored study results.
     */
    private void printHistory()
    {
        StudyResult[] results =
            history.toArray(
                new StudyResult[
                    history.size()]);

        if (results.length == 0)
        {
            return;
        }

        System.out.println(
            "Session history:");

        for (StudyResult result : results)
        {
            System.out.println(
                "- " + result);
        }
    }
}
