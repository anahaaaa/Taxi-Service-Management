
package com.mycompany.taxiservicemanagement;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author abhir
 */
public class DataBase {
    Connection connection = null;
    public DataBase(){
   
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DB50",
                "root", "");
        }catch(Exception e){}
    }
   
    Boolean registerUser(String name,String Adhar,String phone,String age,String gender){
       
        try{
            String query="insert into users(name,age,phno,adhar_no,gender) values('"+name+"','"+age+"','"+phone+"','"+Adhar+"','"+gender+"');";
            Statement stm= connection.createStatement();
            System.out.print(query);
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    void findUser(String id){
        String query="select * from users where id ='"+id+"';";
        try{
            connection.createStatement().executeQuery(query);
           
        }
        catch(Exception e){}
       
    }

   
}

