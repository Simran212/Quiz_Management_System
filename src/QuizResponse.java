
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vss72
 */
public class QuizResponse
{   
    String answers[];
    String correctAnswers[];
    int score;
    public QuizResponse( String answers[],String correctAnswers[],int weigthage[],String name,String stdId,int k){
     
        this.answers=new String[answers.length];
        this.answers=answers;
        this.correctAnswers=new String[answers.length];
         this.correctAnswers=correctAnswers;
        for(int i=0;i<answers.length;i++)
        {if(this.answers[i]!=null)
            {
                
             System.out.println(this.correctAnswers[i]+"---"+this.answers[i]);
            if(this.correctAnswers[i].equals(this.answers[i]))
            {
                score=score+weigthage[i];
               
            }
            }
        }
           String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
               String tableName = "QUIZRESPONSE";
                // jdbc Connection
                Connection conn = null;
                Statement stmt = null;   
         try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
        try
        {      
                stmt = conn.createStatement();
             String query = " insert into QUIZRESPONSE (QUIZNAME,SCORE,STDID)"
        + " values (?, ?, ?)";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
        
         ps.setString(1,name);
         ps.setString(3,stdId);
         ps.setInt(2,this.score);
          ps.execute();
            
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    
        
    }




}
