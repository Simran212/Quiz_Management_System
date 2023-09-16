package Packages;


import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vss72
 */
abstract public class Person {
    private int age;
    private String name;
    private String sex;
    private final boolean activeOrInactive; 
    Person(int age,String name,String sex,boolean activeOrInactive)
    {
        this.age=age;
        this.name=name;
        this.sex=sex;
        this.activeOrInactive=activeOrInactive;
    }
    
    
}
