package com.acronym.conquest.proxy;

import com.acronym.conquest.handlers.event.ClientEventHandler;

public class ClientProxy extends CommonProxy {

    public void initRenderers() {

    }

    public void initGuis() {

    }

    public void initEvents() {
        new ClientEventHandler();
    }

}
