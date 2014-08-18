package me.pyr0byte.vapid.modules;

import me.pyr0byte.vapid.Command;
import me.pyr0byte.vapid.Vapid;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.PotionEffect;

public class ModuleNightVision extends ModuleBase 
{
	public ModuleNightVision(Vapid vapid, Minecraft mc) 
	{
		super(vapid, mc);
		// TODO Auto-generated constructor stub
		
		this.needsTick = true;
		aliases.add("nv");
		aliases.add("NightVision");
		
		this.command = new Command(this.vapid, this, aliases, "(Alternative to Brightness) Activate NightVision potion effect.");
		this.command.registerArg("int", new Class[] { Float.class }, "how bright");
		this.defaultArg = "int";
	}
	
	@Override
	public void onTick()
	{
		if(this.isEnabled)
		{
			PotionEffect nightVision = new PotionEffect(16, 999999999, 0);
			nightVision.setPotionDurationMax(true);
			mc.thePlayer.addPotionEffect(nightVision);
		}
	}
	
	@Override
	public void onEnable()
	{
		this.isEnabled = true;
	}
	
	@Override
	public void onDisable()
	{
		this.isEnabled = false;
		try {
			mc.thePlayer.removePotionEffect(16);
		}catch(Exception err) {}
	}
}