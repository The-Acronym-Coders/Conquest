package com.acronym.conquest.api.mana.capability;

public class ManaCapability implements IManaCapability {

    private float mana;

    public float getMana() {

        return mana;
    }

    public void addMana(float mana) {
        this.mana += mana;
        if (this.mana > getMaxMana()) this.mana = getMaxMana();
    }

    public void consumeMana(float mana) {
        this.mana -= mana;
        if (this.mana < 0) this.mana = 0;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public float getMaxMana() {

        return 1000; //TODO define a maximum in some way
    }

    public void resetMana() {
        setMana(0);
    }

    public void copy(IManaCapability cap) {
        setMana(cap.getMana());
    }


}
