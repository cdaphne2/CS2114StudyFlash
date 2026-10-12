import java.util.Scanner;

/**
 * Reads and validates console input so the rest of the application
 * does not have to handle raw invalid input.
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Creates an InputReader that reads from the console.
     */
    public InputReader()
    {
        this(new Scanner(System.in));
    }


    /**
     * Package-private constructor for testing.
     *
     * @param scanner
     *            the source of the input
     */
    InputReader(Scanner scanner)
    {
        if (scanner == null)
        {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }

        this.scanner = scanner;
    }


    /**
     * Reads an integer. If the user enters something that is not a
     * whole number, an error is shown and the user is asked again.
     *
     * @return the integer entered
     */
    public int getInt()
    {
        while (true)
        {
            String line = scanner.nextLine().trim();

            try
            {
                return Integer.parseInt(line);
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid number. Please enter a whole "
                    + "number: ");
            }
        }
    }


    /**
     * Reads text and only returns it once it has at least one
     * non-whitespace character. Blank input causes a re-prompt.
     *
     * @return the text entered, with surrounding spaces removed
     */
    public String getNonBlankString()
    {
        while (true)
        {
            String line = scanner.nextLine().trim();

            if (!line.isEmpty())
            {
                return line;
            }

            System.out.print("Input cannot be blank. Please try again: ");
        }
    }


    /**
     * Reads one line exactly as typed (used for "Press Enter").
     *
     * @return the line entered
     */
    public String getLine()
    {
        return scanner.nextLine();
    }
}
