package lesson6.animals;

public final class Cat extends Animal {

    public Cat(String name){
        super();
        this.name = name;
        this.MIN_RUN_DISTANCE = 200;
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

}
