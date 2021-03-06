package com.jdawg3636.icbm.common.reg;

import com.jdawg3636.icbm.ICBM;
import com.jdawg3636.icbm.ICBMReference;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.MinecartItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ICBMReference.MODID)
public class ItemReg {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ICBMReference.MODID);

    // Basic Blocks
    public static final RegistryObject<Item> CONCRETE                       = ITEMS.register("concrete",                        () -> new BlockItem(BlockReg.CONCRETE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> CONCRETE_COMPACT               = ITEMS.register("concrete_compact",                () -> new BlockItem(BlockReg.CONCRETE_COMPACT.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> CONCRETE_REINFORCED            = ITEMS.register("concrete_reinforced",             () -> new BlockItem(BlockReg.CONCRETE_REINFORCED.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> REINFORCED_GLASS               = ITEMS.register("reinforced_glass",                () -> new BlockItem(BlockReg.REINFORCED_GLASS.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> RADIOACTIVE_MATERIAL           = ITEMS.register("radioactive_material",            () -> new BlockItem(BlockReg.RADIOACTIVE_MATERIAL.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Ores
    public static final RegistryObject<Item> ORE_COPPER                     = ITEMS.register("ore_copper",                      () -> new BlockItem(BlockReg.ORE_COPPER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> ORE_SULFUR                     = ITEMS.register("ore_sulfur",                      () -> new BlockItem(BlockReg.ORE_SULFUR.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> ORE_TIN                        = ITEMS.register("ore_tin",                         () -> new BlockItem(BlockReg.ORE_TIN.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Explosives
    public static final RegistryObject<Item> EXPLOSIVES_CONDENSED           = ITEMS.register("explosives_condensed",            () -> new BlockItem(BlockReg.EXPLOSIVES_CONDENSED.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_SHRAPNEL            = ITEMS.register("explosives_shrapnel",             () -> new BlockItem(BlockReg.EXPLOSIVES_SHRAPNEL.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_INCENDIARY          = ITEMS.register("explosives_incendiary",           () -> new BlockItem(BlockReg.EXPLOSIVES_INCENDIARY.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_DEBILITATION        = ITEMS.register("explosives_debilitation",         () -> new BlockItem(BlockReg.EXPLOSIVES_DEBILITATION.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_CHEMICAL            = ITEMS.register("explosives_chemical",             () -> new BlockItem(BlockReg.EXPLOSIVES_CHEMICAL.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ANVIL               = ITEMS.register("explosives_anvil",                () -> new BlockItem(BlockReg.EXPLOSIVES_ANVIL.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_REPULSIVE           = ITEMS.register("explosives_repulsive",            () -> new BlockItem(BlockReg.EXPLOSIVES_REPULSIVE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ATTRACTIVE          = ITEMS.register("explosives_attractive",           () -> new BlockItem(BlockReg.EXPLOSIVES_ATTRACTIVE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_NIGHTMARE           = ITEMS.register("explosives_nightmare",            () -> new BlockItem(BlockReg.EXPLOSIVES_NIGHTMARE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_FRAGMENTATION       = ITEMS.register("explosives_fragmentation",        () -> new BlockItem(BlockReg.EXPLOSIVES_FRAGMENTATION.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_CONTAGIOUS          = ITEMS.register("explosives_contagious",           () -> new BlockItem(BlockReg.EXPLOSIVES_CONTAGIOUS.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_SONIC               = ITEMS.register("explosives_sonic",                () -> new BlockItem(BlockReg.EXPLOSIVES_SONIC.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_BREACHING           = ITEMS.register("explosives_breaching",            () -> new BlockItem(BlockReg.EXPLOSIVES_BREACHING.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_REJUVENATION        = ITEMS.register("explosives_rejuvenation",         () -> new BlockItem(BlockReg.EXPLOSIVES_REJUVENATION.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_THERMOBARIC         = ITEMS.register("explosives_thermobaric",          () -> new BlockItem(BlockReg.EXPLOSIVES_THERMOBARIC.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_NUCLEAR             = ITEMS.register("explosives_nuclear",              () -> new BlockItem(BlockReg.EXPLOSIVES_NUCLEAR.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_EMP                 = ITEMS.register("explosives_emp",                  () -> new BlockItem(BlockReg.EXPLOSIVES_EMP.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_EXOTHERMIC          = ITEMS.register("explosives_exothermic",           () -> new BlockItem(BlockReg.EXPLOSIVES_EXOTHERMIC.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ENDOTHERMIC         = ITEMS.register("explosives_endothermic",          () -> new BlockItem(BlockReg.EXPLOSIVES_ENDOTHERMIC.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ANTIGRAVITATIONAL   = ITEMS.register("explosives_antigravitational",    () -> new BlockItem(BlockReg.EXPLOSIVES_ANTIGRAVITATIONAL.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ENDER               = ITEMS.register("explosives_ender",                () -> new BlockItem(BlockReg.EXPLOSIVES_ENDER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_HYPERSONIC          = ITEMS.register("explosives_hypersonic",           () -> new BlockItem(BlockReg.EXPLOSIVES_HYPERSONIC.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_ANTIMATTER          = ITEMS.register("explosives_antimatter",           () -> new BlockItem(BlockReg.EXPLOSIVES_ANTIMATTER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EXPLOSIVES_REDMATTER           = ITEMS.register("explosives_redmatter",            () -> new BlockItem(BlockReg.EXPLOSIVES_REDMATTER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Unconventional Explosives
    public static final RegistryObject<Item> S_MINE                         = ITEMS.register("s_mine",                          () -> new BlockItem(BlockReg.S_MINE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Missiles
    public static final RegistryObject<Item> MISSILE_MODULE                 = ITEMS.register("missile_module",                  () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_CONVENTIONAL           = ITEMS.register("missile_conventional",            () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_SHRAPNEL               = ITEMS.register("missile_shrapnel",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_INCENDIARY             = ITEMS.register("missile_incendiary",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_DEBILITATION           = ITEMS.register("missile_debilitation",            () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_CHEMICAL               = ITEMS.register("missile_chemical",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ANVIL                  = ITEMS.register("missile_anvil",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_REPULSIVE              = ITEMS.register("missile_repulsive",               () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ATTRACTIVE             = ITEMS.register("missile_attractive",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_NIGHTMARE              = ITEMS.register("missile_nightmare",               () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_FRAGMENTATION          = ITEMS.register("missile_fragmentation",           () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_CONTAGIOUS             = ITEMS.register("missile_contagious",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_SONIC                  = ITEMS.register("missile_sonic",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_BREACHING              = ITEMS.register("missile_breaching",               () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_REJUVENATION           = ITEMS.register("missile_rejuvenation",            () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_THERMOBARIC            = ITEMS.register("missile_thermobaric",             () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_NUCLEAR                = ITEMS.register("missile_nuclear",                 () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_EMP                    = ITEMS.register("missile_emp",                     () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_EXOTHERMIC             = ITEMS.register("missile_exothermic",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ENDOTHERMIC            = ITEMS.register("missile_endothermic",             () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ANTIGRAVITATIONAL      = ITEMS.register("missile_antigravitational",       () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ENDER                  = ITEMS.register("missile_ender",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_HYPERSONIC             = ITEMS.register("missile_hypersonic",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ANTIMATTER             = ITEMS.register("missile_antimatter",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_REDMATTER              = ITEMS.register("missile_redmatter",               () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_HOMING                 = ITEMS.register("missile_homing",                  () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_ANTIBALLISTIC          = ITEMS.register("missile_antiballistic",           () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_CLUSTER                = ITEMS.register("missile_cluster",                 () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MISSILE_CLUSTER_NUCLEAR        = ITEMS.register("missile_cluster_nuclear",         () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Minecarts
    public static final RegistryObject<Item> MINECART_EXPLOSIVE             = ITEMS.register("minecart_explosive",              () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_SHRAPNEL              = ITEMS.register("minecart_shrapnel",               () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_INCENDIARY            = ITEMS.register("minecart_incendiary",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_DEBILITATION          = ITEMS.register("minecart_debilitation",           () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_CHEMICAL              = ITEMS.register("minecart_chemical",               () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ANVIL                 = ITEMS.register("minecart_anvil",                  () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_REPULSIVE             = ITEMS.register("minecart_repulsive",              () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ATTRACTIVE            = ITEMS.register("minecart_attractive",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_NIGHTMARE             = ITEMS.register("minecart_nightmare",              () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_FRAGMENTATION         = ITEMS.register("minecart_fragmentation",          () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_CONTAGIOUS            = ITEMS.register("minecart_contagious",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_SONIC                 = ITEMS.register("minecart_sonic",                  () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_BREACHING             = ITEMS.register("minecart_breaching",              () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_REJUVENATION          = ITEMS.register("minecart_rejuvenation",           () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_THERMOBARIC           = ITEMS.register("minecart_thermobaric",            () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_NUCLEAR               = ITEMS.register("minecart_nuclear",                () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_EMP                   = ITEMS.register("minecart_emp",                    () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_EXOTHERMIC            = ITEMS.register("minecart_exothermic",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ENDOTHERMIC           = ITEMS.register("minecart_endothermic",            () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ANTIGRAVITATIONAL     = ITEMS.register("minecart_antigravitational",      () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ENDER                 = ITEMS.register("minecart_ender",                  () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_HYPERSONIC            = ITEMS.register("minecart_hypersonic",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_ANTIMATTER            = ITEMS.register("minecart_antimatter",             () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> MINECART_REDMATTER             = ITEMS.register("minecart_redmatter",              () -> new MinecartItem(AbstractMinecartEntity.Type.TNT, (new Item.Properties()).maxStackSize(1).group(ICBM.CREATIVE_TAB)));

    // Grenades
    public static final RegistryObject<Item> GRENADE_CONVENTIONAL           = ITEMS.register("grenade_conventional",            () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_SHRAPNEL               = ITEMS.register("grenade_shrapnel",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_INCENDIARY             = ITEMS.register("grenade_incendiary",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_DEBILITATION           = ITEMS.register("grenade_debilitation",            () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_CHEMICAL               = ITEMS.register("grenade_chemical",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_ANVIL                  = ITEMS.register("grenade_anvil",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_REPULSIVE              = ITEMS.register("grenade_repulsive",               () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GRENADE_ATTRACTIVE             = ITEMS.register("grenade_attractive",              () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Spikes
    public static final RegistryObject<Item> SPIKES                         = ITEMS.register("spikes",                          () -> new BlockItem(BlockReg.SPIKES.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> SPIKES_POISON                  = ITEMS.register("spikes_poison",                   () -> new BlockItem(BlockReg.SPIKES_POISON.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> SPIKES_FIRE                    = ITEMS.register("spikes_fire",                     () -> new BlockItem(BlockReg.SPIKES_FIRE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Missile Launch Apparatus
    public static final RegistryObject<Item> LAUNCHER_PLATFORM_T1           = ITEMS.register("launcher_platform_t1",            () -> new BlockItem(BlockReg.LAUNCHER_PLATFORM_T1.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_PLATFORM_T2           = ITEMS.register("launcher_platform_t2",            () -> new BlockItem(BlockReg.LAUNCHER_PLATFORM_T2.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_PLATFORM_T3           = ITEMS.register("launcher_platform_t3",            () -> new BlockItem(BlockReg.LAUNCHER_PLATFORM_T3.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_CONTROL_PANEL_T1      = ITEMS.register("launcher_control_panel_t1",       () -> new BlockItem(BlockReg.LAUNCHER_CONTROL_PANEL_T1.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_CONTROL_PANEL_T2      = ITEMS.register("launcher_control_panel_t2",       () -> new BlockItem(BlockReg.LAUNCHER_CONTROL_PANEL_T2.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_CONTROL_PANEL_T3      = ITEMS.register("launcher_control_panel_t3",       () -> new BlockItem(BlockReg.LAUNCHER_CONTROL_PANEL_T3.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_SUPPORT_FRAME_T1      = ITEMS.register("launcher_support_frame_t1",       () -> new BlockItem(BlockReg.LAUNCHER_SUPPORT_FRAME_T1.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_SUPPORT_FRAME_T2      = ITEMS.register("launcher_support_frame_t2",       () -> new BlockItem(BlockReg.LAUNCHER_SUPPORT_FRAME_T2.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LAUNCHER_SUPPORT_FRAME_T3      = ITEMS.register("launcher_support_frame_t3",       () -> new BlockItem(BlockReg.LAUNCHER_SUPPORT_FRAME_T3.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Other Machinery
    public static final RegistryObject<Item> CRUISE_LAUNCHER                = ITEMS.register("cruise_launcher",                 () -> new BlockItem(BlockReg.CRUISE_LAUNCHER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> EMP_TOWER                      = ITEMS.register("emp_tower",                       () -> new BlockItem(BlockReg.EMP_TOWER.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> RADAR_STATION                  = ITEMS.register("radar_station",                   () -> new BlockItem(BlockReg.RADAR_STATION.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Functional Items
    public static final RegistryObject<Item> BATTERY                        = ITEMS.register("battery",                         () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> DEFUSER                        = ITEMS.register("defuser",                         () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> LASER_DESIGNATOR               = ITEMS.register("laser_designator",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> RADAR_GUN                      = ITEMS.register("radar_gun",                       () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> REMOTE_DETONATOR               = ITEMS.register("remote_detonator",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> ROCKET_LAUNCHER                = ITEMS.register("rocket_launcher",                 () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> SIGNAL_DISRUPTOR               = ITEMS.register("signal_disruptor",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> TRACKER                        = ITEMS.register("tracker",                         () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Basic Crafting Items (No functionality)
    public static final RegistryObject<Item> POISON_POWDER                  = ITEMS.register("poison_powder",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> SULFUR                         = ITEMS.register("sulfur",                          () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> COPPER_WIRE                    = ITEMS.register("copper_wire",                     () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> CIRCUIT_BASIC                  = ITEMS.register("circuit_basic",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> CIRCUIT_ADVANCED               = ITEMS.register("circuit_advanced",                () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> CIRCUIT_ELITE                  = ITEMS.register("circuit_elite",                   () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> DUST_BRONZE                    = ITEMS.register("dust_bronze",                     () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> DUST_STEEL                     = ITEMS.register("dust_steel",                      () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> INGOT_BRONZE                   = ITEMS.register("ingot_bronze",                    () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> INGOT_COPPER                   = ITEMS.register("ingot_copper",                    () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> INGOT_STEEL                    = ITEMS.register("ingot_steel",                     () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> INGOT_TIN                      = ITEMS.register("ingot_tin",                       () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> PLATE_BRONZE                   = ITEMS.register("plate_bronze",                    () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> PLATE_STEEL                    = ITEMS.register("plate_steel",                     () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));

    // Extras
    public static final RegistryObject<Item> ANTIDOTE                       = ITEMS.register("antidote",                        () -> new Item(new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GLASS_BUTTON                   = ITEMS.register("glass_button",                    () -> new BlockItem(BlockReg.GLASS_BUTTON.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));
    public static final RegistryObject<Item> GLASS_PRESSURE_PLATE           = ITEMS.register("glass_pressure_plate",            () -> new BlockItem(BlockReg.GLASS_PRESSURE_PLATE.get(), new Item.Properties().group(ICBM.CREATIVE_TAB)));

}
