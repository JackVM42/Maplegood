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
        public static ArrayList<String> extraCuriculars = new ArrayList<>();
        public static String currentName = "";
        public static Student currentStudent = null;

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
        
        public static void newStudent(String firstName, String middleName, String lastName, int age, String homeRoom, String period1,String period2,String period3,String period4){
            studentObjectList.add(new Student(firstName, middleName, lastName, age, homeRoom, extraCuriculars, period1,period2, period3, period4));
           extraCuriculars.clear();
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
