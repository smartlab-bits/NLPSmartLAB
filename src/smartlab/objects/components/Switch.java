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
public class Switch extends Component {

    private boolean state;
    private static Map<String, Switch> mapSwitch = new HashMap<String, Switch>();

    private Switch(String id) {
        super(id);
    }

    public void setState(boolean init_state) {
        state = init_state;
    }

    public boolean onOff(String s) {
        if (s.equalsIgnoreCase("ON")) {
            state = true;
        } else if (s.equalsIgnoreCase("OFF")) {
            state = false;
        }

        return state;
    }

    public boolean getState() {
        return state;
    }

    public static Switch get(String s) {
        if (mapSwitch.containsKey(s)) {
            return mapSwitch.get(s);
        } else {
            Switch sw = new Switch(s);
            mapSwitch.put(s, sw);
            return sw;
        }
    }
}
