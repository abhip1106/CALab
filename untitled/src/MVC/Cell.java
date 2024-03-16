package MVC;

import java.awt.*;
import java.io.Serializable;
import MVC.tools.Publisher;

public abstract class Cell extends MVC.tools.Publisher implements Serializable {
    private int row;
    private Color color;
    private int column;
    abstract void observe();
    abstract void interact();
    abstract void update();
    abstract void  reset();
    abstract int getStatus();
    abstract void nextState();

    public Color getColor(){
        return this.color;
    }
}
