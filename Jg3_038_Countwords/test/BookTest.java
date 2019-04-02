/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author User
 */

    
    @RunWith(value = Parameterized.class)
    public class BookTest

{
    @Parameterized.Parameter(value = 0)
    public  File inputFile;
    
    @Parameterized.Parameter(value = 1)
    public HashMap<String, Integer> resultMap;
    
    @Parameterized.Parameters(name = "")
    public static Iterable<Object[]> data1()
    {
        return Arrays.asList(new Object[][]
        {
            {new File("C:\\test.txt"),new HashMap().put("test", 2)},
            {new File("C:\\test2.txt"), new HashMap().put("aaa",5)}
                
        });
                 
    }
    
    public BookTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of countWords method, of class Book.
     */
    @Test
    public void testCountWords() throws Exception
    {
        System.out.println("countWords");
        
        Book instance = new Book(inputFile.getAbsolutePath());
        HashMap<String, Integer> expResult = resultMap;
        HashMap<String, Integer> result = instance.countWords();
        
        for(String key: resultMap.keySet())
        {
            assertEquals(result.get(key), expResult.get(key));
        }
        
    }
    
    @Test(expected = Exception.class)
    public void testEx()throws Exception
    {
       Book instance = new Book(inputFile.getAbsolutePath());
       instance.countWords();
    }

    /**
     * Test of getInputfilemame method, of class Book.
     */
    
}
