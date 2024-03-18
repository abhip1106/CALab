package MVC;

import javax.swing.*;

import MVC.tools.*;
import MVC.tools.View;

import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col);
        cellViews[row][col] = cell;
        */
        //set cell.row and cell.col here

    }

    public void update() {
        // call update method of each CellView
        for(int i = 0; i < cellViews.length; i++){
            for(int j = 0; j < cellViews[i].length; i++){
                cellViews[i][j].update();
            }
        }
    }

}

