package ru.fr0le.hellz.client.loader;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;

@SideOnly(Side.CLIENT)
public class AdvancedModelLoader {

	private static Map<String, IModelCustomLoader> instances = Maps.newHashMap();

	public static void registerModelHandler(IModelCustomLoader modelHandler) {
		for(String suffix : modelHandler.getSuffixes()) {
			instances.put(suffix, modelHandler);
		}
	}

	public static IModelCustom loadModel(File file) throws IllegalArgumentException, ModelFormatException {
		String name = file.getPath();
		int i = name.lastIndexOf('.');

		if(i == -1) {
			FMLLog.severe("The resource name %s is not valid", file);
			throw new IllegalArgumentException("The resource name is not valid");
		}

		String suffix = name.substring(i + 1);
		IModelCustomLoader loader = instances.get(suffix);

		if(loader == null) {
			FMLLog.severe("The resource name %s is not supported", file);
			throw new IllegalArgumentException("The resource name is not supported");
		}

		return loader.loadInstance(file);
	}

	public static Collection<String> getSupportedSuffixes() {
		return instances.keySet();
	}

	static {
		registerModelHandler(new ObjModelLoader());
	}

}