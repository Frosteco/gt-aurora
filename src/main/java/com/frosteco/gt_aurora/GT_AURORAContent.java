package com.frosteco.gt_aurora;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Objects;

import org.apache.logging.log4j.Logger;

import com.frosteco.gt_aurora.client.GT_AURORACreativeTab;
import com.frosteco.gt_aurora.common.CommonProxy;
import com.frosteco.gt_aurora.common.block.GT_AURORAMetaBlocks;
import com.frosteco.gt_aurora.common.metatileentities.GT_AURORAMetaTileEntities;

@Mod(modid = "gt_aurora",
     name = "GT Aurora",
     version = "1.0.5",
     dependencies = GT_AURORAContent.DEP_VERSION_STRING)
public final class GT_AURORAContent {

    public static final String DEP_VERSION_STRING = "required-after:gregtech@[2.8.10-beta,);" +
            "required-after:gcym@[1.2.9,);" +
            "required-after:mixinbooter@[8.0,);";

    public static final GT_AURORACreativeTab creativeTab = new GT_AURORACreativeTab();

    @SidedProxy(modId = "gt_aurora",
                clientSide = "com.frosteco.gt_aurora.client.ClientProxy",
                serverSide = "com.frosteco.gt_aurora.common.CommonProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        log("Beginning PreInit");
        GT_AURORAMetaBlocks.init();
        GT_AURORAMetaTileEntities.init();
        proxy.preLoad();
        log("PreInit complete");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        log("Beginning PostInit");
        GT_AURORAContent.log("Nothing happens here");
        log("PostInit complete");
    }

    @EventHandler
    public static void log(Object message, LogType logType) {
        if (logger == null) {
            throw new IllegalStateException("Logger is not initialized");
        }

        switch (logType) {
            case INFO:
                logger.info(Objects.requireNonNull(message, "Message cannot be null"));
                break;
            case WARN:
                logger.warn(Objects.requireNonNull(message, "Message cannot be null"));
                break;
            case ERROR:
                logger.error(Objects.requireNonNull(message, "Message cannot be null"));
                break;
            default:
                throw new IllegalArgumentException("Invalid log type");
        }
    }


    public enum LogType {
        INFO,
        WARN,
        ERROR
    }

    public static void log(Object message) {
        log(message, LogType.INFO);
    }
}
