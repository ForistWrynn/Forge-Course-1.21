package net.forist.mccourse.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.command.ReturnHomeCommand;
import net.forist.mccourse.command.SetHomeCommand;
import net.forist.mccourse.item.ModItems;
import net.forist.mccourse.item.custom.HammerItem;
import net.forist.mccourse.potion.ModPotions;
import net.forist.mccourse.villager.ModVillagers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvent
{
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event)
    {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION.getHolder().get());
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if (event.getType() == VillagerProfession.FARMER)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KOHLRABI.get(), 3),
                    new ItemStack(Items.EMERALD, 4),6,3,0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.KOHLRABI_SEEDS.get(), 2),4,2,0.025f
            ));
        }

        if (event.getType() == VillagerProfession.TOOLSMITH)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 32),
                    new ItemStack(ModItems.METAL_DETECTOR.get(), 1),1,10,0.025f
            ));
        }

        if (event.getType() == ModVillagers.KAUPENGER.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.URIEL_MOCHI.get(), 4),10,8,0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.LEVINA_MOCHI.get(), 4),10,8,0.025f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 2),
                    new ItemStack(ModItems.TA_YUET.get(), 2),10,8,0.025f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ALEXANDRITE.get(), 2),
                    new ItemStack(ModItems.HANNAH_MOCHI.get(), 1),10,8,0.025f
            ));
        }

    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event)
    {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(ModItems.RADIATION_STAFF.get(), 1),1,10,0.02f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 10),
                new ItemStack(ModItems.BAR_BRAWL_RECORD.get(), 1),1,10,0.02f));
    }

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event)
    {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("mccourse.homepos",
                event.getOriginal().getPersistentData().getIntArray("mccourse.homepos"));
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent event)
    {
        if (event.getEntity() instanceof Sheep)
        {
            if (event.getSource().getDirectEntity() instanceof Player player)
            {
                if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.ALEXANDRITE_SWORD.get())
                {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + "just hit sheep with a alexandrite sword! how cruel you are"));
                    MCCourseMod.LOGGER.info("Sheep was hit  with Alexandrite Sword by " + player.getName().getString());
                }
                else if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.DIAMOND)
                {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + "just hit sheep with a DIAMOND! how rich you are"));
                    MCCourseMod.LOGGER.info("Sheep was hit  with diamond by " + player.getName().getString());
                }
                else
                {
                    MCCourseMod.LOGGER.info("Sheep was hit with something else by " +player.getName().getString());
                }
            }
        }
    }

}
