public class StudyFlashApp
{
    private Deck deck;

    private InputReader input;

    private boolean running;

    /**
     * Creates the StudyFlash application.
     */
    public StudyFlashApp()
    {
        this(
            new Deck("My Study Deck"),
            new InputReader());
    }


    /**
     * Package-private constructor for testing.
     *
     * @param deck current deck
     * @param input application input
     */
    StudyFlashApp(
        Deck deck,
        InputReader input)
    {
        if (deck == null || input == null)
        {
            throw new IllegalArgumentException(
                "Deck and InputReader cannot be null.");
        }

        this.deck = deck;
        this.input = input;

        running = true;
    }


    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        StudyFlashApp app =
            new StudyFlashApp();

        app.run();
    }


    /**
     * Runs the application menu.
     */
    public void run()
    {
        running = true;

        while (running)
        {
            displayMenu();

            int choice = input.getInt();

            switch (choice)
            {
                case 1:
                    createFlashcard();
                    break;

                case 2:
                    viewFlashcards();
                    break;

                case 3:
                    removeFlashcard();
                    break;

                case 4:
                    startStudySession();
                    break;

                case 5:
                    running = false;

                    System.out.println(
                        "Goodbye!");

                    break;

                default:
                    System.out.println(
                        "Invalid menu choice. "
                            + "Please choose 1 through 5.");

                    break;
            }
        }
    }


    /**
     * Creates and stores a flashcard.
     */
    public void createFlashcard()
    {
        System.out.print(
            "Question: ");

        String question =
            input.getNonBlankString();

        System.out.print(
            "Answer: ");

        String answer =
            input.getNonBlankString();

        Flashcard card =
            new Flashcard(
                question,
                answer);

        deck.addCard(card);

        System.out.println(
            "Flashcard added.");
    }


    /**
     * Removes a selected flashcard.
     */
    public void removeFlashcard()
    {
        if (deck.isEmpty())
        {
            System.out.println(
                "There are no flashcards to remove.");

            return;
        }

        Flashcard[] cards =
            deck.getCardsSnapshot();

        printNumberedQuestions(cards);

        System.out.print(
            "Enter the number of the card to remove: ");

        int choice =
            input.getInt();

        if (choice < 1
            || choice > cards.length)
        {
            System.out.println(
                "That flashcard does not exist.");

            return;
        }

        if (deck.removeCard(
            cards[choice - 1]))
        {
            System.out.println(
                "Flashcard removed.");
        }
        else
        {
            System.out.println(
                "That flashcard could not be removed.");
        }
    }


    /**
     * Displays all current flashcards.
     */
    public void viewFlashcards()
    {
        if (deck.isEmpty())
        {
            System.out.println(
                "There are no flashcards in the deck.");

            return;
        }

        Flashcard[] cards =
            deck.getCardsSnapshot();

        System.out.println(
            "Deck: " + deck.getName());

        for (int i = 0;
             i < cards.length;
             i++)
        {
            Flashcard card =
                cards[i];

            System.out.println(
                (i + 1)
                    + ". "
                    + card.getQuestion()
                    + " -> "
                    + card.getAnswer());
        }
    }


    /**
     * Starts a study session.
     */
    public void startStudySession()
    {
        if (deck.isEmpty())
        {
            System.out.println(
                "There are no flashcards to study.");

            return;
        }

        StudySession session =
            new StudySession(
                deck,
                input);

        session.startStudy();

        if (session.hasMissedCards())
        {
            System.out.println();

            System.out.println(
                "Review missed cards?");

            System.out.println(
                "1. Yes");

            System.out.println(
                "2. No");

            System.out.print(
                "Choice: ");

            int choice =
                input.getInt();

            while (choice != 1
                && choice != 2)
            {
                System.out.println(
                    "Invalid choice. Enter 1 or 2.");

                System.out.print(
                    "Choice: ");

                choice =
                    input.getInt();
            }

            if (choice == 1)
            {
                session.reviewMissed();
            }
        }
    }


    /**
     * Package-private accessor for tests.
     *
     * @return current deck
     */
    Deck getDeck()
    {
        return deck;
    }


    /**
     * Displays the main menu.
     */
    private void displayMenu()
    {
        System.out.println();

        System.out.println(
            "=== StudyFlash ===");

        System.out.println(
            "1. Create flashcard");

        System.out.println(
            "2. View flashcards");

        System.out.println(
            "3. Remove flashcard");

        System.out.println(
            "4. Start study session");

        System.out.println(
            "5. Exit");

        System.out.print(
            "Choice: ");
    }


    /**
     * Displays numbered flashcard questions.
     *
     * @param cards flashcards to display
     */
    private void printNumberedQuestions(
        Flashcard[] cards)
    {
        for (int i = 0;
             i < cards.length;
             i++)
        {
            System.out.println(
                (i + 1)
                    + ". "
                    + cards[i].getQuestion());
        }
    }
}
