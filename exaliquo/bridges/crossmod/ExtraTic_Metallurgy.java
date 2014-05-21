package exaliquo.bridges.crossmod;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import static exaliquo.data.MoltenMetals.*;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import exaliquo.Registries;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.CrucibleRegistry;

public class ExtraTic_Metallurgy
{

	protected static void SmeltMetallurgy()
	{
		for (int i = 0; i < 3; i++)
		{
			Smeltery.addMelting(Registries.adamantineOreBlock, i, 550, new FluidStack(getFluid("molten.adamantine"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.alduoriteOreBlock, i, 550, new FluidStack(getFluid("molten.alduorite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.astralsilverOreBlock, i, 550, new FluidStack(getFluid("molten.astral.silver"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.atlarusOreBlock, i, 550, new FluidStack(getFluid("molten.atlarus"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.carmotOreBlock, i, 550, new FluidStack(getFluid("molten.carmot"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.ceruclaseOreBlock, i, 550, new FluidStack(getFluid("molten.ceruclase"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.deepironOreBlock, i, 550, new FluidStack(getFluid("molten.deep.iron"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.eximiteOreBlock, i, 550, new FluidStack(getFluid("molten.eximite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.ignatiusOreBlock, i, 550, new FluidStack(getFluid("molten.ignatius"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.infuscoliumOreBlock, i, 550, new FluidStack(getFluid("molten.infuscolium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.kalendriteOreBlock, i, 550, new FluidStack(getFluid("molten.kalendrite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.lemuriteOreBlock, i, 550, new FluidStack(getFluid("molten.lemurite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.manganeseOreBlock, i, 700, new FluidStack(getFluid("molten.manganese"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.meutoiteOreBlock, i, 550, new FluidStack(getFluid("molten.meutoite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.midasiumOreBlock, i, 550, new FluidStack(getFluid("molten.midasium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.mithrilOreBlock, i, 550, new FluidStack(getFluid("molten.mithril"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.orichalcumOreBlock, i, 550, new FluidStack(getFluid("molten.orichalcum"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.oureclaseOreBlock, i, 550, new FluidStack(getFluid("molten.oureclase"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.prometheumOreBlock, i, 550, new FluidStack(getFluid("molten.prometheum"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.rubraciumOreBlock, i, 550, new FluidStack(getFluid("molten.rubracium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.sanguiniteOreBlock, i, 550, new FluidStack(getFluid("molten.sanguinite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.shadowironOreBlock, i, 550, new FluidStack(getFluid("molten.shadow.iron"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.vulcaniteOreBlock, i, 550, new FluidStack(getFluid("molten.vulcanite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.vyroxeresOreBlock, i, 550, new FluidStack(getFluid("molten.vyroxeres"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.zincOreBlock, i, 550, new FluidStack(getFluid("molten.zinc"), ingotCostSmeltery));

			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(Registries.adamantineOreBlock.blockID, i, ingotCost*2, getFluid("adamantine.molten"), ingotCost, Registries.adamantineOreBlock);
				CrucibleRegistry.register(Registries.alduoriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.alduorite"), ingotCost, Registries.alduoriteOreBlock);
				CrucibleRegistry.register(Registries.astralsilverOreBlock.blockID, i, ingotCost*2, getFluid("molten.astral.silver"), ingotCost, Registries.astralsilverOreBlock);
				CrucibleRegistry.register(Registries.atlarusOreBlock.blockID, i, ingotCost*2, getFluid("molten.atlarus"), ingotCost, Registries.atlarusOreBlock);
				CrucibleRegistry.register(Registries.carmotOreBlock.blockID, i, ingotCost*2, getFluid("molten.carmot"), ingotCost, Registries.carmotOreBlock);
				CrucibleRegistry.register(Registries.ceruclaseOreBlock.blockID, i, ingotCost*2, getFluid("molten.ceruclase"), ingotCost, Registries.ceruclaseOreBlock);
				CrucibleRegistry.register(Registries.deepironOreBlock.blockID, i, ingotCost*2, getFluid("molten.deep.iron"), ingotCost, Registries.deepironOreBlock);
				CrucibleRegistry.register(Registries.eximiteOreBlock.blockID, i, ingotCost*2, getFluid("molten.eximite"), ingotCost, Registries.eximiteOreBlock);
				CrucibleRegistry.register(Registries.ignatiusOreBlock.blockID, i, ingotCost*2, getFluid("molten.ignatius"), ingotCost, Registries.ignatiusOreBlock);
				CrucibleRegistry.register(Registries.infuscoliumOreBlock.blockID, i, ingotCost*2, getFluid("molten.infuscolium"), ingotCost, Registries.infuscoliumOreBlock);
				CrucibleRegistry.register(Registries.kalendriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.kalendrite"), ingotCost, Registries.kalendriteOreBlock);
				CrucibleRegistry.register(Registries.lemuriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.lemurite"), ingotCost, Registries.lemuriteOreBlock);
				CrucibleRegistry.register(Registries.manganeseOreBlock.blockID, i, ingotCost*2, getFluid("molten.manganese"), ingotCost, Registries.manganeseOreBlock);
				CrucibleRegistry.register(Registries.meutoiteOreBlock.blockID, i, ingotCost*2, getFluid("molten.meutoite"), ingotCost, Registries.meutoiteOreBlock);
				CrucibleRegistry.register(Registries.midasiumOreBlock.blockID, i, ingotCost*2, getFluid("molten.midasium"), ingotCost, Registries.midasiumOreBlock);
				CrucibleRegistry.register(Registries.mithrilOreBlock.blockID, i, ingotCost*2, getFluid("molten.mithril"), ingotCost, Registries.mithrilOreBlock);
				CrucibleRegistry.register(Registries.orichalcumOreBlock.blockID, i, ingotCost*2, getFluid("molten.orichalcum"), ingotCost, Registries.orichalcumOreBlock);
				CrucibleRegistry.register(Registries.oureclaseOreBlock.blockID, i, ingotCost*2, getFluid("molten.oureclase"), ingotCost, Registries.oureclaseOreBlock);
				CrucibleRegistry.register(Registries.prometheumOreBlock.blockID, i, ingotCost*2, getFluid("molten.prometheum"), ingotCost, Registries.prometheumOreBlock);
				CrucibleRegistry.register(Registries.rubraciumOreBlock.blockID, i, ingotCost*2, getFluid("molten.rubracium"), ingotCost, Registries.rubraciumOreBlock);
				CrucibleRegistry.register(Registries.sanguiniteOreBlock.blockID, i, ingotCost*2, getFluid("molten.sanguinite"), ingotCost, Registries.sanguiniteOreBlock);
				CrucibleRegistry.register(Registries.vulcaniteOreBlock.blockID, i, ingotCost*2, getFluid("molten.vulcanite"), ingotCost, Registries.vulcaniteOreBlock);
				CrucibleRegistry.register(Registries.vyroxeresOreBlock.blockID, i, ingotCost*2, getFluid("molten.vyroxeres"), ingotCost, Registries.vyroxeresOreBlock);
				CrucibleRegistry.register(Registries.zincOreBlock.blockID, i, ingotCost*2, getFluid("molten.zinc"), ingotCost, Registries.zincOreBlock);
			}

			if (Configurations.allowDustSmelting)
			{
				Smeltery.addMelting(new ItemStack(Registries.adamantineOreItem, 4, i), Registries.adamantineOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.adamantine"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.alduoriteOreItem, 4, i), Registries.alduoriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.alduorite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.astralsilverOreItem, 4, i), Registries.astralsilverOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.astral.silver"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.atlarusOreItem, 4, i), Registries.atlarusOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.atlarus"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.carmotOreItem, 4, i), Registries.carmotOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.carmot"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.ceruclaseOreItem, 4, i), Registries.ceruclaseOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.ceruclase"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.deepironOreItem, 4, i), Registries.deepironOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.deep.iron"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.eximiteOreItem, 4, i), Registries.eximiteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.eximite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.ignatiusOreItem, 4, i), Registries.ignatiusOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.ignatius"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.infuscoliumOreItem, 4, i), Registries.infuscoliumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.infuscolium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.kalendriteOreItem, 4, i), Registries.kalendriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.kalendrite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.lemuriteOreItem, 4, i), Registries.lemuriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.lemurite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.manganeseOreItem, 4, i), Registries.manganeseOreBlock.blockID, i ,700, new FluidStack(getFluid("molten.manganese"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.meutoiteOreItem, 4, i), Registries.meutoiteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.meutoite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.midasiumOreItem, 4, i), Registries.midasiumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.midasium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.mithrilOreItem, 4, i), Registries.mithrilOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.mithril"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.orichalcumOreItem, 4, i), Registries.orichalcumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.orichalcum"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.oureclaseOreItem, 4, i), Registries.oureclaseOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.oureclase"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.prometheumOreItem, 4, i), Registries.prometheumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.prometheum"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.rubraciumOreItem, 4, i), Registries.rubraciumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.rubracium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.sanguiniteOreItem, 4, i), Registries.sanguiniteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.sanguinite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.shadowironOreItem, 4, i), Registries.shadowironOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.shadow.iron"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.vulcaniteOreItem, 4, i), Registries.vulcaniteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.vulcanite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.vyroxeresOreItem, 4, i), Registries.vyroxeresOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.vyroxeres"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.zincOreItem, 4, i), Registries.zincOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.zinc"), dustCostSmeltery));

				if (Configurations.miniSmelting)
				{
					CrucibleRegistry.register(Registries.adamantineOreItem.itemID, i, dustCostGeneral*2, getFluid("adamantine.molten"), dustCostGeneral, Registries.adamantineOreBlock);
					CrucibleRegistry.register(Registries.alduoriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.alduorite"), dustCostGeneral, Registries.alduoriteOreBlock);
					CrucibleRegistry.register(Registries.astralsilverOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.astral.silver"), dustCostGeneral, Registries.astralsilverOreBlock);
					CrucibleRegistry.register(Registries.atlarusOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.atlarus"), dustCostGeneral, Registries.atlarusOreBlock);
					CrucibleRegistry.register(Registries.carmotOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.carmot"), dustCostGeneral, Registries.carmotOreBlock);
					CrucibleRegistry.register(Registries.ceruclaseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.ceruclase"), dustCostGeneral, Registries.ceruclaseOreBlock);
					CrucibleRegistry.register(Registries.deepironOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.deep.iron"), dustCostGeneral, Registries.deepironOreBlock);
					CrucibleRegistry.register(Registries.eximiteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.eximite"), dustCostGeneral, Registries.eximiteOreBlock);
					CrucibleRegistry.register(Registries.ignatiusOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.ignatius"), dustCostGeneral, Registries.ignatiusOreBlock);
					CrucibleRegistry.register(Registries.infuscoliumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.infuscolium"), dustCostGeneral, Registries.infuscoliumOreBlock);
					CrucibleRegistry.register(Registries.kalendriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.kalendrite"), dustCostGeneral, Registries.kalendriteOreBlock);
					CrucibleRegistry.register(Registries.lemuriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.lemurite"), dustCostGeneral, Registries.lemuriteOreBlock);
					CrucibleRegistry.register(Registries.manganeseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.manganese"), dustCostGeneral, Registries.manganeseOreBlock);
					CrucibleRegistry.register(Registries.meutoiteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.meutoite"), dustCostGeneral, Registries.meutoiteOreBlock);
					CrucibleRegistry.register(Registries.midasiumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.midasium"), dustCostGeneral, Registries.midasiumOreBlock);
					CrucibleRegistry.register(Registries.mithrilOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.mithril"), dustCostGeneral, Registries.mithrilOreBlock);
					CrucibleRegistry.register(Registries.orichalcumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.orichalcum"), dustCostGeneral, Registries.orichalcumOreBlock);
					CrucibleRegistry.register(Registries.oureclaseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.oureclase"), dustCostGeneral, Registries.oureclaseOreBlock);
					CrucibleRegistry.register(Registries.prometheumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.prometheum"), dustCostGeneral, Registries.prometheumOreBlock);
					CrucibleRegistry.register(Registries.rubraciumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.rubracium"), dustCostGeneral, Registries.rubraciumOreBlock);
					CrucibleRegistry.register(Registries.sanguiniteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.sanguinite"), dustCostGeneral, Registries.sanguiniteOreBlock);
					CrucibleRegistry.register(Registries.vulcaniteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.vulcanite"), dustCostGeneral, Registries.vulcaniteOreBlock);
					CrucibleRegistry.register(Registries.vyroxeresOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.vyroxeres"), dustCostGeneral, Registries.vyroxeresOreBlock);
					CrucibleRegistry.register(Registries.zincOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.zinc"), dustCostGeneral, Registries.zincOreBlock);
				}
			}
		}
	}
}
