
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
abstract class Question
{   String questionID;
    String question;
    int type;
    int weightage;
    Question(String question,int weightage,String questionID)
    {
        this.question=question;
        this.weightage=weightage;
        this.questionID=questionID;
    }
}
class  Mcq extends Question{
    String option1;
    
    String option2;
    
    String option3;
    
    String option4;
    int correctAns;
    public Mcq(String question,int weightage,String questionID, String option1,String option2,String option3,String option4,int correctAns,String quizId)
    {
        super(question,weightage,questionID);
        this.option1=option1;
        
        this.option2=option2;
        
        this.option3=option3;
        
        this.option4=option4;
        this.correctAns=correctAns;
         String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
               String tableName = "QUESTION";
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
             String query = " insert into QUESTION (ID,STATEMENT,TYPE,WEIGTHAGE,MCP_OPTION1,MCQ_OPTION2,MCQ_OPTION3,MCQ_OPTION4,MCQ_CORRECTANSWER,QUIZID,IDN)"
        + " values (?, ?, ?,?, ?, ?,?,?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
        
         ps.setString(1,super.questionID);
         ps.setString(2,super.question);
         ps.setInt(3,1);
         ps.setInt(4, super.weightage);
         
         ps.setString(5,option1);
         ps.setString(6,option2);
          ps.setString(7,option3);
         ps.setString(8, option4);
         ps.setInt(9, this.correctAns);
         
            ps.setString(10, quizId);
       
         ps.setInt(11,Integer.parseInt( super.questionID.substring(4)));
        
          ps.execute();
            
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    
 
    
    }
     public Mcq(String question,int weightage,String questionID, String option1,String option2,String option3,String option4,int correctAns)
    {
        super(question,weightage,questionID);
        this.option1=option1;
        
        this.option2=option2;
        
        this.option3=option3;
        
        this.option4=option4;
        this.correctAns=correctAns;
    }
     String GetOption(int k)
    {
        if(k==1)
        {
         return option1;   
        }
        else if(k==2)
        {
         return option2;   
        }
        
        else if(k==3)
        {
         return option3;   
        }
        {
         return option4;   
        }
        
        
    }
   public int GetAnswer()
     {
         return this.correctAns;
     }
}
class Line extends Question{
    String correctAns;
    public Line(String question,int weightage,String questionID,String correctAnswer,String quizId){
        super(question,weightage,questionID);
        this.correctAns=correctAnswer;
        String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
               String tableName = "QUESTION";
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
             String query = " insert into QUESTION (ID,STATEMENT,TYPE,WEIGTHAGE,LINE_CORRECTANSWER,QUIZID,IDN)"
        + " values (?, ?, ?,?, ?, ?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
        
         ps.setString(1,super.questionID);
         ps.setString(2,super.question);
         ps.setInt(3,2);
         ps.setInt(4, super.weightage);
         ps.setString(5,correctAns);
         ps.setString(6, quizId);
           ps.setInt(7,Integer.parseInt( super.questionID.substring(4)));
       
          ps.execute();
            
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    
    }
       public Line(String question,int weightage,String questionID,String correctAnswer){
        super(question,weightage,questionID);
        this.correctAns=correctAnswer;
     

}
}
