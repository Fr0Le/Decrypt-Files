package ru.fr0le.hellz.client.loader;

import java.io.File;

import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;

public interface IModelCustomLoader {

	String getType();

	String[] getSuffixes();

	IModelCustom loadInstance(File file) throws ModelFormatException;

}