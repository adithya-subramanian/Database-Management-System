/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import static java.nio.file.Files.delete;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg3 implements ActionListener
{
    Statement statement;
    Connection connect;
    JPanel panel = new  JPanel();
    JLabel jl = new JLabel();
   JFrame frame = new JFrame("XAMPP");
    JPanel panel2 = new JPanel();
JPanel panel3 = new JPanel();
JTextField jt1 = new JTextField();
JTextField jt2 = new JTextField();
JTextField jt3 = new JTextField();
JTextField []jtv;
JTextField []jtd;
JTextField []jtc;
JButton b = new JButton("Submit");
     int k = 1;
     String tablename;
     String entry;
      Pg3()
{
	int i;
	int windowheight = 400;
	int windowwidth = 400;
       
JFrame.setDefaultLookAndFeelDecorated(true);

JButton c = new JButton("Submit");
c.setActionCommand("rows");
b.setActionCommand("Submit");
c.addActionListener(this);
b.addActionListener(this);
b.setBounds(100,100,50,50);
c.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
frame.setLayout(new GridLayout(4,1));
/*jt.getDocument().addDocumentListener(new Document(){
   public void changedUpdate(DocumentEvent e )
   {
    warn();
   }
   public void insertUpdate(DocumentEvent e)
   {
       warn();
   }
}
);*/
panel2.setLayout(new GridLayout(3,2));
panel2.add(new JLabel("Table name:"));
panel2.add(jt1);
panel2.add(new JLabel("No of colums:"));
panel2.add(jt2);
//panel3.setLayout(new GridLayout(1,2));
//panel3.add(ar);
panel2.add(c);
frame.add(panel2);
frame.add(jl);
//frame.add(panel);
//frame.add(panel3);
//frame.add(b);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();

}  
      public void actionPerformed(ActionEvent ae) 
      {
          
          String query = "Create Table "+jt1.getText()+" ( ";//+jt1 + jt2 + jt3 + ",";
          if(ae.getActionCommand().equals("rows"))
          {
             jtv = new JTextField[Integer.parseInt(jt2.getText())];
             jtd = new JTextField[Integer.parseInt(jt2.getText())];
             jtc = new JTextField[Integer.parseInt(jt2.getText())];
                for(int uj = 0;uj < Integer.parseInt(jt2.getText());uj++)
                {       
                    jtv[uj] = new JTextField("");
//frame.add(panel);
                    jtd[uj] = new JTextField("");
                    jtc[uj] = new JTextField("");
                }
                for(int i=0;i<Integer.parseInt(jt2.getText());i++)
                     {
                            panel.setLayout(new GridLayout(Integer.parseInt(jt2.getText()),6));
                            panel.add(new JLabel("variable:"));
                            panel.add(jtv[i]);
                            panel.add(new JLabel("datatype:"));
                            panel.add(jtd[i]);
                            panel.add(new JLabel("constraint:"));
                            panel.add(jtc[i]);
                     }
                frame.add(b);
                frame.add(panel);
          }
          else if(ae.getActionCommand().equals("Submit"))
          {
              tablename = jt1.getText();
              String host = "localhost";
              String user = "root";
              String passwd = "";
              
              try
              {
                  Class.forName("com.mysql.jdbc.Driver");
                   connect=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/mynewdb","root",""); 
              }
              catch(SQLException ex)
              {
                  
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Pg3.class.getName()).log(Level.SEVERE, null, ex);
              }
              //System.exit(0);
          }
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Pg3.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0;i<Integer.parseInt(jt2.getText());i++)
        {
            if(i != Integer.parseInt(jt2.getText())-1)
            query = query + jtv[i].getText() + " " + jtd[i].getText() +" "+jtc[i].getText()+",";
            else
                query = query + jtv[i].getText() + " " + jtd[i].getText() +" "+jtc[i].getText()+" ) ;";
        }
        System.out.println(query);
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Pg3.class.getName()).log(Level.SEVERE, null, ex);
        }
         jl.setText("Table Created");  
          }
          
}



    
    

