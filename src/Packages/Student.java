package Packages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vss72
 */
public class Student extends Person{
    private int studentId;
    private float CGPA;
    String batch;
    private String password;
    
  public Student(int studentId,String batch,String password,int age,String name,String sex,boolean activeOrInactive)
    {
        super(age,name,sex,activeOrInactive);
        this.studentId=studentId;
        this.batch=batch;
        this.password=password;
    }
    int GetStudentId()
    {
        return studentId;
    }
    void SetStudentId(int id)
    {
        this.studentId=id;
        return;
    }
    
    void SetCGPA(float CGPA)
    {
        this.CGPA=CGPA;
        return;
    }
    
    float GetCGPA()
    {
        return CGPA;
    }
    String GetPassword()
    {
        return password;
    }
    void SetPassword(String password)
    {
        this.password=password;
    }
    
}
