/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maplegood;

import java.util.ArrayList;

/**
 *Student class extends the person class
 * @author jackvanmilligen
 */
public class Student extends Person{
    
    private ArrayList<String> extras = new ArrayList<>();//extracurriculars
    private String pa;//periodd 1
    private String pb;//period 2
    private String pc;//period 3
    private String pd;//period 4
    private double [] grade = new double[4];//keeps track of grades in 4 classes
    private String [] times = new String[4];//keeps track of the classes
    
    /**
     * Constructor for student object
     * @param f First Name
     * @param m Middle Name
     * @param l Last Name
     * @param b age
     * @param h homeroom
     * @param ext extra curriculars
     * @param pw period 1
     * @param px period 2
     * @param py period 3
     * @param pz period 4
     */
    public Student(String f, String m, String l, int b, String h,ArrayList<String> ext, String pw,String px,String py,String pz){
       
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
    /**
     * getter for students timetable
     * @return array of the names of students timetable
     */
    public String[] getTimeTable(){
        return times;
}
    /**
     * Checks what period a student has a class
     * @param s name of a class
     * @return index the class is in timetables array or -1 if doesn't have class
     */
    public int hasClas(String s){
        int c = -1;
        for(int i = 0; i < times.length; i++){
            if(times[i].toLowerCase().equals(s)){
                c= i;
            }
        }
        return c;
    }
    
    /**
     * finds what class the student has at a certain period
     * @param n period number
     * @return class name
     */
    public String hasClass (int n){
        return times[n-1];
    }
    
    /**
     * Finds the period the student has a certain class
     * @param s class
     * @return period student has class s
     */
    public int getPeriod(String s) {
        for(int i = 0; i < 4; i++){
            if(times[i].toLowerCase().equals(s.toLowerCase())){
                return i+1;
            }
        }
        return -1;
    }

    /**
     * Checks if a student has a class
     * @param s class name
     * @return boolean if student has the class
     */
    public boolean hasClass(String s){
        if(s.equals(pa.toLowerCase()) || s.equals(pb.toLowerCase()) || s.equals(pc.toLowerCase()) || s.equals(pd.toLowerCase())){
            return true;
        }
        return false;
    }
    
    /**
     * sets students grades
     * @param n period number of students class
     * @param d student's grade
     */
    public void setGrades(int n, double d){
        //take the period number and grade
        grade[n-1] = d;
    }
    
    /**
     * getter for students grades
     * @param n period number
     * @return double students grade
     */
    public double getGrade(int n){
        return grade[n-1];
    }
    
    /**
     * gets grades for a class given the class name
     * @param s the string name of the class
     * @return returns the grade as a double
     */
    public double getGrade(String s){
        int p = -1;
    for (int i = 0; i <times.length; i++){
        if(times[i].toLowerCase().equals(s.toLowerCase()))
            p=i;
    }
    return getGrade(p+1);
    }
    
    /**
     * returns the students average over their four classes
     * @return a double of the students average
     */
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
    
    /**
     * Returns a string of the students extra curiculars
     * @return a string representation of extras array
     */
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
