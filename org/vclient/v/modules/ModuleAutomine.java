package org.vclient.v.modules;

import org.vclient.v.Command;
import org.vclient.v.Vapid;

import net.minecraft.client.Minecraft;

public class ModuleAutomine extends ModuleBase 
{
	
	public ModuleAutomine(Vapid vapid, Minecraft mc) 
	{
		super(vapid, mc);
		// TODO Auto-generated constructor stub
					
		this.needsTick = true;
		this.aliases.add("mine");
		this.name = "AutoMine";
		this.command = new Command(this.vapid, this, aliases, "You mine");

	}

    
	@Override
	public void onDisable()
	{
		this.isEnabled = false;
		mc.gameSettings.keyBindAttack.pressed = false;

	}
	
	@Override
	public void onTick()
	{
		if(this.isEnabled && mc.leftClickCounter == 0) {
			mc.gameSettings.keyBindAttack.pressed = true;

		}
		
	}

}