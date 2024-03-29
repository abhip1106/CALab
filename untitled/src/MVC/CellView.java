
package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import MVC.tools.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) {
            c.subscribe(this);
        }
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.addActionListener(this);
    }

    public CellView() {
        this(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState(); // changes the state of myCell
//        for(Cell x: myCell.neighbors) {
//            x.observe();
//        }
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.neighborsAlive);
    }

    // called by notifySubscribers and GridView.update
    @Override
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.neighborsAlive);
    }

}




