
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vss72
 */

public class Quiz{
    private String quizId;
    Question[] question;
   public int i;
   public int MM;
      public int numberOfQuestions;
    String name;
    public Quiz(String quizId,int MM,int numberOfQuestions,String name)
    {   i=1;
        this.quizId=quizId;
        this.MM=MM;
        this.numberOfQuestions=numberOfQuestions;
        this.name=name;
        question=new Question[numberOfQuestions];
        String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
               String tableName = "QUIZ";
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
             String query = " insert into QUIZ (ID,MAXMARKS,NUMBEROFQUESTIONS,TITLE,IDN)"
        + " values (?, ?, ?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
         //putting value for all placeholder (?)
        
         ps.setString(1,quizId);
         ps.setInt(2,MM);
         ps.setInt(3,numberOfQuestions);
         ps.setString(4,name);
         
         ps.setInt(5,Integer.parseInt( quizId.substring(4)));
         
          ps.execute();
            
      
      conn.close();
       }
        catch (SQLException sqlExcept)
        {   
            sqlExcept.printStackTrace();
        }
    }
    public Quiz(ResultSet results)
    {
         i=1;
         System.out.println("run1");
         String dbURL = "jdbc:derby://localhost:1527/QuizManagement;create=true;user=root;password=pass";
               String tableName = "QUIZ";
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
        try {
            
         System.out.println("run2");
            if(results!=null)
            {
         System.out.println("run3");
                this.quizId=results.getString(1);
                this.name=results.getString(4);
                this.MM=results.getInt(2);
                this.numberOfQuestions=results.getInt(3);
                
                
                question=new Question[this.numberOfQuestions];
            try
            {
                stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery("select * from question where quizid='"+this.quizId+"'");
                ResultSetMetaData rsmd = result.getMetaData();

                while(result.next())
                {   
                    System.out.println("run4");
                  if(result.getInt(3)==2)  
                  {//public Line(String question,int weightage,String questionID,String correctAnswer,String quizId){
                      question[i-1]=new Line(result.getString(2),result.getInt(4),result.getString(1),result.getString(10));
                      question[i-1].type=2;

                  }
                 else if(result.getInt(3)==1)
                  {
                      // public Mcq(String question,int weightage,String questionID, String option1,String option2,String option3,String option4,int correctAns)

                      question[i-1]=new Mcq(result.getString(2),result.getInt(4),result.getString(1),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
                      question[i-1].type=1;
                  }
                  i++;
                }
                result.close();
                stmt.close();
            }
                   
            catch (SQLException sqlExcept)
            {
                sqlExcept.printStackTrace();
            }


                }
            results.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
   void Display()
   {
       
   
   }
   void AddQuestion(Mcq mcq)
   {if(i<=this.numberOfQuestions){
       question[i-1]=mcq;
       i++;}
   }
   
   void AddQuestion(Line line)
   {if(i<=this.numberOfQuestions){
    
       question[i-1]=line;
       i++;}
   }
   String getQuizId()
   {
       return quizId;
   }

}

