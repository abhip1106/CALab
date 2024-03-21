package MVC;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;
import java.util.*;
import java.io.*;
import MVC.tools.*;

abstract class Cell extends Publisher implements Serializable {

    // observer neighbors' states
    public abstract void observe();

    // interact with a random neighbor
    public abstract void interact();

    // update my state
    public abstract void update();

    // set status to status + 1 mod whatever
    public abstract void nextState();

    // set status to a random or initial value
    public abstract void reset(boolean randomly);

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected int neighborsAlive;
    protected Grid myGrid = null;
    protected Cell partner = null;
    protected int status;
    protected Color color;
    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
            int n = neighbors.size();
            Cell[] arr = new Cell[n];

            int i = 0;
            for (Cell x : arr) {
                arr[i++] = x;
            }
            Random random = new Random();
            int randPos = random.nextInt(n) ;

            for(i = 0; i < n; i++){
                if(arr[(i + randPos) % n].partner == null){
                    this.partner = arr[(i + randPos) % n];
                    arr[(i + randPos) % n].partner = this;
                    break;
                }
            }
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }



    public int getStatus() {
        return this.status;
    }

    public Color getColor() {
        if(status == 0){
            return Color.red;
        }
        return Color.green;
    }
}

