/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

import java.util.HashMap;
import java.util.Map;
import smartlab.objects.devices.Device;

/**
 *
 * @author ipc
 */
public class Port extends Component {

    private Switch switchObj;
    private Device device;
    private static Map<String, Port> mapPort = new HashMap<String, Port>();

    private Port(String id) {
        super(id);
    }

    public void corSwitch(Switch sw) {
        switchObj = sw;
    }

    public void corDevice(Device d) {
        device = d;
    }

    public void changeState(boolean state) {
        switchObj.setState(state);        
    }

    public static Port get(String s) {
        if (mapPort.containsKey(s)) {
            return mapPort.get(s);
        } else {
            Port p = new Port(s);
            mapPort.put(s, p);
            return p;
        }
    }
}