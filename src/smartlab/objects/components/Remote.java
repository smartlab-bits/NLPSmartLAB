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
public class Remote extends Component {

    private boolean state;
    private int mode, channel, volume, brightness, contrast;
    private static Map<String, Remote> mapRem = new HashMap<String, Remote>();

    private Remote(String id) {
        super(id);
    }

    public void setInitial(boolean s, int m, int chan, int v, int b, int con) {
        state = s;
        mode = m;
        channel = chan;
        volume = v;
        brightness = b;
        contrast = con;
    }

    public boolean onOff(String s) {
        if (s.equalsIgnoreCase("ON")) {
            state = true;
        } else if (s.equalsIgnoreCase("OFF")) {
            state = false;
        }

        return state;
    }

    public int changeMode(String s) {
        if (s.equalsIgnoreCase("TV")) {
            mode = 1;
        } else if (s.equalsIgnoreCase("AV1")) {
            mode = 2;
        } else if (s.equalsIgnoreCase("AV2")) {
            mode = 3;
        }
        return mode;
    }

    public int changeChannel(int newChan) {
        channel = newChan;
        return channel;
    }

    public int increaseVolume(int amount) {
        volume += amount;
        return volume;
    }

    public int decreaseVoulume(int amount) {
        volume -= amount;
        return volume;
    }

    public int increaseBrightness(int amount) {
        brightness += amount;
        return brightness;
    }

    public int decreaseBrightness(int amount) {
        brightness -= amount;
        return brightness;
    }

    public int increaseContrast(int amount) {
        contrast += amount;
        return contrast;
    }

    public int decreaseContrast(int amount) {
        contrast -= amount;
        return contrast;
    }

    public boolean getState() {
        return state;
    }

    public int getMode() {
        return mode;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getContrast() {
        return contrast;
    }

    public static Remote get(String s) {
        if (mapRem.containsKey(s)) {
            return mapRem.get(s);
        } else {
            Remote rem = new Remote(s);
            mapRem.put(s, rem);
            return rem;
        }
    }
}
