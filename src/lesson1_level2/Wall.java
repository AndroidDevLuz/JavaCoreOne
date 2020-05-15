package lesson1_level2;

import lesson1_level2.members.Cat;
import lesson1_level2.members.Human;
import lesson1_level2.members.Opportunity;
import lesson1_level2.members.Robot;

public class Wall implements Hurdles {

    private static int HEIGHT  = (int)((Math.random()+0.4)*2);

    public boolean testMoving(Opportunity opportunity){
        if(opportunity instanceof Cat){
            return ((Cat)opportunity).jump(HEIGHT);
        } else if(opportunity instanceof Human){
            return ((Human)opportunity).jump(HEIGHT);
        } else {
            return ((Robot)opportunity).jump(HEIGHT);
        }
    }
}
