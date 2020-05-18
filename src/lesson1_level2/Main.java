package lesson1_level2;

import lesson1_level2.members.Cat;
import lesson1_level2.members.Human;
import lesson1_level2.members.Opportunity;
import lesson1_level2.members.Robot;

public class Main extends  Thread {

    public static void main(String[] args) {

        Opportunity [] members = new Opportunity[]{
                new Cat(),
                new Human(),
                new Robot() };

        Hurdles [] hurdles = new Hurdles[]{
                new RunningMachine(),
                new Wall(),
                new Wall(),
                new RunningMachine()
        };

        for (Opportunity member : members) {
            for (Hurdles hurdle : hurdles) {
                if(!getResultOfMoving(hurdle, member)) break;
            }
        }



    }

    private static boolean getResultOfMoving(Hurdles hurdle, Opportunity member) {
        if(hurdle instanceof RunningMachine){
            return ((RunningMachine)hurdle).testMoving(member);
        } else {
            return ((Wall)hurdle).testMoving(member);
        }
    }

}
