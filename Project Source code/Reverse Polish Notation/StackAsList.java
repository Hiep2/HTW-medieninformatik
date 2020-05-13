/**
 * Write a description of class StackAsList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StackAsList<T> implements Stack<T>
{
    private Node head, curr, prev;
    private int size;
    
    public StackAsList(){
        head = null;
        curr = null;
        prev = null;
        size = 0;
    }
    
    public void push (Object o){
        Node tmp = new Node(o, head);
        head = tmp;
        prev = null;
        curr = head;
    }
    
    public void pop() throws StackUnderFlow{
        if(isEmpty()){
            throw new StackUnderFlow();
        } else{
            curr = head;
            prev = null;
            if(prev == null){
                head = curr.next;
                curr = head;
            }else{
                prev.next = curr.next;
                curr = curr.next;
            }
            size = size - 1;
        }
    }
    
    public Object top() throws StackUnderFlow{
        curr = head;
        prev = null;
        return curr.data;
    }
   
    public boolean isEmpty(){
        return head == null;
    }
    
    public String toString(){
        curr = head;
        String text = "";
        while(curr != null){
            text += curr.data + "";
            curr = curr.next;
        }
        return text;
    }
}
