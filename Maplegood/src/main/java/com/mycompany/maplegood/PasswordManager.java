package com.mycompany.maplegood;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jackvanmilligen
 */

import java.util.Scanner;
import java.util.HashMap;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class PasswordManager {
         
        public static HashMap<String, String> data = new HashMap<>();


        public static boolean checkPassword(String name, String password) {

            //move usernames and passwords into hashmap (hash passwords using sha256)
            data.put("Ben", sha256Hash("password123"));
            data.put("Jacob", sha256Hash("superinsanepassword"));
            data.put("hacker", sha256Hash("1337"));



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
             
             
             //NOTE MAKE STUDENT OBJECT
                     
        }
        
        public static void removeAccount(String name){
            data.remove(name);
        }



        public static String sha256Hash(String input) {


        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));


            String hash = new String(hashBytes, StandardCharsets.UTF_8);


            System.out.println("SHA-256 Hash: " + hash);
            return hash;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }

    }

    }
