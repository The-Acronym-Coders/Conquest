package com.acronym.conquest.handlers.event;

import net.minecraftforge.common.MinecraftForge;

public class ClientEventHandler {

    public ClientEventHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
