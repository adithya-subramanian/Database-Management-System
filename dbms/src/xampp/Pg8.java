/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Adithyaanirudhha
 */
class Pg8 implements ActionListener{
    JLabel labl =new JLabel();
    JTextArea jta1 = new JTextArea();
    JTextArea jta2 = new JTextArea();
    JTextArea jta3 = new JTextArea();
    JLabel jl = new JLabel();
    JTextField jtf = new JTextField();
    ResultSet rs;
    JFrame frame = new JFrame("XAMPP");
    Connection connect;
    Statement statement;
    JPanel panel = new  JPanel();
    JPanel panel2 = new JPanel(); 
    Pg8()
    {
        int i;
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
JButton b1 = new JButton("Submit");
JButton b2 = new JButton("Check");
b1.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
panel.setLayout(new GridLayout(2,2));
panel.add(new JLabel("Enter table name:"));
panel.add(jtf);
panel.add(b2);
panel2.setLayout(new GridLayout(3,2));
frame.setLayout(new GridLayout(3,1));
frame.add(panel);
//frame.add(labl);

frame.add(jl);//frame.add(new JLabel(""));
panel2.add(new JLabel("delete from:"));
panel2.add(jta1);
panel2.add(new JLabel("where"));
panel2.add(jta2);
panel2.add(b1);
b1.addActionListener(this);
//frame.add(b2);
b2.addActionListener(this);
b2.setActionCommand("check");
b1.setActionCommand("Submit");

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
   {
    String s = ae.getActionCommand();
    if(s.equals("Submit"))
    {
        String s1 = jta1.getText();
        String s2 = jta2.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "delete from "+s1+" where "+s2;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            //Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            jl.setText(ex.toString());
        }
        ResultSetMetaData rsmd2 = null;
            try {
                rsmd2 = rs.getMetaData();
            } catch (SQLException ex) {
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd2.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl.setText(jl.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
              
            }
          jl.setText("Records Deleted");
    }
    else if(s.equals("check"))
    {
        //String s1 = jta1.getText();
        jl.setText("");
        try {
            System.out.println("in class");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            System.out.println("connect");
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
            System.out.println("statement");
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        String s1 = jtf.getText();
        String query = "select * from " + s1 +";"; 
        try {
            System.out.println("query");
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
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("output");
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl.setText(jl.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg8.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame.add(panel2);
    }
   }
}

