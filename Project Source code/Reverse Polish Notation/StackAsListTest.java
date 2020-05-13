import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StackAsListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StackAsListTest
{
    private StackAsList stackAsL1;

    /**
     * Default constructor for test class StackAsListTest
     */
    public StackAsListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        stackAsL1 = new StackAsList();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void test1() throws StackUnderFlow
    {
        stackAsL1.push(1);
        stackAsL1.push(2);
        stackAsL1.push(3);
        assertEquals("321", stackAsL1.toString());
        stackAsL1.pop();
        assertEquals("21", stackAsL1.toString());
        assertEquals(2, stackAsL1.top());
    }
}

