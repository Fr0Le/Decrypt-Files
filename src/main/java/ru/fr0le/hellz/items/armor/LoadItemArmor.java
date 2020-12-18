package ru.fr0le.hellz.items.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LoadItemArmor {

	public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("ARMOR", 100, new int[] {0, 0, 0, 0}, 0);

	public static Item balaclava;

	public static void registerItems() {
		balaclava = new ItemHellZArmor.Helmet(LoadItemArmor.ARMOR, 0, 0, "balaclava");
	}

}