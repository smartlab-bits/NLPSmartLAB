/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ipc
 */
public class Regulator extends Component {

    private int speed;
    private static Map<String, Regulator> mapReg = new HashMap<String, Regulator>();

    private Regulator(String id) {
        super(id);
    }

    public void setSpeed(int init_speed) {
        speed = init_speed;
    }

    public int increase(int amount) {
        if (speed + amount <= 5) {
            speed += amount;
        }
        return speed;
    }

    public int decrease(int amount) {
        if (speed - amount >= 0) {
            speed -= amount;
        }
        return speed;
    }

    public int getSpeed() {
        return speed;
    }

    public static Regulator get(String s) {
        if (mapReg.containsKey(s)) {
            return mapReg.get(s);
        } else {
            Regulator reg = new Regulator(s);
            mapReg.put(s, reg);
            return reg;
        }
    }
}
