/**
 * Represents a flashcard.
 *
 * @author Daphne
 * @version 2026.10.12
 */

public class Flashcard
{
    private String question;
    private String answer;
    private int numOfTimesCorrect;
    private int numOfTimesMissed;

    /**
     * Creates a new flashcard.
     *
     * @param question
     *            the question
     * @param answer
     *            the answer
     */
    public Flashcard(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
        numOfTimesCorrect = 0;
        numOfTimesMissed = 0;
    }


    /**
     * Gets the question.
     *
     * @return the question
     */
    public String getQuestion()
    {
        return question;
    }


    /**
     * Gets the answer.
     *
     * @return the answer
     */
    public String getAnswer()
    {
        return answer;
    }


    /**
     * Gets the correct count.
     *
     * @return number of correct answers
     */
    public int getNumOfTimesCorrect()
    {
        return numOfTimesCorrect;
    }


    /**
     * Gets the missed count.
     *
     * @return number of missed answers
     */
    public int getNumOfTimesMissed()
    {
        return numOfTimesMissed;
    }


    /**
     * Adds one to the correct count.
     */
    public void markCorrect()
    {
        numOfTimesCorrect++;
    }


    /**
     * Adds one to the missed count.
     */
    public void markMissed()
    {
        numOfTimesMissed++;
    }
}
