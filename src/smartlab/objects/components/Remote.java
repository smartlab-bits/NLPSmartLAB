/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

/**
 *
 * @author ipc
 */
public class Remote {
    private boolean state;
    private int mode, channel, volume, brightness, contrast;
    private String remID;
    
    public Remote(String id, boolean s, int m, int chan, int v, int b, int con)
    {
        state = s;
        mode = m;
        channel = chan;
        volume = v;
        brightness = b;
        contrast = con;
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
    
    int changeMode(String s)
    {
        if(s.equalsIgnoreCase("TV"))
                {
                    mode = 1;
                }
        else if(s.equalsIgnoreCase("AV1"))
        {
            mode = 2;
                }
        else if(s.equalsIgnoreCase("AV2"))
        {
            mode = 3;
        }
        return mode;
    }
    int changeChannel(int newChan)
    {
        channel = newChan;
        return channel;
    }
    int increaseVolume(int amount)
    {
        volume += amount;
        return volume;
    }
    int decreaseVoulume(int amount)
    {
        volume-=amount;
        return volume;
    }
    int increaseBrightness(int amount)
    {
        brightness += amount;
        return brightness;
    }
    int decreaseBrightness(int amount)
    {
        brightness-=amount;
        return brightness;
    }int increaseContrast(int amount)
    {
        contrast += amount;
        return contrast;
    }
    int decreaseContrast(int amount)
    {
        contrast-=amount;
        return contrast;
    }
    String getRemoteID()
    {
        return remID;
    }
    boolean getState()
    {
        return state;
    }
    int getMode()
    {
        return mode;
    }
    int getChannel()
    {
        return channel;
    }
    int getVolume()
    {
        return volume;
    }
    int getBrightness()
    {
        return brightness;
    }
    int getContrast()
    {
        return contrast;
    }
}
