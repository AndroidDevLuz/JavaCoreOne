package lesson1_level2.members;

public class Human  implements Opportunity {


    private  int RUN_LIMMIT = (int)((Math.random()+0.4)*2);
    private  int JUMP_LIMMIT = (int)((Math.random()+0.4)*2);

    @Override
    public boolean run(int length) {
        if(RUN_LIMMIT < length){
            System.out.println("Человек не может пробежать такую дистанцию");
            return false;
        } else{
            System.out.println("Человек пробежал "+length+" км");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(JUMP_LIMMIT < height){
            System.out.println("Человек не может перелезть через стену в "+height+" метров");
            return false;
        } else{
            System.out.println("Человек перелез через стену в "+height+" м");
            return true;
        }
    }
}
