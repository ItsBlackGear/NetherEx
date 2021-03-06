/*
 * NetherEx
 * Copyright (c) 2016-2019 by LogicTechCorp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package logictechcorp.netherex.block;

import logictechcorp.libraryex.block.MimicBlock;
import logictechcorp.netherex.tileentity.QuartzOreTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class QuartzOreBlock extends MimicBlock<QuartzOreTileEntity>
{
    public QuartzOreBlock()
    {
        super(Properties.from(Blocks.NETHER_QUARTZ_ORE), MimicType.UNDERLAY, QuartzOreTileEntity.class);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortuneLevel, int silkTouchLevel)
    {
        return silkTouchLevel == 0 ? MathHelper.nextInt(this.RANDOM, 2, 5) : 0;
    }

    @Override
    public BlockState getMimickedState(BlockState state, IWorldReader reader, BlockPos pos)
    {
        return reader.getBiome(pos).getSurfaceBuilder().config.getUnder();
    }

    @Override
    public ResourceLocation getLootTable()
    {
        return Blocks.NETHER_QUARTZ_ORE.getLootTable();
    }
}
