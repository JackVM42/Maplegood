package com.mycompany.maplegood;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Person object from which students are created
 * @author jackvanmilligen
 */
public class Person {
    private String firstn;//first name
    private String lastn;//last name
    private String midn;//middle name
    private int bir;//age
    private String home;//homeroom
    
    /**
     * Constructor
     * @param f first name
     * @param m middle name
     * @param l last name
     * @param b age
     * @param h homeroom
     */
    public Person(String f, String m, String l, int b, String h){
        this.firstn = f;
        this.lastn = l;
        this.midn = m;
        this.bir = b;
        this.home = h;
    }
    
    /**
     * Sets the homeroom of the person
     * @param s the string to set as homeroom
     */
    public void setHomeroom(String s){
        home = s;
    }
    
    /**
     * getter for the full name
     * @return String of full name
     */
    public String getFullName(){
        return firstn + " " + midn + " " + lastn;
    }
    
    /**
     * Getter for the person's last name
     * @return string of last name
     */
    public String getLast(){
        return lastn;
    }
    
    /**
     * getter for age
     * @return int of age
     */
    public int getAge(){
       return bir; 
    }
    
    /**
     * getter for first name
     * @return String of first name
     */
    public String getFirstName(){
        return firstn;
    }
}

