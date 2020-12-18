package ru.fr0le.hellz.client.loader;

import java.io.File;

import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;
import ru.fr0le.hellz.Info;

public class ObjModelLoader implements IModelCustomLoader {

	@Override
	public String getType() {
		return "OBJ model";
	}

	private static final String[] types = {Info.modelsFormat};

	@Override
	public String[] getSuffixes() {
		return types;
	}

	@Override
	public IModelCustom loadInstance(File file) throws ModelFormatException {
		return new WavefrontObject(file);
	}

}