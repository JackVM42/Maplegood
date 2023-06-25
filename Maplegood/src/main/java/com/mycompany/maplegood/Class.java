/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maplegood;

import java.util.*;


/**
 *
 * @author jackvanmilligen
 */
public class Class {
        
        //initilalize all of our instance variables
        private String name; //stores name of class
        private String code; //stores class code
        private String teach; //stores the classes teacher
        private ArrayList<Student> list = new ArrayList<>(); //stores a array list containing all the student objects in this class
        
        /**
         * Default constructor for the class object
         * @param nme string to receive the name of the class
         * @param cd string to receive the class code for this class
         * @param a string to receive the teachers name
         */
        public Class (String nme, String cd, String a){
            this.name = nme;
            this.code = cd;
            this.teach = a;
        }
        
        /**
         * Getter to return the class code
         * @return String of the class code
         */
        public String getCode(){
            return code;
        }
        
        /**
         * Getter for the class name
         * @return string of the class name
         */
        public String className(){
            return name;
        }
        
        /**
         * Method to add student to the class
         * @param a the student object that is to be added t the class
         */
        public void addStudent(Student a){
            if (a.hasClass(name)){
                list.add(a);
            }
        }
        
        /**
         * Getter to return the teachers name
         * @return returns string of the teachers name
         */
        public String getTeacher(){
            return teach;
        }
        
        /**
         * Returns the class average of all students in the class
         * @return double of the average
         */
        public double getClassAv(){
            
            double av = 0;
            int p;
            //get grade from every student in the class
            for (int i = 0; i<list.size();i++){
                p = list.get(i).getPeriod(name);
                
                av = av + list.get(i).getGrade(p);
            }
            av = av/list.size();
            double dre = Math.round(av * 100.0) / 100.0;
            return dre;
        }
        /**
         * Sorts the students by last name putting them in order alphebetically
         */
        public void sortByLast(){
                //sort students from lowest to highest grade
            for (int i = 1; i<list.size(); i++){
                //sorts students by alphabetical last name
                Student temp = list.get(i);
                int ind = i-1;
                while (ind>=0 && temp.getLast().compareTo(list.get(ind).getLast())<0){
                    list.set(ind+1,list.get(ind));
                    ind--;
                }
                list.set(ind+1,temp);
            }
        }
        
        /**
         * Sorts all the students in the array list by grades lowest to highest
         */
        public void sortByGrade(){
        
        // sorts grade from lowest to highest
        for (int i = 1; i<list.size(); i++){
        Student temp = list.get(i);
        int ind = i-1;
        while (ind>=0 && temp.getGrade(name)<(list.get(ind).getGrade(name))){
            list.set(ind+1,list.get(ind));
            ind--;
        }
        list.set(ind+1,temp);
        }
        }
        
        /**
         * Gets the student with the best grade in the class
         * @return returns the student with the best grade in the class
         */
        public Student getBest(){
            sortByGrade();
            return list.get(list.size()-1);
        }
        
        /**
         * Method to get a list of student names in the class
         * @return a list of every student in the class
         */
        public ArrayList<String> getClassList(){
        ArrayList<String> arr = new ArrayList<>();
        sortByLast();
        for (int i = 0; i<list.size();i++){
            arr.add(list.get(i).getFullName());
        }
        return arr;
        }
        
        /**
         * Takes the full name of a student and returns their rank within the class
         * @param s students full name
         * @return the rank of the student in the class
         */
        public int getRank(String s){
            //takes full name of student
            String b = s.toLowerCase();
            sortByGrade();
            int rank = -1;
            for(int i = list.size() - 1; i>=0; i--){
                if(list.get(i).getFullName().toLowerCase().equals(b)){
                    rank = i;
                }
                }
                return list.size() - rank;
            }


}