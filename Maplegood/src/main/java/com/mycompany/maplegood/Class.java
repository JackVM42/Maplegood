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
public class Class {
        private String name;
        private String code;
        private String teach;
        private ArrayList<Student> list = new ArrayList<Student>();
        
        public Class (String nme, String cd, String a){
            this.name = nme;
            this.code = cd;
            this.teach = a;
        }
        public String getCode(){
            return code;
        }
        public String className(){
            return name;
        }
        public void addStudent(Student a){
            if (a.hasClass(name)){
                list.add(a);
            }
    }
        public String getTeacher(){
            return teach;
        }
        public double getClassAv(){
            
            double av = 0;
            int p;
            //get grade from every student in the class
            for (int i = 0; i<list.size();i++){
                p = list.get(i).getPeriod(name);
                
                av = av + list.get(i).getGrade(p);
            }
            av = av/list.size();
            int dre = (int)(av*100);
            return av = dre/100;
        }
        
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
        public void sortByGrade(){
        // sorts grade from lowest to highest
        for (int i = 1; i<list.size(); i++){
        Student temp = list.get(i);
        int ind = i-1;
        while (ind>=0 && temp.getGrade(name)>list.get(ind).getGrade(name)){
            list.set(ind+1,list.get(ind));
            ind--;
        }
        list.set(ind+1,temp);
  }
        }
        
        public Student getBest(){
            sortByGrade();
            return list.get(list.size()-1);
        }
        
        
                public ArrayList<String> getClassList(){
            ArrayList<String> arr = new ArrayList<String>();
            sortByLast();
            for (int i = 0; i<list.size();i++){
                arr.add(list.get(i).getFullName());
            }
            return arr;
        }
        
                //CODE NO GOOD
        public int getRank(String s){
            //takes full name of student
            String b = s.toLowerCase();
            int rank = -1;
            //this is the area that is not working
            //this.sortByGrade();
            for(int i = 0;i<list.size();i++){
                if(list.get(i).getFullName().toLowerCase().equals(b)){
                    return rank = i+1;
                }
        }
            return rank;
        }


}
