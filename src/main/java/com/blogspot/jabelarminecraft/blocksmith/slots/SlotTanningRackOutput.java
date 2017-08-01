/**
    Copyright (C) 2015 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/

package com.blogspot.jabelarminecraft.blocksmith.slots;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import com.blogspot.jabelarminecraft.blocksmith.recipes.TanningRackRecipes;

/**
 * @author jabelar
 *
 */
public class SlotTanningRackOutput  extends SlotOutput
{

    public SlotTanningRackOutput(EntityPlayer parPlayer, IInventory parIInventory, int parSlotIndex, int parXDisplayPosition, int parYDisplayPosition)
    {
        super(parPlayer, parIInventory, parSlotIndex, parXDisplayPosition, parYDisplayPosition);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
	protected void onCrafting(ItemStack parItemStack)
    {
//		  this adds a stat count    	
//        parItemStack.onCrafting(thePlayer.worldObj, thePlayer, field_75228_b);

        if (!thePlayer.world.isRemote)
        {
            int expEarned = getNumOutput();
            float expFactor = TanningRackRecipes.instance().getTanningExperience(parItemStack);

            if (expFactor == 0.0F)
            {
                expEarned = 0;
            }
            else if (expFactor < 1.0F)
            {
                int possibleExpEarned = MathHelper.floor(expEarned * expFactor);

                if (possibleExpEarned < MathHelper.floor(expEarned * expFactor) && Math.random() < expEarned * expFactor - possibleExpEarned)
                {
                    ++possibleExpEarned;
                }

                expEarned = possibleExpEarned;
            }

            // create experience orbs
            int expInOrb;
            while (expEarned > 0)
            {
                expInOrb = EntityXPOrb.getXPSplit(expEarned);
                expEarned -= expInOrb;
                thePlayer.world.spawnEntity(new EntityXPOrb(thePlayer.world, thePlayer.posX, thePlayer.posY + 0.5D, thePlayer.posZ + 0.5D, expInOrb));
            }
        }

        setNumOutput(0);

//        if (parItemStack.getItem() == Items.iron_ingot)
//        {
//            thePlayer.triggerAchievement(AchievementList.acquireIron);
//        }
//
//        if (parItemStack.getItem() == Items.grinded_fish)
//        {
//            thePlayer.triggerAchievement(AchievementList.grindFish);
//        }
    }
}