package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{
    JLabel l1;
    Font f,f1,f2;
    JPanel p1,p2;
    HomePage(){
        super("Cab Booking HomePage");
        setLocation(0,0);
        setSize(1550,800);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/Carosoul img-3.jpg"));
        Image img = ic.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        f= new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1 =new Font("MS UI Gothic",Font.BOLD,18);
        
        JMenuBar m1=new JMenuBar();
        
        JMenu men1 = new JMenu("Customer Profile");
        JMenuItem ment1=new JMenuItem("Add Customer Profile");
        JMenuItem ment2=new JMenuItem("View Customer Profile");
        
        JMenu men2 = new JMenu("Manage Customer");
        JMenuItem ment3=new JMenuItem("Update Customer Profile");
        
        JMenu men3 = new JMenu("Book Intracity Cab");
        JMenuItem ment4=new JMenuItem("Book Cab");
        JMenuItem ment5=new JMenuItem("View Booked Cab");
        
        JMenu men4 = new JMenu("Book Intercity Cab");
        JMenuItem ment6=new JMenuItem("Book Intercity Cab");
        JMenuItem ment7=new JMenuItem("View Intercity Booked Cab");
        
        JMenu men5 = new JMenu("Transport");
        JMenuItem ment8=new JMenuItem("Book Package");
        JMenuItem ment9=new JMenuItem("View Booked Package");
        
        JMenu men6 = new JMenu("Bill");
        JMenuItem ment10=new JMenuItem("Check Bill");
        
        JMenu men7 = new JMenu("Delete");
        JMenuItem ment11=new JMenuItem("Delete Customer");
        
        JMenu men8 = new JMenu("About");
        JMenuItem ment12=new JMenuItem("About");
        JMenuItem ment13=new JMenuItem("Exit");
        
        men1.add(ment1);
        men1.add(ment2);
        
        men2.add(ment3);
        
        men3.add(ment4);
        men3.add(ment5);
        
        men4.add(ment6);
        men4.add(ment7);
        
        men5.add(ment8);
        men5.add(ment9);
        
        men6.add(ment10);
        
        men7.add(ment11);
        
        men8.add(ment12);
        men8.add(ment13);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        m1.add(men8);
        
        m1.setBackground(Color.BLACK);
        
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.GRAY);
        men7.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
        ment12.setBackground(Color.BLACK);
        ment13.setBackground(Color.BLACK);
        
        ment1.setForeground(Color.YELLOW);
        ment2.setForeground(Color.YELLOW);
        ment3.setForeground(Color.YELLOW);
        ment4.setForeground(Color.YELLOW);
        ment5.setForeground(Color.YELLOW);
        ment6.setForeground(Color.YELLOW);
        ment7.setForeground(Color.YELLOW);
        ment8.setForeground(Color.YELLOW);
        ment9.setForeground(Color.YELLOW);
        ment10.setForeground(Color.YELLOW);
        ment11.setForeground(Color.YELLOW);
        ment12.setForeground(Color.RED);
        ment13.setForeground(Color.RED);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        ment12.addActionListener(this);
        ment13.addActionListener(this);
        
        
        
        
        setJMenuBar(m1);
        add(l1);
        
    }
    public void actionPerformed(ActionEvent e){
        String comnd = e.getActionCommand();
        if(comnd.equals("Add Customer Profile")){
            new Add_Customer().setVisible(true);
        }
        else if(comnd.equals("View Customer Profile")){
            new View_Customer().setVisible(true);
        }
        else if(comnd.equals("Update Customer Profile")){
            new Update_Customer().setVisible(true);
        }
        else if(comnd.equals("Book Cab")){
            new Book_Cab().setVisible(true);
        }
        else if(comnd.equals("View Booked Cab")){
            new View_BookedCab().setVisible(true);
        }
        else if(comnd.equals("Book Intercity Cab")){
            new Book_Intercity_Cab().setVisible(true);
        }
        else if(comnd.equals("View Intercity Booked Cab")){
            new View_Intercity_Booked_Cab().setVisible(true);
        }
        else if(comnd.equals("Book Package")){
            new Book_Package().setVisible(true);
        }
        else if(comnd.equals("View Booked Package")){
            new View_Booked_Package().setVisible(true);
        }
        else if(comnd.equals("Check Bill")){
            new CheckBill().setVisible(true);
        }
        else if(comnd.equals("Delete Customer")){
            new Delete_Customer().setVisible(true);
        }
        else if(comnd.equals("About")){
            new About().setVisible(true);
        }
        else if(comnd.equals("Exit")){
                System.exit(0);
        }
    }
    public static void main(String args[]){
        new HomePage().setVisible(true);
    }
    
}
