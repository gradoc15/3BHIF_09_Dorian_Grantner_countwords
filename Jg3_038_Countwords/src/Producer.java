
import java.io.File;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Producer extends Thread
{ 
    private Queue queue;
    private ThreadState st;
    private LinkedList<File> files = new LinkedList();

    public Producer(Queue queue,ThreadState st)
    {
        this.queue = queue;
        this.st = st;
        
        JFileChooser chooser = new JFileChooser();
        int proof = chooser.showOpenDialog(chooser);
        
        if(proof == JFileChooser.APPROVE_OPTION)
        {
            File f[] = chooser.getSelectedFile().getParentFile().listFiles();

            for(int i = 0; i < f.length; i++)
            {
                files.add(f[i]);
            }
        }
        
        st.setName("Producer");
    }
    
    

    @Override
    public void run()
    {
        while(true)
        {
            synchronized(queue)
            {
                try
                {
                    st.setRunning();
                    queue.add(new Book(files.poll().toString()));
                    System.out.println("full");
                } catch (Exception ex)
                {
                    try
                    {
                        st.setWaiting();
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException ex1)
                    {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }
    }
    
}
