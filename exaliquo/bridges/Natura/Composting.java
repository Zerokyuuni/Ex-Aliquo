package exaliquo.bridges.Natura;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostNatura()
	{
		register(getIDs(Info.good), 0, 0.2F, color("raspbush"));
		register(getIDs(Info.good), 1, 0.2F, color("bluebush"));
		register(getIDs(Info.good), 2, 0.2F, color("blackbush"));
		register(getIDs(Info.good), 3, 0.2F, color("geobush"));
		register(getIDs(Info.evil), 0, 0.2F, color("blightbush"));
		register(getIDs(Info.evil), 1, 0.2F, color("duskbush"));
		register(getIDs(Info.evil), 2, 0.2F, color("skybush"));
		register(getIDs(Info.evil), 3, 0.2F, color("stingbush"));
		
		register(getIDs(Info.goodberry), 0, 0.05F, color("raspberry"));
		register(getIDs(Info.goodberry), 1, 0.05F, color("blueberry"));
		register(getIDs(Info.goodberry), 2, 0.05F, color("blackberry"));
		register(getIDs(Info.goodberry), 3, 0.05F, color("geoberry"));
		register(getIDs(Info.badberry), 0, 0.05F, color("blightberry"));
		register(getIDs(Info.badberry), 1, 0.05F, color("duskberry"));
		register(getIDs(Info.badberry), 2, 0.05F, color("skyberry"));
		register(getIDs(Info.badberry), 3, 0.05F, color("stingberry"));
		
		register(getIDs(Info.leaves), 0, 0.005F, color("redwood"));
		register(getIDs(Info.leaves), 1, 0.125F, color("eucalyptus"));
		register(getIDs(Info.leaves), 2, 0.125F, color("hopseed"));
		register(getIDs(Info.rareleaves), 0, 0.125F, color("maple"));
		register(getIDs(Info.rareleaves), 1, 0.125F, color("silverbell"));
		register(getIDs(Info.rareleaves), 2, 0.125F, color("amaranth"));
		register(getIDs(Info.rareleaves), 3, 0.125F, color("tigerwood"));
		register(getIDs(Info.darkleaves), 0, 0.125F, color("darkwood"));
		register(getIDs(Info.darkleaves), 1, 0.125F, color("darkwood"));
		register(getIDs(Info.darkleaves), 2, 0.125F, color("darkwood"));
		register(getIDs(Info.darkleaves), 3, 0.125F, color("fusewood"));
		register(getIDs(Info.monochrome), 0, 0.125F, color("sakura"));
		register(getIDs(Info.monochrome), 1, 0.125F, color("ghostwood"));
		register(getIDs(Info.monochrome), 2, 0.125F, color("bloodwood"));
		register(getIDs(Info.monochrome), 3, 0.125F, color("willow"));
		
		register(getIDs(Info.flora), 0, 0.005F, color("redwood"));
		register(getIDs(Info.flora), 1, 0.125F, color("eucalyptus"));
		register(getIDs(Info.flora), 2, 0.125F, color("hopseed"));
		register(getIDs(Info.flora), 3, 0.125F, color("sakura"));
		register(getIDs(Info.flora), 4, 0.125F, color("ghostwood"));
		register(getIDs(Info.flora), 5, 0.125F, color("bloodwood"));
		register(getIDs(Info.flora), 6, 0.125F, color("darkwood"));
		register(getIDs(Info.flora), 7, 0.125F, color("fusewood"));
		register(getIDs(Info.raresap), 0, 0.125F, color("maple"));
		register(getIDs(Info.raresap), 1, 0.125F, color("silverbell"));
		register(getIDs(Info.raresap), 2, 0.125F, color("amaranth"));
		register(getIDs(Info.raresap), 3, 0.125F, color("tigerwood"));
		register(getIDs(Info.raresap), 4, 0.125F, color("willow"));
		
		register(getIDs(Info.glowshroom), 0, 0.1F, color("blueglow"));
		register(getIDs(Info.glowshroom), 1, 0.1F, color("greenglow"));
		register(getIDs(Info.glowshroom), 2, 0.1F, color("purpleglow"));
		
		register(getIDs(Info.cactus), 0, 0.1F, color("saguaro"));
		register(getIDs(Info.fruit), 0, 0.1F, color("fruit"));
		register(getIDs(Info.potash), 0, 0.1F, color("potash"));
		register(getIDs(Info.plants), 0, 0.08F, color("barley"));
		register(getIDs(Info.plants), 1, 0.08F, color("barley"));
		register(getIDs(Info.plants), 2, 0.08F, color("flour"));
		register(getIDs(Info.plants), 3, 0.04F, color("white"));
		register(getIDs(Info.bluebell), 0, 0.1F, color("bluebell"));
		register(getIDs(Info.thornvines), 0, 0.1F, color("thornvine"));
		register(getIDs(Info.impmeat), 0, 0.2F, color("impmeat"));
		register(getIDs(Info.impmeat), 1, 0.2F, color("impmeat"));
	}
}
