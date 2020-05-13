
/**
 * Write a description of interface Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Stack<T>
{
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    public void push (Object o);
    public void pop() throws StackUnderFlow;
    public Object top() throws StackUnderFlow;
    //public boolean isEmpty();
    //public void empty();
    public String toString();
}
