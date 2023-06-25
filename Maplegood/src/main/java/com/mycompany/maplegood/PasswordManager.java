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
         
        //storage variales
        public static HashMap<String, String> data = new HashMap<>();//hash map to store username and passwords
        public static ArrayList<Student> studentObjectList = new ArrayList<>();//stores all student objects which have been created
        public static String currentName = "";//store the name of the student currently being worked with
        public static Student currentStudent = null;//stores the student object we are currently working with
        
        //make classes
        public static final Class mathClass = new Class("math", "MHF 4U", "Yanchus");
        public static final Class physicsClass = new Class("physics", "SPH 4U", "Braithwaite");
        public static final Class chemistryClass = new Class("chemistry", "SCH 4U", "Key");
        public static final Class computerScienceClass = new Class("computer science", "ICS 4U", "Kaune");
        public static final Class englishClass = new Class("english", "ENG 4U", "Mathewson");
        public static final Class frenchClass = new Class("french", "FIF 4U", "Leroy");
        public static final Class calculusClass = new Class("calculus", "MCV 4U", "Hyde");
        public static final Class miscellaneousClass = new Class("miscellaneous", "NA 4U", "N/A");
        //array to keep track of all classes
        public static final Class[]  schoolClass = {mathClass,physicsClass,chemistryClass,computerScienceClass,englishClass,frenchClass,calculusClass,miscellaneousClass};
        
        /**
         * This method creates three default students to use as examples in testing
         */
        public static void defaultStudents(){
    
        //move usernames and passwords into hashmap (hash passwords using sha256)
            data.put("Ben", sha256Hash("1337"));
            data.put("Jack", sha256Hash("pass42"));
            data.put("Brendan",sha256Hash("incorrect"));
            
            //create default students
            //Student 1
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
            
            //Student 2
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
            
            //Student 3
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
        
        /**
         * Method to check whether or not the entered name and password match
         * @param name the name entered when logging in
         * @param password the password entered when logging in
         * @return true if they match and false if they do not
         */
        public static boolean checkPassword(String name, String password) {

                //gets what PASSWORD should be (sets password to null if username dose not exist)
                String RealPass = data.get(name);

                //if the entered password(hashed) equals the stored password(hashed) then access granted
                if(sha256Hash(password).equals((RealPass))) {
                    return true;
                }
                else {
                    return false;
                }
        }
        
        /**
         * Creates a new account in the login hash map
         * @param name name used to login
         * @param password desired password
         */
        public static void newAccount(String name, String password) {
            //puts the name and encrypted password into the hashmap
             data.put(name, sha256Hash(password));                  
        }
        
        /**
         * Creates a new student object
         * @param firstName first name of student
         * @param middleName middle name of student
         * @param lastName last name of student
         * @param age age of student
         * @param homeRoom home room of student
         * @param extras an array list of the extra curriculars the student does
         * @param period1 the first period of the student
         * @param period2 the second period of the student
         * @param period3 the third period of the student
         * @param period4 the fourth period of the student
         * @return the student object which was created
         */
        public static Student newStudent(String firstName, String middleName, String lastName, int age, String homeRoom, ArrayList<String> extras, String period1,String period2,String period3,String period4){
            //create the student object with the inputs
            Student stu1 = new Student(firstName, middleName, lastName, age, homeRoom, extras, period1,period2, period3, period4);
            //add them to the student list
            studentObjectList.add(stu1);
            //makes the return
            return stu1;
        }
        
        /**
         * Removes the account from the login hash map
         * @param name name of the student to remove
         */
        public static void removeAccount(String name){
            data.remove(name);
        }
        
        /**
         * finds the student with the currentName
         */
        public static void findStudent(){
            //iterates through the studentObjectList
           for(int i = 0; i < studentObjectList.size(); i++){
               
                //checks if the current iterated student's name matches the target 
               if(studentObjectList.get(i).getFirstName().equals(currentName)){
                   //sets the current student
                   currentStudent = studentObjectList.get(i);
               }
               
           } 
        }
        
        /**
         * Removes the student object from the list of student object
         * @param name name of student to remove
         */
        public static void removeStudent(String name){
            //iterates through the studentObjectList
            for(int i = 0; i < studentObjectList.size(); i++){
                //checks if we haev reached the target
               if(studentObjectList.get(i).getFirstName().equals(name)){
                   //removes the object
                   studentObjectList.remove(i);
               }
           } 
        }
        
        /**
         * returns the timetable of current student
         * @return an array of the classes the student is in 
         */
        public static Class[] currStudentTimeTable(){
            
            //creates the array and populates it with misc class so that it has something to call
            Class[] classes = new Class[4];
            classes[0] = miscellaneousClass;
            classes[1] = miscellaneousClass;
            classes[2] = miscellaneousClass;
            classes[3] = miscellaneousClass;
            
            //check math
            int check = currentStudent.hasClas("math");
            
            if(check != -1){
                classes[check] = mathClass;
            }
            
            //check physics
            check = currentStudent.hasClas("physics");
            
            if(check != -1){
                classes[check] = physicsClass;
            }
            
            //check chemistry
            check = currentStudent.hasClas("chemistry");
            
            if(check != -1){
                classes[check] = chemistryClass;
            }
            
            //check comp sci
            check = currentStudent.hasClas("computer science");
            
            if(check != -1){
                classes[check] = computerScienceClass;
            }
            
            //check english
            check = currentStudent.hasClas("english");
            
            if(check != -1){
                classes[check] = englishClass;
            }
            
            //check french
            check = currentStudent.hasClas("french");
            
            if(check != -1){
                classes[check] = frenchClass;
            }
            
            //check calc
            check = currentStudent.hasClas("calculus");
            
            if(check != -1){
                classes[check] = calculusClass;
            }
            
            //check misc
            check = currentStudent.hasClas("miscellaneous");
            
            if(check != -1){
                classes[check] = miscellaneousClass;
            }
            
            //return the array
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
