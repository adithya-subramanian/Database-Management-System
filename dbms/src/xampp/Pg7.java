/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg7 implements ActionListener {
    Connection connect;
    int size;
    Statement statement;
    ResultSet rs;
    JTextArea jta1 = new JTextArea();
    JTextArea jta2 = new JTextArea();
    JTextArea jta3 = new JTextArea();
    JTextArea jta4 = new JTextArea();
    JLabel jl = new JLabel();
    JTextField jtf = new JTextField();
    JPanel panel = new  JPanel();
    JPanel panel2 = new JPanel();
    JFrame frame = new JFrame("XAMPP");
    Pg7()
{
    
	int i;
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);

JButton b = new JButton("Submit");
JButton c = new JButton("Check");
b.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
panel.setLayout(new GridLayout(2,2));
panel2.setLayout(new GridLayout(5,2));
panel.add(new JLabel("Enter the table"));
panel.add(jtf);
panel.add(c);
frame.setLayout(new GridLayout(3,1));
frame.add(panel);
frame.add(jl);
panel2.add(new JLabel("Upadte Table"));
panel2.add(jta1);
panel2.add(new JLabel("column name:"));
panel2.add(jta2);
panel2.add(new JLabel("value"));
panel2.add(jta3);
panel2.add(new JLabel("where:"));
panel2.add(jta4);
panel2.add(b);
b.addActionListener(this);
c.addActionListener(this);
b.setActionCommand("Submit");
c.setActionCommand("check");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Submit"))
        {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            //connect = DriverManager
                    //.getConnection("jdbc:mysql://" + host + "/feedback?"
                            //+ "user=" + user + "&password=" + passwd );
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s1 = jta1.getText();
        String s2 = jta2.getText();
        String s3 = jta3.getText();
        String s4 = jta4.getText();
        String query = "update "+ s1 + " set " + s2 + " = " + s3 /*+ " where " + s4 +*/ + " ;";
        try {
            size = statement.executeUpdate(query);
        } catch (SQLException ex) {
            //Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            jl.setText(ex.toString());
        }
         jl.setText(size + " Records Updated");
        }
        else if(ae.getActionCommand().equals("check"))
        {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        String s1 = jtf.getText();
        String query = "select * from " + s1 +";"; 
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
                Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl.setText(jl.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame.add(panel2);       
        }
    
    }
}
