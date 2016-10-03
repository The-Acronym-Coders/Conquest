package com.acronym.conquest;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.acronym.conquest.capability.mana.IManaCapability;
import com.acronym.conquest.capability.mana.ManaCapability;
import com.acronym.conquest.capability.mana.ManaCapabilityStorage;
import com.acronym.conquest.handler.ConquestEventHandler;

import static com.acronym.conquest.reference.Reference.*;

@Mod(modid = MODID, name = NAME, version = BUILD_VERSION)
public class Conquest {

	@Instance(MODID)
	public static Conquest INSTANCE;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){

		MinecraftForge.EVENT_BUS.register(new ConquestEventHandler());

		CapabilityManager.INSTANCE.register(IManaCapability.class, ManaCapabilityStorage.instance, ManaCapability.class);
	}

	@EventHandler
	public void init(FMLInitializationEvent event){

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

	}
}
