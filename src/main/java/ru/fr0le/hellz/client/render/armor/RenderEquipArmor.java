package ru.fr0le.hellz.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import ru.fr0le.hellz.Info;
import ru.fr0le.hellz.client.ClientProxy;

public class RenderEquipArmor {

	private static ResourceLocation texture = new ResourceLocation(Info.modid, "textures/models/items/balaclava.png");

	public static void renderHelmet(RenderPlayer renderModel) {		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedHead.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(1.0f, 1.0f, 1.0f);
		GL11.glTranslatef(0f, -1.5f, 0f);
		GL11.glCallList(ClientProxy.getRenderAll("armor", "balaclava"));
		GL11.glPopMatrix();
	}

}