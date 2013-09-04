/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.objects.components;

/**
 *
 * @author ipc
 */
public class Regulator {
    private int speed;
    private String regID;
	public Regulator(String id, int init_speed)
	{
		regID = id;
                speed = init_speed;
	}
	
	int increase(int amount)
        {
            if(speed+amount<=5)
            {
                speed += amount;
            }
            return speed;
        }
        
        int decrease(int amount)
        {
            if(speed-amount>=0)
            {
                speed -= amount;
            }
            return speed;
        }
        
        int getSpeed()
        {
            return speed;
        }
        
        String getRegulatorID()
        {
            return regID;
        }

}
