/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg4 implements ActionListener {
JFrame frame = new JFrame("XAMPP");
    ResultSet rs;
    int result;
Connection connect;
Statement statement;
PreparedStatement ps;
JTextArea jt1 = new JTextArea();
JTextArea jt2 = new JTextArea();
JTextArea jt3 = new JTextArea();
JLabel jl = new JLabel();
JTextField jt = new JTextField();
JPanel panel = new  JPanel();
JPanel panel2 = new  JPanel();
Pg4()
{
    System.out.println("1");
	int i;
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
JButton b = new JButton("Submit");
JButton c = new JButton("Check");
b.setBounds(100,100,50,50);
c.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
frame.setLayout(new GridLayout(3,1));
panel.setLayout(new  GridLayout(2,2));
panel2.setLayout(new  GridLayout(4,2));
panel.add(new JLabel("table name:"));
panel.add(jt);
panel.add(c);
frame.add(panel);
panel2.add(new JLabel("Alter Table name:"));
panel2.add(jt1);
panel2.add(new JLabel("drop/add"));
panel2.add(jt2);
panel2.add(new JLabel("column name and data type separated by  a space:"));
panel2.add(jt3);
panel2.add(b);
frame.add(jl);
//frame.add(panel2);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
b.addActionListener(this);
c.addActionListener(this);
b.setActionCommand("submit");
c.setActionCommand("check");
}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("submit"))
        {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host = "localhost";
        String user = "root";
        String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root",""); 
        } catch (SQLException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s11 = jt1.getText();
        String s2 = jt2.getText();
        String s3 = jt3.getText();
        try {
            statement = connect.createStatement();
        }catch (SQLException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(s2.equals("drop"))
        {
            String query  = "Alter table "+ s11+" "+ s2 +" " + s3 +" " + ";"; 
            try {
               result = statement.executeUpdate(query);
            } catch (SQLException ex) {
                //Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
                jl.setText(ex.toString());
            }
            
        }
        else if(s2.equals("add"))
        {
            String query  = "Alter table "+ s11+" "+ s2 +" " + s3 +" " + ";"; 
            try {
               result = statement.executeUpdate(query);
            } catch (SQLException ex) {
                //Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
                jl.setText(ex.toString());
            }
        }
        jl.setText("Table altered");
        
        //try {
                //while (rs.next()) {
                    //for (int i = 1; i <= 2; i++) {
                       // if (i > 1) System.out.print(",  ");
                      //  String columnValue = rs.getString(i);
                    //    jl.setText(jl.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                  //  }
                   
                //}           } catch (SQLException ex) {
               // Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
        else if(ae.getActionCommand().equals("check"))
        {
            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        String s1 = jt.getText();
        String query = "desc " + s1 +";"; 
        try {
           rs =  statement.executeQuery(query);
        } catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        //jl.setText(rs.toString());
        ResultSetMetaData rsmd = null;
            try {
                rsmd = rs.getMetaData();
            } catch (SQLException ex) {
                Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (rs.next()) {
                    for (int i = 1; i <= 2; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl.setText(jl.getText()+" " + columnValue +" " +"\n");//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg4.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame.add(panel2);
    }}
}
