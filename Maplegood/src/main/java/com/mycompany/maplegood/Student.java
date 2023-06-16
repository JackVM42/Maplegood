/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maplegood;

import java.util.ArrayList;

/**
 *
 * @author jackvanmilligen
 */
public class Student extends Person{
    
    private ArrayList<String> extras = new ArrayList<String>();
    private String pa;
    private String pb;
    private String pc;
    private String pd;
    private double [] grade = new double[4];
    private String [] times = new String[4];
    
    public Student(String f, String m, String l, int b, String h,ArrayList<String> ext, String pw,String px,String py,String pz){
        //Firt Name, Middle Name, Last Name, age, homeroom, extra-curriculars, period 1, period 2, period 3, period 4
        super(f,m,l,b,h);
        this.extras = ext;
        //get each periods class
        this.pa = pw;
        this.pb = px;
        this.pc = py;
        this.pd = pz;
        //set time table array
        times[0] = pa;
        times[1] = pb;
        times[2] = pc;
        times[3] = pd;
    }
    public String[] getTimeTable(){
        return times;
}
    public int hasClas(String s){
        int c = -1;
        for(int i = 0; i < times.length; i++){
            if(times[i].toLowerCase().equals(s)){
                c= i;
            }
        }
        return c;
    }
    public String hasClass (int n){
        return times[n-1];
    }
    
    public int getPeriod(String s) {
        for(int i = 0; i < 4; i++){
            if(times[i].toLowerCase().equals(s.toLowerCase())){
                return i+1;
            }
        }
        System.out.println("Still Broke");
        return -1;
    }

    
    public boolean hasClass(String s){
        if(s.equals(pa.toLowerCase()) || s.equals(pb.toLowerCase()) || s.equals(pc.toLowerCase()) || s.equals(pd.toLowerCase())){
            return true;
        }
        return false;
    }
        
    public void setGrades(int n, double d){
        //take the period number and grade
        grade[n-1] = d;
    }
    
    public double getGrade(int n){
        return grade[n-1];
    }
    public double getGrade(String s){
        int p = -1;
    for (int i = 0; i<times.length;i++){
        if(times[i].equals(s))
            p=i;
    }
    return getGrade(p+1);
    }
    
    public double getAv(){
        double av = 0;
        for (int i = 0; i<grade.length;i++){
            av += grade[i];
        }
        av = av/grade.length;
        int c = (int)(av*100);
        av = c/100;
        return av;
    }
    
    public String getExtras(){
        String n ="";
        for (int i = 0;i<extras.size();i++){
            n += extras.get(i);
            if (extras.size()-1!=i){
                n += ", ";
            }
        }
        return n;
    }

    
}
