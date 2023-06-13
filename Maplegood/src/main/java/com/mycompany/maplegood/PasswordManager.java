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
             
             System.out.println("Entire Map:");
             System.out.println(data);                     
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



        public static String sha256Hash(String input) {


        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));


            String hash = new String(hashBytes, StandardCharsets.UTF_8);


            //System.out.println("SHA-256 Hash: " + hash);
            return hash;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }

    }

    }
