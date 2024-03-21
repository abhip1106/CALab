package MVC;

import java.awt.*;

public class LifeCell extends Cell{

    public LifeCell(Grid mygrid){
        this.myGrid = mygrid;
        //System.out.println("LifeCell made");
    }
    public int countNeighbors(){
        int count = 0;
        for(Cell x: neighbors){
            if(x.getStatus() == 1){
                count++;
            }
        }
        return count;
    }

    @Override
    public void observe() {
        neighborsAlive = countNeighbors();
    }

    @Override
    public void interact() {


    }

    @Override
    public void update() {
        if(neighborsAlive == 3){
            this.status = 1;
        }else if(neighborsAlive == 2){
            return;
        }else{
            this.status = 0;
        }
    }

    @Override
    public void nextState() {
        if(status == 0){
            status++;
            color = Color.GREEN;
        }else{
            status--;
            color = Color.RED;
        }
        this.update();
    }

    @Override
    public void reset(boolean randomly) {
        this.status = 0;
    }
}
