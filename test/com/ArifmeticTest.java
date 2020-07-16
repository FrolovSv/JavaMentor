/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author SusPecT
 */
public class ArifmeticTest {
    
    public ArifmeticTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getResult method, of class Arifmetic.
     */
    @Test
    public void testGetResult(){
        System.out.println("getResult");
        Arifmetic instance = new Arifmetic("1 + 1");
        String result = instance.getResult();
        assertEquals("2", result);
        
        instance = new Arifmetic("1 - 1");
        result = instance.getResult();
        assertEquals("0", result);
        
        instance = new Arifmetic("1 - 9");
        result = instance.getResult();
        assertEquals("-8", result);
        
        instance = new Arifmetic("2 * 9");
        result = instance.getResult();
        assertEquals("18", result);
        
        instance = new Arifmetic("2 / 9");
        result = instance.getResult();
        assertEquals("0.2222222222222222", result);
        
        instance = new Arifmetic("I + X");
        result = instance.getResult();
        assertEquals("XI", result);
        
        instance = new Arifmetic("X - VI");
        result = instance.getResult();
        assertEquals("IV", result);
                
        instance = new Arifmetic("X * X");
        result = instance.getResult();
        assertEquals("C", result);
        
        instance = new Arifmetic("V * X");
        result = instance.getResult();
        assertEquals("L", result);
        
        instance = new Arifmetic("VI / II");
        result = instance.getResult();
        assertEquals("III", result);
        
        instance = new Arifmetic("VI / IV");
        result = instance.getResult();
        assertEquals(new Arifmetic("").arabicToRoman(6%4), result);
               
    }
    
}
