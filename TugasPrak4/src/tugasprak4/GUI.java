/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel username = new JLabel("Username : "); 
    JTextField user = new JTextField(15);
    JLabel password = new JLabel("Password : ");
    JPasswordField pass = new JPasswordField(15);
    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");
    JLabel regisuname = new JLabel ("Username : ");
    JTextField regisusername = new JTextField(15);
    JLabel registpass = new JLabel("Password : ");
    JPasswordField registpassword = new JPasswordField(15);
    JButton register = new JButton("Register");
    
    public GUI() {
       setTitle("Login & Register");
       setSize(500, 200);
       
       setLayout(null);
       
       add(username);
       add(user);
       add(password);
       add(pass);
       add(login);

       add(regisuname);
       add(regisusername);
       add(registpass);
       add(registpassword);
       add(register);
       
       username.setBounds(20, 20, 80, 20);
       user.setBounds(100, 20, 90, 20);
       password.setBounds(20, 50, 80, 20);
       pass.setBounds(100, 50, 90, 20);
       login.setBounds(100, 100, 80, 20);
       regisuname.setBounds(240, 20, 80, 20);
       regisusername.setBounds(320, 20, 90, 20);
       registpass.setBounds(240, 50, 80, 20);
       registpassword.setBounds(320, 50, 90, 20);
       register.setBounds(320, 100, 100, 20);
       
       login.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0){
               Koneksi konek = new Koneksi();
               String usernm = user.getText();
               System.out.println(usernm);
               if(konek.chekUsername(usernm) && usernm != "" && konek.chekLogin(usernm, String.valueOf( pass.getPassword()))){
                   JOptionPane.showMessageDialog(null, "Login Success");
               }else if(usernm.isEmpty() || String.valueOf(pass.getPassword()).isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
               else if(!konek.chekUsername(usernm)){
                   JOptionPane.showMessageDialog(null, "Username Salah");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Password Salah");
               }
           }
       });
       
       register.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Koneksi konek = new Koneksi();
               String regisuname = regisusername.getText();
               String registpass = String.valueOf(registpassword.getPassword());
               if(!regisuname.isEmpty() && !registpass.isEmpty()){
                   konek.insertData(regisuname, registpass);
               }
               else if(regisuname.isEmpty() || registpass.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
           }
           
       });
       
       setVisible(true);
    }
}