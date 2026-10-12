import java.util.Scanner;
import student.TestCase;

/**
 * Tests the StudyFlashApp class.
 */
public class StudyFlashAppTest extends TestCase
{
    private Deck deck;


    /**
     * Sets up an empty deck.
     */
    public void setUp()
    {
        deck =
            new Deck("CS 2114");
    }


    /**
     * Tests creating the application.
     */
    public void testConstructor()
    {
        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                new InputReader(
                    new Scanner("")));

        assertTrue(
            app.getDeck().isEmpty());
    }


    /**
     * Tests creating a flashcard.
     */
    public void testCreateFlashcard()
    {
        InputReader input =
            new InputReader(
                new Scanner(
                    "What is Java?\n"
                        + "A programming language\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.createFlashcard();

        assertEquals(
            1,
            deck.getSize());

        Flashcard card =
            deck.getCardsSnapshot()[0];

        assertEquals(
            "What is Java?",
            card.getQuestion());

        assertEquals(
            "A programming language",
            card.getAnswer());
    }


    /**
     * Tests blank question and answer input.
     */
    public void testCreateFlashcardBlankInput()
    {
        InputReader input =
            new InputReader(
                new Scanner(
                    "\n"
                        + "Question\n"
                        + "\n"
                        + "Answer\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.createFlashcard();

        assertEquals(
            1,
            deck.getSize());

        Flashcard card =
            deck.getCardsSnapshot()[0];

        assertEquals(
            "Question",
            card.getQuestion());

        assertEquals(
            "Answer",
            card.getAnswer());
    }


    /**
     * Tests removing an existing flashcard.
     */
    public void testRemoveFlashcard()
    {
        deck.addCard(
            new Flashcard(
                "Question",
                "Answer"));

        InputReader input =
            new InputReader(
                new Scanner("1\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.removeFlashcard();

        assertTrue(
            deck.isEmpty());
    }


    /**
     * Tests trying to remove a card
     * that does not exist.
     */
    public void testRemoveMissingFlashcard()
    {
        deck.addCard(
            new Flashcard(
                "Question",
                "Answer"));

        InputReader input =
            new InputReader(
                new Scanner("9\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.removeFlashcard();

        assertEquals(
            1,
            deck.getSize());
    }


    /**
     * Tests removing from an empty deck.
     */
    public void testRemoveFromEmptyDeck()
    {
        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                new InputReader(
                    new Scanner("")));

        app.removeFlashcard();

        assertTrue(
            deck.isEmpty());
    }


    /**
     * Tests viewing a deck containing a card.
     */
    public void testViewFlashcards()
    {
        deck.addCard(
            new Flashcard(
                "Question",
                "Answer"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                new InputReader(
                    new Scanner("")));

        app.viewFlashcards();

        assertEquals(
            1,
            deck.getSize());
    }


    /**
     * Tests viewing an empty deck.
     */
    public void testViewEmptyDeck()
    {
        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                new InputReader(
                    new Scanner("")));

        app.viewFlashcards();

        assertTrue(
            deck.isEmpty());
    }


    /**
     * Tests starting a normal study session.
     */
    public void testStartStudySession()
    {
        Flashcard card =
            new Flashcard(
                "Question",
                "Answer");

        deck.addCard(card);

        InputReader input =
            new InputReader(
                new Scanner(
                    "\n1\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.startStudySession();

        assertEquals(
            1,
            card.getNumOfTimesCorrect());
    }


    /**
     * Tests starting a study session with
     * an empty deck.
     */
    public void testStartStudyEmptyDeck()
    {
        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                new InputReader(
                    new Scanner("")));

        app.startStudySession();

        assertTrue(
            deck.isEmpty());
    }


    /**
     * Tests a full normal run.
     */
    public void testRun()
    {
        InputReader input =
            new InputReader(
                new Scanner(
                    "1\n"
                        + "Question\n"
                        + "Answer\n"
                        + "2\n"
                        + "5\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.run();

        assertEquals(
            1,
            deck.getSize());
    }


    /**
     * Tests non-numeric and out-of-range
     * main-menu choices.
     */
    public void testRunBadMenuInput()
    {
        InputReader input =
            new InputReader(
                new Scanner(
                    "hello\n"
                        + "9\n"
                        + "5\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.run();

        assertTrue(
            deck.isEmpty());
    }


    /**
     * Tests a missed card and invalid
     * review menu choice.
     */
    public void testStudyBadChoices()
    {
        Flashcard card =
            new Flashcard(
                "Question",
                "Answer");

        deck.addCard(card);

        InputReader input =
            new InputReader(
                new Scanner(
                    "\n"
                        + "8\n"
                        + "2\n"
                        + "9\n"
                        + "2\n"));

        StudyFlashApp app =
            new StudyFlashApp(
                deck,
                input);

        app.startStudySession();

        assertEquals(
            1,
            card.getNumOfTimesMissed());
    }
}
