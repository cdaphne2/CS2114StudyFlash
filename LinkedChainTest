import student.TestCase;

/**
 * Tests the LinkedChain class.
 */
public class LinkedChainTest extends TestCase
{
    private LinkedChain<String> chain;


    /**
     * Sets up an empty chain.
     */
    public void setUp()
    {
        chain = new LinkedChain<String>();
    }


    /**
     * Tests a new chain.
     */
    public void testConstructor()
    {
        assertTrue(chain.isEmpty());
        assertEquals(0, chain.getCurrentSize());
        assertEquals(0, chain.size());
    }


    /**
     * Tests adding entries, including a duplicate.
     */
    public void testAdd()
    {
        assertTrue(chain.add("A"));
        assertEquals(1, chain.getCurrentSize());
        assertFalse(chain.isEmpty());

        assertTrue(chain.add("A"));
        assertEquals(2, chain.getCurrentSize());
    }


    /**
     * Tests that add puts the new entry at the beginning.
     */
    public void testAddOrder()
    {
        chain.add("A");
        chain.add("B");

        String[] result = chain.toArray(new String[2]);

        assertEquals("B", result[0]);
        assertEquals("A", result[1]);
    }


    /**
     * Tests adding to the end of an empty and non-empty chain.
     */
    public void testAddToEnd()
    {
        assertTrue(chain.addToEnd("A"));
        assertTrue(chain.addToEnd("B"));
        assertTrue(chain.addToEnd("C"));

        assertEquals(3, chain.size());

        String[] result = chain.toArray(new String[3]);

        assertEquals("A", result[0]);
        assertEquals("B", result[1]);
        assertEquals("C", result[2]);
    }


    /**
     * Tests that null entries are rejected.
     */
    public void testNullEntry()
    {
        Exception e1 = null;
        Exception e2 = null;

        try
        {
            chain.add(null);
        }
        catch (IllegalArgumentException e)
        {
            e1 = e;
        }

        try
        {
            chain.addToEnd(null);
        }
        catch (IllegalArgumentException e)
        {
            e2 = e;
        }

        assertNotNull(e1);
        assertNotNull(e2);
        assertTrue(chain.isEmpty());
    }


    /**
     * Tests removing the first, middle, and last entries.
     */
    public void testRemove()
    {
        chain.addToEnd("A");
        chain.addToEnd("B");
        chain.addToEnd("C");
        chain.addToEnd("D");

        assertTrue(chain.remove("A"));
        assertTrue(chain.remove("C"));
        assertTrue(chain.remove("D"));

        assertEquals(1, chain.size());
        assertTrue(chain.contains("B"));
        assertFalse(chain.contains("A"));
    }


    /**
     * Tests removing something that is not stored.
     */
    public void testRemoveMissing()
    {
        assertFalse(chain.remove("A"));
        assertFalse(chain.remove(null));

        chain.add("A");

        assertFalse(chain.remove("Z"));
        assertEquals(1, chain.size());
    }


    /**
     * Tests that remove only removes one duplicate.
     */
    public void testRemoveDuplicate()
    {
        chain.add("A");
        chain.add("A");

        assertTrue(chain.remove("A"));
        assertEquals(1, chain.size());
        assertTrue(chain.contains("A"));
    }


    /**
     * Tests contains.
     */
    public void testContains()
    {
        assertFalse(chain.contains("A"));

        chain.add("A");

        assertTrue(chain.contains("A"));
        assertFalse(chain.contains("B"));
        assertFalse(chain.contains(null));
        assertEquals(1, chain.size());
    }


    /**
     * Tests getFrequencyOf.
     */
    public void testGetFrequencyOf()
    {
        chain.add("A");
        chain.add("B");
        chain.add("A");

        assertEquals(2, chain.getFrequencyOf("A"));
        assertEquals(1, chain.getFrequencyOf("B"));
        assertEquals(0, chain.getFrequencyOf("Z"));
        assertEquals(0, chain.getFrequencyOf(null));
    }


    /**
     * Tests the size of a chain with four entries.
     */
    public void testSize()
    {
        chain.add("A");
        chain.add("B");
        chain.add("C");
        chain.add("D");

        assertEquals(4, chain.getCurrentSize());
        assertEquals(4, chain.size());
    }


    /**
     * Tests toArray with an array that is too small.
     */
    public void testToArraySmallArray()
    {
        chain.addToEnd("A");
        chain.addToEnd("B");

        String[] result = chain.toArray(new String[0]);

        assertEquals(2, result.length);
        assertEquals("A", result[0]);
        assertEquals("B", result[1]);
    }


    /**
     * Tests toArray on an empty chain.
     */
    public void testToArrayEmpty()
    {
        assertEquals(0, chain.toArray(new String[0]).length);

        Object[] result = chain.toArray();

        assertEquals(0, result.length);
    }


    /**
     * Tests the toArray method with no arguments.
     */
    public void testToArrayNoArgument()
    {
        chain.addToEnd("A");
        chain.addToEnd("B");

        Object[] result = chain.toArray();

        assertEquals(2, result.length);
        assertEquals("A", result[0]);
        assertEquals("B", result[1]);
    }
}
