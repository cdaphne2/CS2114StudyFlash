import java.util.Scanner;
import student.TestCase;

/**
 * Tests the StudySession class.
 */
public class StudySessionTest extends TestCase
{
    private Deck deck;
    private Flashcard card;


    /**
     * Sets up a deck and flashcard.
     */
    public void setUp()
    {
        deck =
            new Deck("CS 2114");

        card =
            new Flashcard(
                "What is FIFO?",
                "First In First Out");
    }


    /**
     * Tests the constructor.
     */
    public void testConstructor()
    {
        InputReader input =
            new InputReader(
                new Scanner(""));

        StudySession session =
            new StudySession(
                deck,
                input);

        assertEquals(
            0,
            session.getReviewed());

        assertFalse(
            session.hasMissedCards());
    }


    /**
     * Tests a null deck.
     */
    public void testNullDeck()
    {
        Exception exception = null;

        try
        {
            new StudySession(
                null,
                new InputReader(
                    new Scanner("")));
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests a null InputReader.
     */
    public void testNullInputReader()
    {
        Exception exception = null;

        try
        {
            new StudySession(
                deck,
                null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests marking a card correct.
     */
    public void testMarkCorrect()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.markCorrect(card);

        assertEquals(
            1,
            card.getNumOfTimesCorrect());

        assertEquals(
            0,
            card.getNumOfTimesMissed());

        StudyResult[] history =
            session.getHistorySnapshot();

        assertEquals(
            1,
            history.length);

        assertTrue(
            history[0].wasCorrect());
    }


    /**
     * Tests marking a null card correct.
     */
    public void testMarkCorrectNull()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.markCorrect(null);

        assertEquals(
            0,
            session.getHistorySnapshot().length);
    }


    /**
     * Tests marking a card missed.
     */
    public void testMarkMissed()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.markMissed(card);

        assertEquals(
            1,
            card.getNumOfTimesMissed());

        assertTrue(
            session.hasMissedCards());

        Flashcard[] missed =
            session.getMissedCardsSnapshot();

        assertEquals(
            1,
            missed.length);

        assertEquals(
            card,
            missed[0]);

        StudyResult[] history =
            session.getHistorySnapshot();

        assertEquals(
            1,
            history.length);

        assertFalse(
            history[0].wasCorrect());
    }


    /**
     * Tests marking a null card missed.
     */
    public void testMarkMissedNull()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.markMissed(null);

        assertFalse(
            session.hasMissedCards());

        assertEquals(
            0,
            session.getHistorySnapshot().length);
    }


    /**
     * Tests studying an empty deck.
     */
    public void testStartStudyEmptyDeck()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.startStudy();

        assertEquals(
            0,
            session.getReviewed());
    }


    /**
     * Tests a normal correct study choice.
     */
    public void testStartStudyCorrect()
    {
        deck.addCard(card);

        InputReader input =
            new InputReader(
                new Scanner(
                    "\n1\n"));

        StudySession session =
            new StudySession(
                deck,
                input);

        session.startStudy();

        assertEquals(
            1,
            session.getReviewed());

        assertEquals(
            1,
            card.getNumOfTimesCorrect());

        assertFalse(
            session.hasMissedCards());
    }


    /**
     * Tests a normal missed study choice.
     */
    public void testStartStudyMissed()
    {
        deck.addCard(card);

        InputReader input =
            new InputReader(
                new Scanner(
                    "\n2\n"));

        StudySession session =
            new StudySession(
                deck,
                input);

        session.startStudy();

        assertEquals(
            1,
            session.getReviewed());

        assertEquals(
            1,
            card.getNumOfTimesMissed());

        assertTrue(
            session.hasMissedCards());
    }


    /**
     * Tests an invalid study choice followed by
     * a valid choice.
     */
    public void testInvalidStudyChoice()
    {
        deck.addCard(card);

        InputReader input =
            new InputReader(
                new Scanner(
                    "\n9\n2\n"));

        StudySession session =
            new StudySession(
                deck,
                input);

        session.startStudy();

        assertEquals(
            1,
            session.getReviewed());

        assertEquals(
            1,
            card.getNumOfTimesMissed());
    }


    /**
     * Tests reviewing when no cards were missed.
     */
    public void testReviewNoMissedCards()
    {
        StudySession session =
            new StudySession(
                deck,
                new InputReader(
                    new Scanner("")));

        session.reviewMissed();

        assertFalse(
            session.hasMissedCards());
    }


    /**
     * Tests reviewing a missed card.
     */
    public void testReviewMissedCard()
    {
        InputReader input =
            new InputReader(
                new Scanner("\n"));

        StudySession session =
            new StudySession(
                deck,
                input);

        session.markMissed(card);

        session.reviewMissed();

        assertTrue(
            session.hasMissedCards());

        assertEquals(
            1,
            session.getMissedCardsSnapshot().length);
    }
}
