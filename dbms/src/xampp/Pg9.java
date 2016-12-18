/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;

import java.awt.GridLayout;
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
class Pg9 implements ActionListener {
    ResultSet rs;
    Connection connect;
    Statement statement;
JFrame frame ;
    JTextArea jta1 = new JTextArea();
    JTextArea jta2 = new JTextArea();
    JTextArea jta3 = new JTextArea();
    JTextArea jta4 = new JTextArea();
    JTextArea jta5 = new JTextArea();
    JTextArea jta6 = new JTextArea();
    JTextField jtf = new JTextField();
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JPanel panel = new  JPanel();
    JPanel panel2 = new JPanel();
    Pg9()
{
    System.out.println("Hello");
	int i;
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
frame = new JFrame("XAMPP");
JButton b = new JButton("check"); 
JButton c = new JButton("Submit");
b.setBounds(100,100,50,50);
b.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
panel.setLayout(new GridLayout(2,2));
panel.add(new JLabel("Enter table name:"));
panel.add(jtf);
panel.add(c);
frame.add(panel);
c.addActionListener(this);
frame.setLayout(new GridLayout(4,1));
panel2.setLayout(new GridLayout(7,2));
//frame.add(new JLabel("Select:"));
panel2.add(new JLabel("Select:"));
//frame.add(jta1);
panel2.add(jta1);
//frame.add(new JLabel("from"));
panel2.add(new JLabel("from"));
//frame.add(jta2);
panel2.add(jta2);
//frame.add(new JLabel("where"));
panel2.add(new JLabel("where"));
//frame.add(jta3);
panel2.add(jta3);
//frame.add(new JLabel("Group by"));
panel2.add(new JLabel("Group by"));
//frame.add(jta4);
panel2.add(jta4);
//frame.add(new JLabel("Having"));
panel2.add(new JLabel("Having"));
//frame.add(jta5);
panel2.add(jta5);
//frame.add(new JLabel("order by"));
panel2.add(new JLabel("order by"));
//frame.add(jta6);
panel2.add(jta6);
//frame.add(b);
panel2.add(b);
b.addActionListener((ActionListener) this);
b.setActionCommand("submit");
c.setActionCommand("check");
//c.addActionListener((ActionListener) this);
frame.add(jl);
frame.add(jl2);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
}
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getActionCommand().equals("submit"))
        {
        String s1 = jta1.getText();
        String s2 = jta2.getText();
        String s3 = jta3.getText();
        String s4 = jta4.getText();
        String s5 = jta5.getText();
        String s6 = jta6.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
              String user = "root";
              String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
                    statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);            
//statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        
        if(s3.equals("") && s4.equals("") && s5.equals("") && s6.equals(""))
        {
            System.out.println("11");
            try{
            rs = statement.executeQuery("select "+ s1 +" from "+s2 + " ;"); 
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        else if(s3.equals("") && s4.equals("") && s5.equals("") && !s6.equals(""))
        {
            System.out.println("12");
            try{
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + "Order By" + s6 + ";");
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        else if(s3.equals("") && !s4.equals("") && !s5.equals("") && s6.equals(""))
        {
                System.out.println("13");
            try{
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + " where " + s3 + "Order By" + s6 + ";");
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
                else if(!s3.equals("") && s4.equals("") && s5.equals("") && !s6.equals(""))
        {
            try{
                System.out.println("14");
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + " Group By " + s4 + "Having" + s5 + ";");
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        if(!s3.equals("") && s4.equals("") && s5.equals("") && s6.equals(""))
        {
            try{
                System.out.println("15");
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + " where " + s3 + ";");
            //jl.setText(rs.toString());
        }catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        if(!s3.equals("") && !s4.equals("") && s5.equals("") && s6.equals(""))
        {
            try{
                System.out.println("16");
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + " where " + s3 +" Group By "+ s4 + ";");
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        if(!s3.equals("") && !s4.equals("") && !s5.equals("") && s6.equals(""))
        {
            try{
                System.out.println("17");
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 + " where " + s3 +" Group By "+ s4 + "Having" + s5 + ";");
            //jl.setText(rs.toString());
        }
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        if(s3.equals("") && !s4.equals("") && !s5.equals("") && !s6.equals(""))
        {
            try{
                System.out.println("18");
            rs = statement.executeQuery("Select "+ s1 +" from "+s2 +" Group By "+s4 + "Having" + s5 + " Order By " +s6 + ";");
            }//jl.setText(rs.toString());
            catch (SQLException ex) {
            //Logger.getLogger(Pg5.class.getName()).log(Level.SEVERE, null, ex);
               jl.setText(ex.toString());
        }
        }
        ResultSetMetaData rsmd2 = null;
            try {
                rsmd2 = rs.getMetaData();
            } catch (SQLException ex) {
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd2.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl2.setText(jl2.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else if(ae.getActionCommand().equals("check"))
        {
            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("class for name error");
        }
        String host = "localhost";
        String user = "root";
        String passwd = "";
        try {
            connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root","");  
        } catch (SQLException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connect error");
        }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("statement error");
        }
        String s1 = jtf.getText();
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
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
        int columnsNumber = 0;
            try {
                columnsNumber = rsmd.getColumnCount();
            } catch (SQLException ex) {
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (rs.next()) {
                    for (int i = 1; i <= 2; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        jl.setText(jl.getText()+" " + columnValue +" " );//+ rsmd.getColumnName(i)+ "  ");
                    }
                   
                }           } catch (SQLException ex) {
                Logger.getLogger(Pg9.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame.add(panel2);
        }
    }
    }
