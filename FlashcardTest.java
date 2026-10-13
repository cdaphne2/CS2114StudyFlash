import student.TestCase;

/**
 * Tests the Flashcard class.
 *
 * @author Daphne
 * @version 2026.10.12
 */

public class FlashcardTest
    extends TestCase
{
    private Flashcard card;

    /**
     * Sets up the test.
     */
    public void setUp()
    {
        card = new Flashcard("What is Java?", "A programming language.");
    }


    /**
     * Tests getQuestion.
     */
    public void testGetQuestion()
    {
        assertEquals("What is Java?", card.getQuestion());
    }


    /**
     * Tests getAnswer.
     */
    public void testGetAnswer()
    {
        assertEquals("A programming language.", card.getAnswer());
    }


    /**
     * Tests the starting correct count.
     */
    public void testCorrectStartsAtZero()
    {
        assertEquals(0, card.getNumOfTimesCorrect());
    }


    /**
     * Tests the starting missed count.
     */
    public void testMissedStartsAtZero()
    {
        assertEquals(0, card.getNumOfTimesMissed());
    }


    /**
     * Tests markCorrect.
     */
    public void testMarkCorrect()
    {
        card.markCorrect();

        assertEquals(1, card.getNumOfTimesCorrect());

        assertEquals(0, card.getNumOfTimesMissed());
    }


    /**
     * Tests markMissed.
     */
    public void testMarkMissed()
    {
        card.markMissed();

        assertEquals(1, card.getNumOfTimesMissed());

        assertEquals(0, card.getNumOfTimesCorrect());
    }


    /**
     * Tests both counters.
     */
    public void testCorrectAndMissed()
    {
        card.markCorrect();
        card.markMissed();

        assertEquals(1, card.getNumOfTimesCorrect());

        assertEquals(1, card.getNumOfTimesMissed());
    }


    /**
     * Tests that the text does not change.
     */
    public void testTextDoesNotChange()
    {
        card.markCorrect();
        card.markMissed();

        assertEquals("What is Java?", card.getQuestion());

        assertEquals("A programming language.", card.getAnswer());
    }
}
