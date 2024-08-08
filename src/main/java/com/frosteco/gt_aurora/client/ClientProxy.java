package com.frosteco.gt_aurora.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.frosteco.gt_aurora.common.CommonProxy;
import com.frosteco.gt_aurora.common.block.GT_AURORAMetaBlocks;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preLoad() {
        super.preLoad();
    }

    @SubscribeEvent
    public void registerItemRenderer(Item item, int meta, String id) {
      ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("gt_aurora:" + id, "inventory"));
   }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GT_AURORAMetaBlocks.registerItemModels();
    }
}
