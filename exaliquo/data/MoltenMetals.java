package exaliquo.data;

import tconstruct.TConstruct;

public class MoltenMetals
{
	public static final int ingotCost = TConstruct.ingotLiquidValue;
	public static final int ingotCostSmeltery = ingotCost * (Configurations.isOre?2:1);
	public static final int dustCostGeneral = ingotCost / (Configurations.dustValue?4:6);
	public static final int dustCostSmeltery = dustCostGeneral * (Configurations.isOre?2:1);
}
