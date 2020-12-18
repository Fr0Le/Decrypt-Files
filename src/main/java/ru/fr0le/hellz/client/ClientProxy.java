package ru.fr0le.hellz.client;

import java.io.File;
import java.util.HashMap;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraftforge.common.MinecraftForge;
import ru.fr0le.hellz.Info;
import ru.fr0le.hellz.client.handlers.PlayerRenderEquips;
import ru.fr0le.hellz.client.loader.AdvancedModelLoader;
import ru.fr0le.hellz.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	private static final HashMap<String, Integer> hash = new HashMap<String, Integer>();

	@Override
	public void preInit() {
		super.preInit();  
		Display.setTitle(Info.name);
		createClientDir();
	}

	@Override
	public void Init() {
		super.Init();
		loadModels();
		MinecraftForge.EVENT_BUS.register(new PlayerRenderEquips());
	}

	@Override
	public void postInit() {
		super.postInit(); 
	}

	public void createClientDir() {
		if(FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			//temp dir for decrypt
			File file = new File(Info.modDir + "/temp");
			if(!file.isDirectory()) {				
				file.mkdirs();				
			}			
		}		
	}

	public void loadModels() {	
		GL11.glCallList(ClientProxy.getRenderAll("armor", "balaclava"));
	}

	public static int getRenderAll(String dir, String model) {
		if(hash.containsKey(model)) 
			return hash.get(model);

		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new File(Info.modDir + "/models/" + dir + "/" + model + "." + Info.modelsFormat)).renderAll();
		GL11.glEndList();
		hash.put(model, displayList);
		return displayList;
	}

}