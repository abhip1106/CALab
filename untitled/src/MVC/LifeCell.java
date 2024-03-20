package MVC;

import java.awt.*;

public class LifeCell extends Cell{
    public LifeCell(){
        //System.out.println("LifeCell made");
    }

    @Override
    public void observe() {
        neighborsAlive = 0;
        for(Cell x: neighbors){
            if(x.getStatus() == 1){
                neighborsAlive++;
            }
        }
    }

    @Override
    public void interact() {
        if(neighborsAlive == 3 || neighborsAlive == 4  || neighborsAlive == 1){
            this.status = 1;
            return;
        }
        if(neighborsAlive == 2){
            return;
        }
        this.status = 0;
    }

    @Override
    public void update() {

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
