package lesson1_level2;

import lesson1_level2.members.Cat;
import lesson1_level2.members.Human;
import lesson1_level2.members.Opportunity;
import lesson1_level2.members.Robot;

public class Wall implements Hurdles {

    private static int HEIGHT  = (int)((Math.random()+0.4)*2);

    @Override
    public boolean testMoving(Opportunity opportunity) {
        return opportunity.jump(HEIGHT);
    }
}
