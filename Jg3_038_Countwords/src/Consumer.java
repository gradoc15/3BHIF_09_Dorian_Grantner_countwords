
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Consumer extends Thread
{
    private Queue queue;
    private ThreadState st;

    public Consumer(Queue queue, ThreadState st)
    {
        this.queue = queue;
        this.st = st;
    }

    @Override
    public void run()
    {
        while(true)
        {
            Book b = null;
            synchronized(queue)
            {
                try
                {
                    b = queue.pull();
                    st.setName(b.getInputfilemame());
                    st.setRunning();
                    System.out.println("pulls");
                } catch (Exception ex)
                {
                    try
                    {
                        st.setWaiting();
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException ex1)
                    {
                    }
                }
            }


            if(b != null)
            {
                System.out.println(b.getInputfilemame());
                try
                {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(b.getInputfilemame().substring(0, b.getInputfilemame().length()-4)+"-output.txt")));
                    bw.write(b.getInputfilemame());

                    for(String key: b.countWords().keySet())                
                    {
                        if(b.countWords().get(key) > 1)
                        {
                            bw.newLine();
                            bw.write(key+": "+b.countWords().get(key));
                        }
                    }

                    bw.close();

                } catch (IOException ex)
                {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Finished");
        }
    }
    
    
    
    
}
