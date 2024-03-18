package MVC;

import MVC.tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AppPanel extends JPanel implements Subscriber,ActionListener {
    private JPanel control;
    private Grid grid;
    public AppPanel() {
        // Create a frame (window)
        JFrame frame = new JFrame("CALab");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(this.createMenuBar());
        // Create buttons on the left-hand side
        JPanel control = new JPanel();
        control.setLayout(new GridLayout(3, 1));

        //Parser Button
        JButton run1 = new JButton("Run1");
        run1.addActionListener(this);
        control.add(run1);


        //Run Button
        JButton run50 = new JButton("Run50");
        control.add(run50);
        run50.addActionListener(this);

        //Clear Button
        JButton populate = new JButton("Populate");
        control.add(populate);
        populate.addActionListener(this);

        //Clear Button
        JButton clear = new JButton("Clear");
        control.add(clear);
        clear.addActionListener(this);

        //Choose a Grid
        grid  = new LifeGrid();
        grid.populate();
        // Create a panel for the right-hand side
        JPanel view = new GridView(grid);
        view.setLayout(new GridLayout(2, 1));


        add(view);


        // Create a split pane to divide left and right panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, control, view);
        splitPane.setResizeWeight(0.25); // Set the initial width of leftPanel

        // Add split pane to the frame
        frame.getContentPane().add(splitPane);

        // Make the frame visible
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Clear":

                    break;
                case "Run1":

                    break;
                case "Run50":

                    break;
                case "Populate":

                    break;
                case "Save": {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));

                    os.close();
                    break;
                }

                case "Open": {
                    String fName = Utilities.getFileName((String) null, true);
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                    is.close();
                    break;

                }

                case "New": {
                    new AppPanel();
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        System.exit(0);
                    }
                    break;
                }

                case "About": {
                    Utilities.inform("SJSU, 2024. All rights reserved.");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "CALab choose cells, then hit run",
                    };
                    Utilities.inform(cmmds);
                    break;

                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }


    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }

    @Override
    public void update() {

    }
    class CellView extends JPanel{

    }
}