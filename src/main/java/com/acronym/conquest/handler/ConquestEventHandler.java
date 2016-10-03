package com.acronym.conquest.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.acronym.conquest.capability.mana.ManaCapabilityProvider;
import com.acronym.conquest.reference.Reference;

public class ConquestEventHandler {

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject() instanceof EntityPlayer)
			event.addCapability(new ResourceLocation(Reference.MODID, "mana"), new ManaCapabilityProvider());
	}
}
