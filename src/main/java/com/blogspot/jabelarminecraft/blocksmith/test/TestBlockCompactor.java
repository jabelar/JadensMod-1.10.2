/**
    Copyright (C) 2016 by jabelar

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

package com.blogspot.jabelarminecraft.blocksmith.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blogspot.jabelarminecraft.blocksmith.blocks.BlockCompactor;

import net.minecraft.util.EnumBlockRenderType;

/**
 * @author jabelar
 *
 */
public class TestBlockCompactor
{

    /**
     * Test method for {@link com.blogspot.jabelarminecraft.blocksmith.blocks.BlockCompactor#getRenderType(net.minecraft.block.state.IBlockState)}.
     */
    @Test
    public void testGetRenderTypeIBlockState()
    {
        assertEquals("Render block type should be MODEL", EnumBlockRenderType.MODEL, BlockCompactor.getRenderTypeIBlockState() );
    }

 
}
