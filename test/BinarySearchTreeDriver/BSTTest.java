/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinarySearchTreeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Veloz
 */
public class BSTTest {
    
    public BSTTest() {
    }
    
    @Test
    public void testSomeMethod() {
        
        BST b = new BST();
        /*
        //Insert at root
        Data root = new Data("r");
        b.insert2(root);
        assertEquals( b.tna[0]  , root);
        
        //Insert a node(lesser) after root 
        Data first = new Data("f");
        boolean tf = b.insert2(first);
        assertTrue(tf);
        assertEquals( b.tna[1], first);               
        
        //Insert a node(greater) after root 
        Data second = new Data("s");
        boolean ts = b.insert2(second);
        assertTrue(ts);
        assertEquals( b.tna[2], second);      
        */
        
        int child = b.findIndexRecursively("b", 0);
        //b.insert2(new Data("b"));
        //b.insert2(new Data("g"));
        //b.insert2(new Data("i"));
        //b.insert2(new Data("o"));
        assertEquals(8, child );
        b.showArray();
        //Insert same key again
//        Data repeat = new Data("r");
//        assertFalse( b.insert2(repeat) );
        //assertEquals( 4, b.findNode("d") );
        
    }
    
}
