package com.mycompany.maplegood;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jackvanmilligen
 */

import java.util.HashMap;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class PasswordManager {
         
        //storage forms
        public static HashMap<String, String> data = new HashMap<>();
        public static ArrayList<Student> studentObjectList = new ArrayList<>();
        public static String currentName = "";
        public static Student currentStudent = null;
        
        //make classes
        public static final Class mathClass = new Class("math", "MHF 4U", "Yanchus");
        public static final Class physicsClass = new Class("physics", "SPH 4U", "Braithwaite");
        public static final Class chemistryClass = new Class("chemistry", "SCH 4U", "Key");
        public static final Class computerScienceClass = new Class("computer science", "ICS 4U", "Kaune");
        public static final Class englishClass = new Class("english", "ENG 4U", "Mathewson");
        public static final Class frenchClass = new Class("french", "FIF 4U", "Leroy");
        public static final Class calculusClass = new Class("calculus", "MCV 4U", "Hyde");
        public static final Class miscellaneousClass = new Class("miscellaneous", "NA 4U", "N/A");
        public static final Class[]  schoolClass = {mathClass,physicsClass,chemistryClass,computerScienceClass,englishClass,frenchClass,calculusClass,miscellaneousClass};
        
        public static void defaultStudents(){
    
        //move usernames and passwords into hashmap (hash passwords using sha256)
            data.put("Ben", sha256Hash("1337"));
            data.put("Jack", sha256Hash("pass42"));
            data.put("Brendan",sha256Hash("incorrect"));
            
            //create default students
            ArrayList<String> str = new ArrayList<>();
            str.add("Rugby");
            currentStudent = new Student("Jack", "Allan John", "Van Milligen", 18, "12W", str,  "Calculus", "Physics", "math", "computer Science");
            studentObjectList.add(currentStudent);
            physicsClass.addStudent(currentStudent);
            calculusClass.addStudent(currentStudent);
            computerScienceClass.addStudent(currentStudent);
            mathClass.addStudent(currentStudent);
            currentStudent.setGrades(1, 75);
            currentStudent.setGrades(2, 50);
            currentStudent.setGrades(3, 100);
            currentStudent.setGrades(4, 1);
            
            str.clear();
            str.add("Baseball");
            str.add("Badminton");
            str.add("Track");
            str.add("Science Team");
            currentStudent = new Student("Brendan", "Thomas Jones", "Abbey", 18, "12A", str, "Calculus", "Physics", "math", "computer Science");
            studentObjectList.add(currentStudent);
            physicsClass.addStudent(currentStudent);
            calculusClass.addStudent(currentStudent);
            computerScienceClass.addStudent(currentStudent);
            mathClass.addStudent(currentStudent);
            currentStudent.setGrades(1, 100);
            currentStudent.setGrades(2, 15);
            currentStudent.setGrades(3, 2);
            currentStudent.setGrades(4, 0);
            
            
            str.clear();
            str.add("Track");
            currentStudent = new Student("Ben", "Danger", "Bernardino", 18, "12B", str, "Calculus", "Physics", "math", "computer Science");
            studentObjectList.add(currentStudent);
            physicsClass.addStudent(currentStudent);
            calculusClass.addStudent(currentStudent);
            computerScienceClass.addStudent(currentStudent);
            mathClass.addStudent(currentStudent);
            currentStudent.setGrades(1, 3);
            currentStudent.setGrades(2, 0);
            currentStudent.setGrades(3, 30);
            currentStudent.setGrades(4, 25);
        }
        
        
        

        public static boolean checkPassword(String name, String password) {

                //gets what PASSWORD should be (sets password to null if username dose not exist)
                String RealPass = data.get(name);

                //if the entered password(hashed) equals the stored password(hashed) then access granted
                if (sha256Hash(password).equals((RealPass))) {
                    return true;
                }
                else {
                    return false;
                }

        }
        
        public static void newAccount(String name, String password) {
             data.put(name, sha256Hash(password));                  
        }
        
        public static Student newStudent(String firstName, String middleName, String lastName, int age, String homeRoom, ArrayList<String> extras, String period1,String period2,String period3,String period4){
            Student stu1 = new Student(firstName, middleName, lastName, age, homeRoom, extras, period1,period2, period3, period4);
            studentObjectList.add(stu1);
            return stu1;
        }
        
        public static void removeAccount(String name){
            data.remove(name);
            
            //NOTE Remove student object
        }
        
        public static void findStudent(){
           for(int i = 0; i < studentObjectList.size(); i++){
               if(studentObjectList.get(i).getFirstName().equals(currentName)){
                   currentStudent = studentObjectList.get(i);
               }
           } 
        }
        
        public static void removeStudent(String name){
            for(int i = 0; i < studentObjectList.size(); i++){
               if(studentObjectList.get(i).getFirstName().equals(name)){
                   studentObjectList.remove(i);
               }
           } 
        }
        
        public static Class[] currStudentTimeTable(){
            Class[] classes = new Class[4];
            classes[0] = miscellaneousClass;
            classes[1] = miscellaneousClass;
            classes[2] = miscellaneousClass;
            classes[3] = miscellaneousClass;
            
            //math
            int check = currentStudent.hasClas("math");
            
            if(check != -1){
                classes[check] = mathClass;
            }
            
            //physics
            check = currentStudent.hasClas("physics");
            
            if(check != -1){
                classes[check] = physicsClass;
            }
            
            //chemistry
            check = currentStudent.hasClas("chemistry");
            
            if(check != -1){
                classes[check] = chemistryClass;
            }
            
            //comp sci
            check = currentStudent.hasClas("computer science");
            
            if(check != -1){
                classes[check] = computerScienceClass;
            }
            //english
            check = currentStudent.hasClas("english");
            
            if(check != -1){
                classes[check] = englishClass;
            }
            
            //french
            check = currentStudent.hasClas("french");
            
            if(check != -1){
                classes[check] = frenchClass;
            }
            
            //calc
            check = currentStudent.hasClas("calculus");
            
            if(check != -1){
                classes[check] = calculusClass;
            }
            
            //misc
            check = currentStudent.hasClas("miscellaneous");
            
            if(check != -1){
                classes[check] = miscellaneousClass;
            }
            
            return classes;
        }




        public static String sha256Hash(String input) {


        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));


            String hash = new String(hashBytes, StandardCharsets.UTF_8);


            return hash;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }

    }

    }
