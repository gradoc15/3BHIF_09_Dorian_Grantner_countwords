
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Book
{
    private String inputfilemame;
    private String text;

    public Book(String inputfilemame)
    {
        this.inputfilemame = inputfilemame;
    }

    
    
    
    public HashMap<String, Integer> countWords() throws FileNotFoundException, IOException
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>(); 
        
        BufferedReader br = new BufferedReader(new FileReader(new File(inputfilemame)));
        
        String line = "";
        String words[];
        boolean existing = false;
        
        while((line = br.readLine()) != null)
        {
            line = line.replace(',', ' ');
            line = line.replace('.', ' ');
            line = line.replace('!', ' ');
            line = line.replace('?', ' ');
            line = line.replace(':', ' ');
            line = line.replace(')', ' ');
            line = line.replace('(', ' ');
            line = line.replace(']', ' ');
            line = line.replace('[', ' ');
            line = line.replace('}', ' ');
            line = line.replace('{', ' ');
            line = line.replace('"', ' ');
            line = line.replace('\'', ' ');
            line = line.replace('#', ' ');
            line = line.replace('-', ' ');
            line = line.replace('*', ' ');
            line = line.replace('\\', ' ');
            line = line.replace('_', ' ');
            line = line.replace(';', ' ');
            line = line.replace(';', ' ');
            
            
            
            words = (line.toLowerCase()).split("\\s+");
            
            for(int i = 0; i < words.length; i++)
            {
                existing = false;
                
                for(String key : map.keySet())
                {
                    if(key.equals(words[i]))
                    {
                        existing = true;
                        break;
                    }
                }
                
                if(existing)
                    map.put(words[i], map.get(words[i])+1);
                    
                else
                {
                    map.put(words[i],1);
                }
            }
        }
        
        
        return map;
    }

    public String getInputfilemame()
    {
        return inputfilemame;
    }
    
    
    
}
