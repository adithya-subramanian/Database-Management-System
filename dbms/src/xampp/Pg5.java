/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg5 implements ActionListener{
    Statement statement;
    Connection connect;
    JTextArea jta1 = new JTextArea();
    JLabel jl = new JLabel();
    Pg5()
{
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
JFrame frame = new JFrame("XAMPP");
JButton b1 = new JButton("Submit");
b1.setBounds(0,100,200,200);
frame.setBounds(0,0,600,600);
frame.setLayout(new GridLayout(2,2));
frame.add(new JLabel(" Drop Table"));
frame.add(jta1);
frame.add(b1);
frame.add(jl);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
b1.addActionListener(this);
//frame.pack();
}
    public void actionPerformed(ActionEvent ae)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        String s1 = jta1.getText();
        String query = "DROP TABLE " + s1; 
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        jl.setText("Table Dropped");
    }
}
