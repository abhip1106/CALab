package MVC;

public abstract class Grid {
    static int time = 0;
    private int dim;

    abstract Cell makeCell();

    public void observe(){

    }
    public void interact(){

    }
    public void update(){

    }
    public void updateLoop(int cycles){
        for(int i = 0; i < cycles; i++){
            observe();
            interact();
            update();
        }
    }
    public void repopulate(Boolean random){

    }
}
