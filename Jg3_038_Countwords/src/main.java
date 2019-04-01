
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 3));
        
        Queue queue = new Queue();
        
        ThreadState stP = new ThreadState();
        ThreadState stC1 = new ThreadState();
        ThreadState stC2 = new ThreadState();
        
        frame.add(stP);
        frame.add(stC1);
        frame.add(stC2);
        
        frame.setSize(600,400);
        frame.setVisible(true);
        
          
        Producer p = new Producer(queue,stP);
        Consumer c = new Consumer(queue,stC1);
        Consumer c2 = new Consumer(queue,stC2);
        
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3= new Thread(c2);
        
        t1.start();
        t2.start();
        t3.start();
        
        try
        {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex)
        {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
