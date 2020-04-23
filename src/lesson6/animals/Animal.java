package lesson6.animals;

public abstract class Animal {

    protected int MIN_RUN_DISTANCE;
    protected int MIN_SWIMM_DISTANCE;
    protected String name;
    protected static int count = 0;

    public  abstract void run(int distance);

    public int getAnimalCount(){
        return count;
    }

}
