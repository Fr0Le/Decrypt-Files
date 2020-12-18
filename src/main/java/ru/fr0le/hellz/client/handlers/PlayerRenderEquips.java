package ru.fr0le.hellz.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import ru.fr0le.hellz.client.render.armor.RenderEquipArmor;

public class PlayerRenderEquips {

	private EntityPlayer player;

	@SubscribeEvent
	public void onPlayerRenderTick(RenderPlayerEvent.Specials.Post event) {
		if(event.entityPlayer == null) return;

		player = (EntityPlayer)event.entityLiving;
		if(player.getCurrentArmor(3) != null) RenderEquipArmor.renderHelmet(event.renderer);
	}

}