package lesson6.animals;

public final class Dog extends Animal {

    public Dog(String name){
        super();
        this.name = name;
        this.MIN_RUN_DISTANCE = (int)((Math.random()+0.4)*500);
        this.MIN_SWIMM_DISTANCE = (int)((Math.random()+0.9)*10);
        count+=1;
    }

    @Override
    public void run(int distance) {
        if(distance < MIN_RUN_DISTANCE) {
            String outputMessage = String.format(name + " пробежал %d м", distance);
            System.out.println(outputMessage);
        } else {
            String outputMessage = String.format(name + " не пробежит  %d м - это слишком большая дистанция", distance);
            System.out.println(outputMessage);
        }
    }


    public void swimm(int distance) {
        if(distance < MIN_SWIMM_DISTANCE) {
            String outputMessage = String.format(name + " проплывёт %d м", distance);
            System.out.println(outputMessage);
        } else {
            String outputMessage = String.format(name + " не проплывёт  %d м - это слишком большая дистанция", distance);
            System.out.println(outputMessage);
        }
    }

}
