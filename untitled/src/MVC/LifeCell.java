package MVC;

public class LifeCell extends Cell{
    public LifeCell(){

    }
    private int neighborsAlive;
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

    }

    @Override
    public void update() {

    }

    @Override
    public void nextState() {

    }

    @Override
    public void reset(boolean randomly) {

    }
}
