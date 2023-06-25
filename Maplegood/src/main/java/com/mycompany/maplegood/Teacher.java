/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maplegood;

/**
 *Teacher object created off of Person
 * @author jackvanmilligen
 */
public class Teacher extends Person {
    
    private String cls;//class they teach
    
    /**
     * Constructor
     * @param f first name
     * @param m middle name
     * @param l last name
     * @param b age
     * @param h homeroom
     * @param c class
     */
    public Teacher (String f, String m, String l, int b, String h,String c){
        super(f,m,l,b,h);
        this.cls = c;
    }
    
    /**
     * getter for the class they teach
     * @return returns a string of the class name
     */
    public String getClas(){
        return cls;
    }
}
