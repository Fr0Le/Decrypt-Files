package ru.fr0le.hellz.items.armor;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.fr0le.hellz.Info;
import ru.fr0le.hellz.client.render.armor.RenderItemArmor;
import ru.fr0le.hellz.creativetabs.LoadTab;

public class ItemHellZArmor {

	public static class Helmet extends ItemArmor {
		public Helmet(ArmorMaterial armorMaterial, int par3, int par4, String name) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(LoadTab.tabArmor);
			this.setUnlocalizedName(name);
			this.setTextureName(Info.modid + ":null");
			GameRegistry.registerItem(this, this.getUnlocalizedName());
			if(FMLCommonHandler.instance().getEffectiveSide().isClient()) MinecraftForgeClient.registerItemRenderer(this, new RenderItemArmor.renderItemHelmet());
		}

		@SideOnly(Side.CLIENT)
		@Override
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return Info.modid + ":textures/items/null.png";
		}
	}	

}