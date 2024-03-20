package MVC;

import javax.swing.*;

import MVC.tools.*;
import MVC.tools.View;

import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];
    private JPanel gridPanel;
    public GridView(Model model) {
        super(model);
        gridPanel = new JPanel(new GridLayout(20, 20));
        cellViews = new CellView[20][20];
        for(int i = 0; i < cellViews.length; i++){
            for(int j = 0; j < cellViews[i].length; j++){
                CellView cell = new CellView(((Grid)model).getCell(i, j));
                cellViews[i][j] = cell;
                gridPanel.add(cell);
            }
        }

        //set cell.row and cell.col here

    }
    public JPanel getGridPanel(){
        return gridPanel;
    }
    public void update() {
        // call update method of each CellView
        for(int i = 0; i < cellViews.length; i++){
            for(int j = 0; j < cellViews[i].length; j++){
                cellViews[i][j].update();
            }
        }
    }

}

