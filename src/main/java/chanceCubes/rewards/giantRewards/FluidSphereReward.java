package chanceCubes.rewards.giantRewards;

import chanceCubes.CCubesCore;
import chanceCubes.rewards.defaultRewards.BaseCustomReward;
import chanceCubes.rewards.rewardparts.OffsetBlock;
import chanceCubes.util.RewardsUtil;
import com.google.gson.JsonObject;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;

public class FluidSphereReward extends BaseCustomReward
{
	public FluidSphereReward()
	{
		super(CCubesCore.MODID + ":fluid_sphere", 0);
	}

	@Override
	public void trigger(ServerLevel level, BlockPos pos, Player player, JsonObject settings)
	{
		List<OffsetBlock> blocks = new ArrayList<>();

		Fluid fluid = RewardsUtil.getRandomFluid(true);

		int delay = 0;
		for(int i = 0; i <= 5; i++)
		{
			for(int yy = -5; yy < 6; yy++)
			{
				for(int zz = -5; zz < 6; zz++)
				{
					for(int xx = -5; xx < 6; xx++)
					{
						BlockPos loc = new BlockPos(xx, yy, zz);
						double dist = Math.sqrt(Math.abs(loc.distToLowCornerSqr(0, 0, 0)));
						if(dist <= 5 - i && dist > 5 - (i + 1))
						{
							OffsetBlock osb;
							if(i == 0)
							{
								osb = new OffsetBlock(xx, yy, zz, Blocks.GLASS, false, delay);
								osb.setBlockState(Blocks.GLASS.defaultBlockState());
							}
							else
							{
								osb = new OffsetBlock(xx, yy, zz, fluid.defaultFluidState().createLegacyBlock(), false, delay);
							}
							blocks.add(osb);
							delay++;

						}
					}
				}
			}
			delay += 10;
		}

		for(OffsetBlock b : blocks)
			b.spawnInWorld(level, pos.getX(), pos.getY(), pos.getZ());
	}
}