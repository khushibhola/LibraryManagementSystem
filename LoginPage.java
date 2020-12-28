/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author USER
 */
public class LoginPage implements ActionListener
{
   static JFrame f;
   static JLabel l1,l2;
   static JButton b1;
   static JTextField t1,t2;
   LoginPage()
   {
        f=new JFrame("LABEL EXAMPLE");
        b1=new JButton("CLICK");
        l1=new JLabel("Enter user name");
        l2=new JLabel("Enter Password");
        t1=new JTextField();
        t2=new JTextField();
        l1.setBounds(50,50,200,30);
        l2.setBounds(50,100,200,30);
        b1.setBounds(100,200,100,30);
        t1.setBounds(200,50,200,30);
        t2.setBounds(200,100,200,30);
        b1.addActionListener(this);
        f.add(b1);
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
   }
   public static void main(String args[])
   {
       LoginPage obj=new LoginPage();
   }
   public void actionPerformed(ActionEvent e)
   {
  
        String n=t1.getText();
        String p=t2.getText();
        Connection conn=null;
        Statement stmt=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("connecting to table");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        System.out.println("creting a statement");
        stmt = conn.createStatement();
        
            String query;
            int found=0;
            query = "select email_id, password from userlogin where email_id='"+n+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String emp1 = rs.getString("email_id");
                String emp2 = rs.getString("password");
                if(emp1.equals(n) && emp2.equals(p))
                {
                    found=1;
                }

            }
            if(found==1)
            {
                System.out.println("you are successfully logged in");
                /*JFrame f2=new JFrame("Details");
                f2.setSize(400,400);
                f2.setLayout(null);
                f2.setVisible(true);*/
                
            }
            else
            {
                
                System.out.println("either username or password is incorrect,or the user have not been authorized");
               // JOptionPane.showMessageDialog(null,"either username or password is incorrect,or the user have not been authorized");
                        
            }
         
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            } 
   }
}