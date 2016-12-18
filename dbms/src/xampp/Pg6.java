/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.instrument.Instrumentation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.global;
import javax.swing.*;
import jdk.nashorn.internal.objects.Global;
import static jdk.nashorn.internal.objects.NativeRegExp.global;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg6 implements ActionListener {
    ResultSet rs;
    int size;
    JButton b;
    int hj;
    Instrumentation instrumentation;
    Connection connect;
    Statement statement;
    JTextArea jta1 = new JTextArea();
    JTextArea jta2 = new JTextArea();
    JTextArea jta3 = new JTextArea();
    JTextArea jta4 = new JTextArea();
    JTextArea jta5 = new JTextArea();
    JLabel jl = new JLabel();
    JPanel panel2 = new  JPanel();
    JPanel panel = new  JPanel();
    JTextField []jt;
    JFrame frame = new JFrame("XAMPP");
    Pg6()
{
	int i;
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
b = new JButton("Submit");
JButton c = new JButton("Check");
b.setActionCommand("Submit");
c.setActionCommand("Check");
b.setBounds(100,100,50,50);
c.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
frame.setLayout(new GridLayout(3,1));
panel.setLayout(new GridLayout(1,3));
panel.add(new JLabel("Select the table"));
panel.add(jta5);
panel.add(c);
frame.add(panel);
frame.add(jl);
b.addActionListener(this);
c.addActionListener(this);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
}
    public void actionPerformed(ActionEvent ae)
    {
        
        String s1 = jta5.getText();
        if(ae.getActionCommand().equals("Check"))
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
        System.out.println("near query");
        //String query = "select count(*) from "+s1 +";";
        String query = "desc " + s1 + ";";  
        
        try {
                rs = statement.executeQuery(query);
             //   size = Integer.parseInt(rs.toString());
                
            } catch (SQLException ex) {
                Logger.getLogger(Pg6.class.getName()).log(Level.SEVERE, null, ex);
            }
       // int size = 0;
        try {
        boolean b = rs.last();
        
        if(b){
           size = rs.getRow();
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

            //error prone
            //panel.setLayout(new GridLayout(1,size));
            panel2.add(new JLabel("Insert:"));
            jt = new JTextField[size];
            for (int mn = 0 ;mn < size;mn++)
            {
                jt[mn] = new JTextField("");
            }
            panel2.setLayout(new GridLayout(1,size));
            System.out.println("reached panel");
            System.out.println(size);
            for(int jk =0;jk<size;jk++)
              panel2.add(jt[jk]);
              panel2.add(b);
              frame.add(panel2);
        }
        else if(ae.getActionCommand().equals("Submit"))
        {
        try {
            System.out.println("system");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            System.out.println("connect");
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("statement");
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "insert into "+ jta5.getText();
        for(hj = 0;hj < size;hj++)
        {
            System.out.println("hello");
        if(hj == 0)
        {
            
         query = query + " values (" + jt[hj].getText()+",";
        }
        else if(hj != size-1 && hj != 0)
        query = query + jt[hj].getText()+",";
        else if(hj == size-1)
        query = query + jt[hj].getText() +") ;";
        }
        jl.setText(query);
        try {
            System.out.println("query");
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            //Logger.getLogger(Pg7.class.getName()).log(Level.SEVERE, null, ex);
            jl.setText(ex.toString());
        }
        jl.setText("Data Inserted");
        }
    }
}
