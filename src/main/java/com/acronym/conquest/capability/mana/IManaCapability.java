package com.acronym.conquest.capability.mana;

public interface IManaCapability {

	public float getMana();

	public void addMana(float mana);

	public void consumeMana(float mana);

	public void setMana(float mana);

	public float getMaxMana();
	
	public void resetMana();

	public void copy(IManaCapability cap);
}
