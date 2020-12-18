package ru.fr0le.hellz.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import ru.fr0le.hellz.Info;
import ru.fr0le.hellz.client.ClientProxy;

public class RenderItemArmor {	

	private static ResourceLocation texture = new ResourceLocation(Info.modid, "textures/models/items/balaclava.png");

	public static class renderItemHelmet implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack stack, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
			if(type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -3.3F,0F);
				GL11.glScalef(1.9F, 1.9F, 1.9F);
				GL11.glCallList(ClientProxy.getRenderAll("armor", "balaclava"));
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.5F, -2.2F, 0.5F);
				GL11.glScalef(1.5f, 1.5f, 1.5f);
				GL11.glCallList(ClientProxy.getRenderAll("armor", "balaclava"));
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -1.7F, 0F);
				GL11.glCallList(ClientProxy.getRenderAll("armor", "balaclava"));
				GL11.glPopMatrix();
			}
		}
	}

}