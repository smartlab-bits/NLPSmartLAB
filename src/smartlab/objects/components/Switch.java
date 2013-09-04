/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

/**
 *
 * @author ipc
 */
public class Switch {
    private boolean state;
	private String switchID;
	public Switch(String id, boolean init_state)
	{
		switchID = id;
		state = init_state; 
	}
	boolean onOff(String s)
	{
		if(s.equalsIgnoreCase("ON"))
			{
				state = true;
			}
		else if(s.equalsIgnoreCase("OFF"))
		{
			state = false;
		}
		
		return state;
	}
        String getSwitchID()
        {
            return switchID;
        }
        boolean getState()
        {
            return state;
        }
}
