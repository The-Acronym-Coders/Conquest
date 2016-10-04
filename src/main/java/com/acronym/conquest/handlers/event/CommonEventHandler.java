package com.acronym.conquest.handlers.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.acronym.conquest.api.mana.capability.ManaCapabilityProvider;
import com.acronym.conquest.reference.Reference;

public class CommonEventHandler {

    public CommonEventHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer)
            event.addCapability(new ResourceLocation(Reference.MODID, "mana"), new ManaCapabilityProvider());
    }
}
