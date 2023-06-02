package com.mycompany.maplegood;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jackvanmilligen
 */
public class Person {
    private String firstn;
    private String lastn;
    private String midn;
    private int bir;
    private String home;
    public Person(String f, String m, String l, int b, String h){
        this.firstn = f;
        this.lastn = l;
        this.midn = m;
        this.bir = b;
        this.home = h;
    }
    public void setHomeroom(String s){
        home = s;
    }
    public String getFullName(){
        return firstn + " " + midn + " " + lastn;
    }
    public String getLast(){
        return lastn;
    }
    
    public int getAge(){
       return bir; 
    }
}

