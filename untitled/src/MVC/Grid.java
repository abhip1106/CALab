package MVC;



import java.awt.*;
import java.util.*;
import java.io.*;
import MVC.tools.*;


public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;
    public abstract Cell makeCell(boolean uniform);

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j] = makeCell(false);
                cells[i][j].row = i;
                cells[i][j].col = j;
            }
        }

        // 2. use getNeighbors to set the neighbors field of each cell
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].neighbors = getNeighbors(cells[i][j],1);
            }
        }
    }

    // called when Populate and clear buttons are clicked
    public void repopulate(boolean randomly) {
        if (randomly) {
            for(int i = 0; i < dim; i++){
                for(int j = 0; j < dim; j++){
                    cells[i][j].status = (Math.random() < 0.5) ? 0 : 1;;

                }
            }
        } else {
            for(int i = 0; i < dim; i++){
                for(int j = 0; j < dim; j++){
                    cells[i][j].status = 0;
                }
            }
        }
        // notify subscribers

    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        Set<Cell> neighbors = new HashSet<>();
        // Iterate over rows and columns around the asker cell
        for (int dr = -radius; dr <= radius; dr++) {
            for (int dc = -radius; dc <= radius; dc++) {
                int newRow = asker.row + dr;
                int newCol = asker.col + dc;

                // Skip if the new cell is the asker itself
                if (dr ==0  && dc == 0)
                    continue;
                // Check if the new cell is within the bounds of the grid
                if (newRow  <= 0){
                    newRow += dim;
                }
                if(newCol <= 0) {
                    newCol += dim;
                }
                neighbors.add(cells[newRow % dim][newCol % dim]);
            }
        }
        return neighbors;
    }
    // cell phases:
    public void observe() {
        // call each cell's observe method and notify subscribers
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                this.getCell(i,j).observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                this.getCell(row,col).interact();
            }
        }
        notifySubscribers();
    }
    public void clear(){
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                this.getCell(row,col).status = 0;
            }
        }
        update();
    }
    public void update() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell currCell = this.getCell(row,col);
                currCell.update();
            }
        }
        //notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}