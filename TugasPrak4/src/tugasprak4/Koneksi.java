/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak4;
import java.sql.*;
import javax.swing.JOptionPane;

public class Koneksi {
    String DBurl = "jdbc:mysql://localhost:3306/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";
    //
    String data[] = new String[2];
    Connection connect;
    Statement statement;
    static String[] username;
    
    public Koneksi() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
    
    void insertData(String username, String password){
        try {
            if(!chekUsername(username)){
                String query = "INSERT INTO `users`(`username`,`password`) "
                    + "VALUES('" + username + "','" + password + "')";

                statement = connect.createStatement();
                statement.executeUpdate(query);

                System.out.println("Input Success");
                JOptionPane.showMessageDialog(null, "Register Success");
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Tersedia");
            }
            
        } catch (Exception ex) {
            System.out.println("Input Failed");
        }
    }
    
     String[] readData(){
        try {
            String query = "SELECT * FROM `users`";
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username"); 
//                data[1] = resultSet.getString("password"); 
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        } finally {
            return data;
        }
    }
     
     boolean chekUsername(String username){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username"); 
            }
            statement.close();
            data[0].toString();
            return true;
         } catch (Exception e) {
             System.out.println("Tidak Ada");
            return false;
         }
         
            
         
     }
     
     boolean chekLogin(String username, String password){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username"); 
                data[1] = resultSet.getString("password");
            }
            statement.close();
             System.out.println(data[1].toString());
             System.out.println(password);
            if(data[1].toString().equals(password)){
                return true;
            }else{
                return false;
            }
            
         } catch (Exception e) {
             System.out.println("Tidak Ada");
            return false;
         }
         
            
         
     }
}
