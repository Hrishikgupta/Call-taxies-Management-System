package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Book_Cab extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton bt1, bt2;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    Font f, f1;
    Choice ch1, ch2, ch3;

    Book_Cab() {
        super("Book Intracity Cab");
        setLocation(50, 10);
        setSize(1100, 700);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);

        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select source from intracity_driver";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch1.add(rest.getString("source"));
            }
            rest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ConnectionClass obj = new ConnectionClass();
            String q1 = "select username from customer";
            ResultSet rest1 = obj.stm.executeQuery(q1);
            while (rest1.next()) {
                ch3.add(rest1.getString("username"));
            }
            rest1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        l1 = new JLabel("Book Intracity Cab");
        l1.setFont(f);
        l2 = new JLabel("Book Id");
        l2.setFont(f1);
        l3 = new JLabel("source");
        l3.setFont(f1);
        l4 = new JLabel("Destination");
        l4.setFont(f1);
        l5 = new JLabel("username");
        l5.setFont(f1);
        l6 = new JLabel("Name");
        l6.setFont(f1);
        l7 = new JLabel("DriverName");
        l7.setFont(f1);
        l8 = new JLabel("Car");
        l8.setFont(f1);
        l9 = new JLabel("Destination from");
        l9.setFont(f1);
        l10 = new JLabel("Destinantion to");
        l10.setFont(f1);
        l11 = new JLabel("Price");
        l11.setFont(f1);

        l1.setHorizontalAlignment(JLabel.CENTER);
        tf1 = new JTextField();
        tf1.setFont(f1);
        tf2 = new JTextField();
        tf2.setFont(f1);
        tf3 = new JTextField();
        tf3.setFont(f1);
        tf4 = new JTextField();
        tf4.setFont(f1);
        tf5 = new JTextField();
        tf5.setFont(f1);
        tf6 = new JTextField();
        tf6.setFont(f1);
        tf7 = new JTextField();
        tf7.setFont(f1);
        tf8 = new JTextField();
        tf8.setFont(f1);

        tf1.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);

        bt1 = new JButton("Book Cab");
        bt2 = new JButton("Back");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        bt1.setBackground(Color.YELLOW);
        bt2.setBackground(Color.RED);
        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.WHITE);

        Random rm = new Random();
        tf1.setText("" + Math.abs(rm.nextInt() % 100000));
        tf1.setForeground(Color.RED);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch2);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(tf3);
        p2.add(l7);
        p2.add(tf4);
        p2.add(l8);
        p2.add(tf5);
        p2.add(l9);
        p2.add(tf6);
        p2.add(l10);
        p2.add(tf7);
        p2.add(l11);
        p2.add(tf8);
        p2.add(bt1);
        p2.add(bt2);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/Carosoul img-3.jpg"));
        Image img = ic.getImage().getScaledInstance(680, 500, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l12 = new JLabel(ic1);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l12);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String username = ch3.getSelectedItem();
                    String query = "SELECT name FROM customer WHERE username ='"+username+"'";
                    ResultSet rest2 = obj.stm.executeQuery(query);
                    while (rest2.next()) {
                        tf3.setText(rest2.getString("name"));
                    }
                    rest2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        ch1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ch2.removeAll();
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String source = ch1.getSelectedItem();
                    String query = "SELECT destination FROM intracity_driver WHERE source='"+source+"'";
                    ResultSet rest2 = obj.stm.executeQuery(query);
                    while (rest2.next()) {
                        ch2.add(rest2.getString("destination"));
                    }
                    rest2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        ch2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String source = ch1.getSelectedItem();
                    String destination= ch2.getSelectedItem();
                    String query1 = "SELECT * FROM intracity_driver WHERE source ='"+source+"' and destination='"+destination+"'";
                    ResultSet rest1 = obj.stm.executeQuery(query1);
                    while (rest1.next()) {
                        tf4.setText(rest1.getString("driver"));
                        tf5.setText(rest1.getString("car"));
                        tf6.setText(rest1.getString("source"));
                        tf7.setText(rest1.getString("destination"));
                        tf8.setText(rest1.getString("price"));
                    }
                    rest1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            String bid = tf1.getText();
            String username = ch3.getSelectedItem();
            String dname = tf4.getText();
            String car = tf5.getText();
            String source = tf6.getText();
            String destination = tf7.getText();
            String price = tf8.getText();
            try{
                ConnectionClass obj3 = new ConnectionClass();
                String q2 = "insert into intracitycab values('"+bid+"','"+username+"','"+dname+"','"+car+"','"+source+"','"+destination+"','"+price+"')";
                int aa = obj3.stm.executeUpdate(q2);
                if(aa==1){
                    JOptionPane.showMessageDialog(null,"Cab Booked successfully!");
                    this.setVisible(false);
                    new Update_Customer();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all details carefully !");
                }
            }
            catch(Exception exx){
                exx.printStackTrace();
            }
        }
        if(e.getSource()==bt2){
            this.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new Book_Cab().setVisible(true);
    }
}
