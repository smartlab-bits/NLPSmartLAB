/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.devices;

/**
 *
 * @author ipc
 */
public class Device {

    private boolean state;
    private String deviceID;

    public Device(String id) {
        deviceID = id;
    }

    public void setState(boolean init_state) {
        state = init_state;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public boolean getState() {
        return state;
    }
}
