package com.acronym.conquest.capability.mana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ManaCapabilityStorage implements IStorage<IManaCapability> {

	public static IStorage<IManaCapability> instance = new ManaCapabilityStorage();

	public NBTBase writeNBT(Capability<IManaCapability> capability, IManaCapability instance, EnumFacing side) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setFloat("Mana", instance.getMana());
		
        return properties;
	}

	public void readNBT(Capability<IManaCapability> capability, IManaCapability instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound properties = (NBTTagCompound)nbt;

		instance.setMana(properties.getFloat("Mana"));
	}
}