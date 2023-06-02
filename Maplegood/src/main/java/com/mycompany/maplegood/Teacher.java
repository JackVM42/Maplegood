/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maplegood;

/**
 *
 * @author jackvanmilligen
 */
public class Teacher extends Person {
    private String cls;
    public Teacher (String f, String m, String l, int b, String h,String c){
        super(f,m,l,b,h);
        this.cls = c;
    }
    public String getClas(){
        return cls;
    }
}
