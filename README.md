# CS2114StudyFlash
# Study Flash - Flashcard Study Tool

StudyFlash is a flashcard study tool that allows users to create,
view, remove, and study flashcards. Users can mark flashcards as correct or
missed and review missed cards after a study session.

---

## Project Structure

- `LinkedChain.java` - Generic linked chain used to store data.
- `Flashcard.java` - Stores a question, answer, correct count, and missed count.
- `Deck.java` - Stores a named collection of flashcards.
- `StudySession.java` - Runs study sessions and tracks missed flashcards.
- `InputReader.java` - Reads and validates user input.
- `StudyFlashApp.java` - Runs the main menu and application.

---

## How to Import, Compile, and Run in Eclipse

### Step 1: Import the Project into Eclipse

1. Open **Eclipse IDE**.
2. Go to top menu: **File** > **Import...**
3. Expand **General**, select **Projects from Folder or Archive**, and click **Next**.
4. Click **Directory...**, select the `CS2114StudyFlash` root folder on your computer, and click **Finish**.

---

### Step 2: Compile the Code

Eclipse automatically compiles your Java code every time you save a file (**Project** > **Build Automatically** is enabled by default). 

*If there are red build markers:*
1. Go to **Project** > **Clean...**
2. Select **Clean all projects** and click **Clean**.

---

### Step 3: Run the Application

1. In the **Package Explorer** window on the left, expand the `CS2114StudyFlash` project and open the `src` folder.
2. Right-click **`StudyFlashApp.java`**.
3. Select **Run As** > **Java Application**.
4. View the output in the **Console** panel at the bottom of Eclipse.

---

## Reflection

What changed from your specification? Classes, method signatures, where validation lives, test cases — what did the spec say, what did you build instead, and why?

- LinkedChain: the spec's toArray() method became toArray(T[]), as java can't return a typed array from a general class. Also, size() and addToEnd() were added.
- Deck also uses getCardsSnapshot() to return the flashcards as an array. This allows StudyFlashApp and StudySession to use the cards without directly accessing the LinkedChain nodes.

What changed in the LinkedChain? Anything you added to or modified in the provided class and why your application needed it, or that you used it unchanged.

- Started from the provided template. Added getFrequencyOf() and getCurrentSize(), which call the template's count() and size(), so the spec's method names work.
  
What happened to your unknowns? Of the things you listed in your scope as not knowing how to do, which did you figure out, and which are still open?

- Figured out: Building a generic linked chain; testing console input with a Scanner.
- Still open:
  
What doesn't work yet? MVP features, bad-input cases, or tests that are missing or failing in this prototype.

- Pressing Ctrl+D (end of input) crashes InputReader with a NoSuchElementException.

---

## Next Steps

What is left to finish the MVP? The remaining features and fixes, in the order you will do them.

- Run classes with the team's other classes and fix any problems.
- Run all test classes together and fix any failing tests.
- Test the full program from creating a flashcard through completing a study session.
- Fix the Ctrl+D InputReader issue if needed.
  
Which stretch goals will you attempt? The ones from your scope you are committing to, and the ones you are dropping.

- We will focus on completing and testing the required MVP before adding additional stretch goals.

What new tests will you need? The methods and bad-input cases the added work must cover.

- Test getting flashcards from an empty Deck.
- Test getting flashcards from a Deck containing cards.
- Test invalid menu choices.
- Test removing a flashcard that does not exist.
- Test blank question and answer input.
- Test studying an empty deck.
- Test reviewing when there are no missed cards.

Who does what? Which team member owns each remaining item?

- Rohan will work on LinkedChain and InputReader.
- Daphne will work on Flashcard and Deck.
- Jasjeet will work on StudySession and StudyFlashApp.
- The group will work together to run the complete program and fix integration problems.

---

Attribution — in your README.md, a table with one row per class and test file listing who worked on it and how (wrote, revised, reviewed, tested, GenAI-assisted, …), plus a note on the way in which you used GenAI, if at all.

| Class                  | Member  | Contribution          | GenAI                                  |
|------------------------|---------|-----------------------|----------------------------------------|
| LinkedChain.java       | Rohan   | Adapted dept template | Yes, to adapt the department template. |
| LinkedChainTest.java   | Rohan   | Wrote, tested         | Yes, to draft the test cases.          |
| InputReader.java       | Rohan   | Wrote                 | Yes, to draft the class structure.     |
| InputReaderTest.java   | Rohan   | Wrote, tested         | Yes, to draft the test cases.          |
| Flashcard.java         | Daphne  | Wrote, tested         | Yes, to help add Javadocs and comments.|
| FlashcardTest.java     | Daphne  | Wrote, tested.        | Yes, to help add Javadocs and comments.|
| Deck.java              | Daphne  | Wrote, tested.        | Yes, to help add Javadocs and comments.|
| DeckTest.java          | Daphne  | Wrote, tested         | Yes, to help add Javadocs and comments.|
| StudySession.java      | Jasjeet |                       |                                        |
| StudySessionTest.java  | Jasjeet |                       |                                        |
| StudyFlashApp.java     | Jasjeet |                       |                                        |
| StudyFlashAppTest.java | Jasjeet |                       |                                        |
