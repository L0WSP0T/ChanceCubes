package chanceCubes.registry.global;

import chanceCubes.rewards.IChanceCubeReward;

public class GlobalRewardInfo
{
	public final IChanceCubeReward reward;
	public boolean enabled;

	public GlobalRewardInfo(IChanceCubeReward reward, boolean enabled)
	{
		this.reward = reward;
		this.enabled = enabled;
	}
}
