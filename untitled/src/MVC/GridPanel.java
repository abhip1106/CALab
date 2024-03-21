//package CALab;
//
//import javax.swing.*;
//import java.awt.*;
//import mvc.*;
//
//
//public class GridPanel extends AppPanel {
//    private JButton clear;
//    private JButton run1;
//    private JButton run50;
//    private JButton populate;
//
//    public GridPanel(AppFactory factory) {
//        super(factory);
//        JPanel control = new JPanel();
//        control.setLayout(new GridLayout(3, 1));
//
//        //Run1 Button
//        JButton run1 = new JButton("Run1");
//        run1.addActionListener(this);
//        control.add(run1);
//
//        //Run50 Button
//        JButton run50 = new JButton("Run50");
//        run50.addActionListener(this);
//        control.add(run50);
//
//        //Populate Button
//        JButton populate = new JButton("Populate");
//        populate.addActionListener(this);
//        control.add(populate);
//
//        //Clear Button
//        JButton clear = new JButton("Clear");
//        clear.addActionListener(this);
//        control.add(clear);
//    }
//
//    public static void main(String[] args) {
//        AppFactory factory = new GridFactory();
//        AppPanel panel = new GridPanel(factory);
//        panel.display();
//    }
//
//}
