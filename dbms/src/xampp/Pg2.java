/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Adithyaanirudhha
 */
class Pg2 implements ActionListener {
    Pg2()
{
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
JFrame frame = new JFrame("XAMPP");
JButton b1 = new JButton("create a Table");
JButton b2 = new JButton("alter a Table");
JButton b3 = new JButton("drop a Table");
JButton b4 = new JButton("Insert data");
JButton b5 = new JButton("update table");
JButton b6 = new JButton("Delete Record");
JButton b7 = new JButton("Select Record");
b1.setBounds(0,100,200,200);
b2.setBounds(200,100,200,200);
b3.setBounds(400,100,200,200);
b4.setBounds(400,100,200,200);
b5.setBounds(400,100,200,200);
b6.setBounds(400,100,200,200);
b7.setBounds(400,100,200,200);
frame.setBounds(0,0,600,600);

frame.setLayout(new GridLayout(7,1));
frame.add(b2);
frame.add(b3);
frame.add(b4);
frame.add(b1);
frame.add(b5);
frame.add(b6);
frame.add(b7);
b1.setActionCommand("Create");
b2.setActionCommand("alter");
b3.setActionCommand("drop");
b4.setActionCommand("insert");
b5.setActionCommand("update");
b6.setActionCommand("delete");
b7.setActionCommand("select");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
}
   public void actionPerformed(ActionEvent ae)
    {
        //jt.setText("Hello");
        String s = ae.getActionCommand();
        System.out.println(s);
        if(s.equals("Create"))
        {
            Pg3 cr = new Pg3();
        }
        else if(s.equals("alter"))
        {
            Pg4 al = new Pg4(); 
        }
        else if(s.equals("drop"))
        {
            Pg5 dr = new Pg5();
        }
        else if(s.equals("insert"))
        {
            Pg6 in = new Pg6(); 
        }
        else if(s.equals("update"))
        {
            Pg7 up = new Pg7(); 
        }
        else if(s.equals("delete"))
        {
            Pg8 al = new Pg8(); 
        }
        else if(s.equals("select"))
        {
            Pg9 al = new Pg9(); 
        }
        }
}
