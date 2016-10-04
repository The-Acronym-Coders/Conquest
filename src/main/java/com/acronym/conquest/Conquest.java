package com.acronym.conquest;

import com.acronym.base.util.LogHelper;
import com.acronym.conquest.api.mana.capability.IManaCapability;
import com.acronym.conquest.api.mana.capability.ManaCapability;
import com.acronym.conquest.api.mana.capability.ManaCapabilityStorage;
import com.acronym.conquest.handlers.event.CommonEventHandler;
import com.acronym.conquest.proxy.CommonProxy;
import com.acronym.conquest.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.acronym.base.Base.logger;
import static com.acronym.conquest.reference.Reference.*;

@Mod(modid = MODID, name = NAME, version = BUILD_VERSION)
public class Conquest {


    @Instance(MODID)
    public static Conquest INSTANCE;

    public static final LogHelper LOGGER = new LogHelper(Reference.NAME);

    @SidedProxy(clientSide = "com.acronym.conquest.proxy.ClientProxy", serverSide = "com.acronym.conquest.proxy.CommonProxy")
    public static CommonProxy PROXY;
    private static long totalTime = 0;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting PreInit");
        long time = System.currentTimeMillis();

        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        CapabilityManager.INSTANCE.register(IManaCapability.class, ManaCapabilityStorage.instance, ManaCapability.class);

        time = (System.currentTimeMillis() - time);
        totalTime += time;
        logger.info(String.format("Completed PreInit in: %d ms", time));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Starting Init");
        long time = System.currentTimeMillis();

        time = (System.currentTimeMillis() - time);
        totalTime += time;
        logger.info(String.format("Completed Init in: %d ms", time));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Starting PostInit");
        long time = System.currentTimeMillis();

        time = (System.currentTimeMillis() - time);
        totalTime += time;
        logger.info(String.format("Completed PostInit in: %d ms", time));

    }

    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        logger.info("Starting LoadComplete");
        long time = System.currentTimeMillis();
        time = (System.currentTimeMillis() - time);
        totalTime += time;
        logger.info(String.format("Completed LoadComplete in: %d ms", time));
        logger.info(String.format("Loaded In: %d ms", totalTime));
    }

}
