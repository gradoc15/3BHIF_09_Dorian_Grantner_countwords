
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Queue
{
    private int size = 3;
    private LinkedList<Book> list = new LinkedList();
    
    public void add(Book b)throws Exception
    {
        if(list.size() < 3)
            list.add(b);
        else
            throw new Exception("Queue is full");
    }
    
    public Book pull()throws Exception
    {
        if(!list.isEmpty())
            return list.poll();
        
        throw new Exception("Queue is empty");
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
}
