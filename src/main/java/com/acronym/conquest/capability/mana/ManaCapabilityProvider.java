package com.acronym.conquest.capability.mana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class ManaCapabilityProvider implements ICapabilityProvider, INBTSerializable<NBTBase> {

	@CapabilityInject(IManaCapability.class)
	public static final Capability<IManaCapability> MANA_CAP = null;

	private IManaCapability capability;

	public ManaCapabilityProvider(){
		capability = new ManaCapability();
	}

	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		return capability == MANA_CAP;
	}

	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

		if(capability == MANA_CAP){

			return (T) this.capability;
		}

		return null;
	}

	public NBTBase serializeNBT() {
		return ManaCapabilityStorage.instance.writeNBT(MANA_CAP, capability, null);
	}

	public void deserializeNBT(NBTBase nbt) {
		ManaCapabilityStorage.instance.readNBT(MANA_CAP, capability, null, nbt);
	}
}