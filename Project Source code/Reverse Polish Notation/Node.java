
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    public Object data;
    public Node next;

    /**
     * Constructor for objects of class Node
     */
    public Node(Object obj)
    {
        this.next = null;
        data = obj;
    }

    public Node(Object obj, Node next){
        data = obj;
        this.next = next;
    }
}
