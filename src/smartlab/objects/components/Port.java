/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

/**
 *
 * @author ipc
 */
public class Port {
    private String portID;
    private Switch switchObj;
    //private Device device;
    public Port(String id, String switchid, String deviceid)
    {
        portID = id;
        switchObj = new Switch(switchid, true);
      //  device = new Device(deviceid);
    }
    
    public void changeState()
    {
        
    }
    
    public String getPortID()
    {
        return portID;
    }
}
