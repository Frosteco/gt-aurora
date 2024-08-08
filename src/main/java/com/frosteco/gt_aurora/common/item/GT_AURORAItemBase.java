package com.frosteco.gt_aurora.common.item;

import com.frosteco.gt_aurora.GT_AURORAContent;
import com.frosteco.gt_aurora.api.util.IHasModel;

import net.minecraft.item.Item;

public class GT_AURORAItemBase extends Item implements IHasModel
{
   public GT_AURORAItemBase(String name)
   {
      setUnlocalizedName(name);
      setRegistryName(name);
      setCreativeTab(GT_AURORAContent.creativeTab);

      GT_AURORAItems.ITEMS.add(this);
   }

   public void registerModels()
   {
      GT_AURORAContent.proxy.registerItemRenderer(this, 0, "inventory");
   }
}