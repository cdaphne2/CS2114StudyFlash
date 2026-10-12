import java.util.Scanner;
import student.TestCase;

/**
 * Tests the InputReader class.
 */
public class InputReaderTest extends student.TestCase
{
    /**
     * Tests a null Scanner.
     */
    public void testNullScanner()
    {
        Exception exception = null;

        try
        {
            new InputReader(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests reading a valid integer.
     */
    public void testGetInt()
    {
        InputReader input = new InputReader(new Scanner("2\n"));

        assertEquals(2, input.getInt());
    }


    /**
     * Tests an integer with extra spaces around it.
     */
    public void testGetIntSpaces()
    {
        InputReader input = new InputReader(new Scanner("  7  \n"));

        assertEquals(7, input.getInt());
    }


    /**
     * Tests non-numeric input followed by a valid number.
     */
    public void testGetIntInvalid()
    {
        InputReader input =
            new InputReader(new Scanner("abc\n\n2.5\n3\n"));

        assertEquals(3, input.getInt());
        assertTrue(systemOut().getHistory().contains("Invalid number"));
    }


    /**
     * Tests reading valid text.
     */
    public void testGetNonBlankString()
    {
        InputReader input =
            new InputReader(new Scanner("What is recursion?\n"));

        assertEquals("What is recursion?", input.getNonBlankString());
    }


    /**
     * Tests blank and whitespace-only input followed by valid text.
     */
    public void testGetNonBlankStringBlank()
    {
        InputReader input =
            new InputReader(new Scanner("\n   \n  Answer  \n"));

        assertEquals("Answer", input.getNonBlankString());
        assertTrue(systemOut().getHistory().contains("cannot be blank"));
    }


    /**
     * Tests reading a raw line.
     */
    public void testGetLine()
    {
        InputReader input = new InputReader(new Scanner("\nhello\n"));

        assertEquals("", input.getLine());
        assertEquals("hello", input.getLine());
    }
}
