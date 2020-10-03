package icbm.classic;

import icbm.classic.api.EnumTier;
import icbm.classic.api.ICBMClassicAPI;
import icbm.classic.client.ClientProxy;
import icbm.classic.lib.NBTConstants;
import icbm.classic.api.reg.events.ExplosiveRegistryEvent;
import icbm.classic.api.reg.events.ExplosiveContentRegistryEvent;
import icbm.classic.client.ICBMCreativeTab;
import icbm.classic.command.ICBMCommands;
import icbm.classic.command.system.CommandEntryPoint;
import icbm.classic.config.ConfigItems;
import icbm.classic.config.ConfigThread;
import icbm.classic.content.reg.ExplosiveInit;
import icbm.classic.content.entity.missile.CapabilityMissile;
import icbm.classic.content.items.behavior.BombCartDispenseBehavior;
import icbm.classic.content.items.behavior.GrenadeDispenseBehavior;
import icbm.classic.content.potion.ContagiousPoison;
import icbm.classic.content.potion.PoisonContagion;
import icbm.classic.content.potion.PoisonFrostBite;
import icbm.classic.content.potion.PoisonToxin;
import icbm.classic.content.reg.ItemReg;
import icbm.classic.datafix.EntityExplosiveDataFixer;
import icbm.classic.datafix.EntityGrenadeDataFixer;
import icbm.classic.datafix.TileExplosivesDataFixer;
import icbm.classic.datafix.TileRadarStationDataFixer;
import icbm.classic.lib.capability.emp.CapabilityEMP;
import icbm.classic.lib.capability.ex.CapabilityExplosive;
import icbm.classic.lib.energy.system.EnergySystem;
import icbm.classic.lib.energy.system.EnergySystemFE;
import icbm.classic.lib.explosive.reg.*;
import icbm.classic.lib.network.netty.PacketManager;
import icbm.classic.lib.radar.RadarRegistry;
import icbm.classic.lib.radio.RadioRegistry;
import icbm.classic.lib.thread.WorkerThreadManager;
import icbm.classic.prefab.item.LootEntryItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Mod class for ICBM Classic, contains all loading code and references to objects crated by the mod.
 *
 * @author Dark(DarkGuardsman, Robert).
 * <p>
 * Orginal author and creator of the mod: Calclavia
 */
@Mod(ICBMConstants.DOMAIN)
@Mod.EventBusSubscriber
public final class ICBMClassic
{

    public static final boolean runningAsDev = System.getProperty("development") != null && System.getProperty("development").equalsIgnoreCase("true");

    //@Mod.Instance(ICBMConstants.DOMAIN)
    //public static ICBMClassic INSTANCE;

    // Clever hack found in Mekanism source, not the proper way to do this.
    public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String MC_VERSION = "@MC@";
    public static final String VERSION = MC_VERSION + "-" + MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;
    public static final String DEPENDENCIES = "";

    public static final int MAP_HEIGHT = 255;

    protected static Logger logger = LogManager.getLogger(ICBMConstants.DOMAIN);
    public static Logger logger() { return logger; }

    public static final PacketManager packetHandler = new PacketManager(ICBMConstants.DOMAIN);

    //Mod support
    public static Block blockRadioactive = Blocks.MYCELIUM; //TODO implement

    public static final ContagiousPoison poisonous_potion = new ContagiousPoison("Chemical", 0, false);
    public static final ContagiousPoison contagios_potion = new ContagiousPoison("Contagious", 1, true);

    public static final ICBMCreativeTab CREATIVE_TAB = new ICBMCreativeTab(ICBMConstants.DOMAIN);

    //public static ModFixs modFixs;

    public ICBMClassic() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /*
    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        if (ConfigItems.ENABLE_CRAFTING_ITEMS)
        {
            if (ConfigItems.ENABLE_INGOTS_ITEMS)
            {
                //Steel clump -> Steel ingot
                //GameRegistry.addSmelting(new ItemStack(ItemReg.itemIngotClump, 1, 0), new ItemStack(ItemReg.itemIngot, 1, 0), 0.1f);
            }

            if (ConfigItems.ENABLE_PLATES_ITEMS)
            {
                //Fix for removing recipe of plate
                //GameRegistry.addSmelting(ItemReg.itemPlate.getStack("iron", 1), new ItemStack(Items.IRON_INGOT), 0f);
            }
        }
    }
    */

    // TODO replace all of this with modern technique https://mcforge.readthedocs.io/en/1.16.x/items/globallootmodifiers/
    @SubscribeEvent
    public void registerLoot(LootTableLoadEvent event)
    {
        ///setblock ~ ~ ~ minecraft:chest 0 replace {LootTable:"minecraft:chests/simple_dungeon"}
        /*
        final String VANILLA_LOOT_POOL_ID = "main";
        if (event.getName().equals(LootTables.CHESTS_ABANDONED_MINESHAFT) || event.getName().equals(LootTables.CHESTS_SIMPLE_DUNGEON))
        {
            if (ConfigItems.ENABLE_LOOT_DROPS)
            {
                LootPool lootPool = event.getTable().getPool(VANILLA_LOOT_POOL_ID);
                if (lootPool != null && ConfigItems.ENABLE_CRAFTING_ITEMS)
                {

                    if (ConfigItems.ENABLE_INGOTS_ITEMS)
                    {
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "ingot.copper", ItemReg.itemIngot.getStack("copper", 10), 15, 5));
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "ingot.steel", ItemReg.itemIngot.getStack("steel", 10), 20, 3));
                    }
                    if (ConfigItems.ENABLE_PLATES_ITEMS)
                    {
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "plate.steel", ItemReg.itemPlate.getStack("steel", 5), 30, 3));
                    }
                    if (ConfigItems.ENABLE_WIRES_ITEMS)
                    {
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "wire.copper", ItemReg.itemWire.getStack("copper", 20), 15, 5));
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "wire.gold", ItemReg.itemWire.getStack("gold", 15), 30, 3));
                    }
                    if (ConfigItems.ENABLE_CIRCUIT_ITEMS)
                    {
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "circuit.basic", ItemReg.itemCircuit.getStack("basic", 15), 15, 5));
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "circuit.advanced", ItemReg.itemCircuit.getStack("advanced", 11), 30, 3));
                        lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "circuit.elite", ItemReg.itemCircuit.getStack("elite", 8), 30, 3));
                    }
                }
            }
        }
        else if (event.getName().equals(LootTables.ENTITIES_CREEPER))
        {
            if (ConfigItems.ENABLE_SULFUR_LOOT_DROPS)
            {
                LootPool lootPool = event.getTable().getPool(VANILLA_LOOT_POOL_ID);
                if (lootPool != null)
                {
                    lootPool.addEntry(new LootEntryItemStack(ICBMConstants.PREFIX + "sulfur", new ItemStack(ItemReg.itemSulfurDust, 10, 0), 2, 0));
                }
            }
        }
        */
    }

    /* //TODO Rework to match new Forge lifecycle
    @SubscribeEvent
    public void preInit(FMLPreInitializationEvent event)
    {
        //Verify that our nbt tag strings are distinct. If this fails then this will crash Minecraft!
        NBTConstants.ensureThatAllTagNamesAreDistinct();

        proxy.preInit();
        EnergySystem.register(new EnergySystemFE());

        //Register caps
        CapabilityEMP.register();
        CapabilityMissile.register();
        CapabilityExplosive.register();

        //Register data fixers
        modFixs = FMLCommonHandler.instance().getDataFixer().init(ICBMConstants.DOMAIN, 1);
        modFixs.registerFix(FixTypes.ENTITY, new EntityExplosiveDataFixer());
        modFixs.registerFix(FixTypes.ENTITY, new EntityGrenadeDataFixer());
        modFixs.registerFix(FixTypes.BLOCK_ENTITY, new TileExplosivesDataFixer());
        modFixs.registerFix(FixTypes.BLOCK_ENTITY, new TileRadarStationDataFixer());

        MinecraftForge.EVENT_BUS.register(RadarRegistry.INSTANCE);
        MinecraftForge.EVENT_BUS.register(RadioRegistry.INSTANCE);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

        handleExRegistry(event.getModConfigurationDirectory());
    }
    */

    private void handleExRegistry(File configMainFolder)
    {
        //Init registry
        final ExplosiveRegistry explosiveRegistry = new ExplosiveRegistry();
        ICBMClassicAPI.EXPLOSIVE_REGISTRY = explosiveRegistry;

        ICBMClassicAPI.EX_BLOCK_REGISTRY = new ExBlockContentReg();
        ICBMClassicAPI.EX_GRENADE_REGISTRY = new ExGrenadeContentReg();
        ICBMClassicAPI.EX_MINECART_REGISTRY = new ExMinecartContentReg();
        ICBMClassicAPI.EX_MISSILE_REGISTRY = new ExMissileContentReg();

        //Load data
        explosiveRegistry.loadReg(new File(configMainFolder, "icbmclassic/explosive_reg.json"));

        //Register default content types
        explosiveRegistry.registerContentRegistry(ICBMClassicAPI.EX_BLOCK_REGISTRY);
        explosiveRegistry.registerContentRegistry(ICBMClassicAPI.EX_GRENADE_REGISTRY);
        explosiveRegistry.registerContentRegistry(ICBMClassicAPI.EX_MISSILE_REGISTRY);
        explosiveRegistry.registerContentRegistry(ICBMClassicAPI.EX_MINECART_REGISTRY);

        //Fire registry events for content types
        //TODO//MinecraftForge.EVENT_BUS.post(new ExplosiveContentRegistryEvent(explosiveRegistry));

        //Lock content types, done to prevent errors with adding content
        explosiveRegistry.lockNewContentTypes();

        //Register internal first to reserve slots for backwards compatibility
        ExplosiveInit.init();

        //Fire registry event for explosives
        //TODO//MinecraftForge.EVENT_BUS.post(new ExplosiveRegistryEvent(explosiveRegistry));
        explosiveRegistry.lockNewExplosives();

        //Do default content types per explosive
        explosiveRegistry.getExplosives().stream().filter(ex -> ex.getTier() != EnumTier.NONE).forEach(ex -> ICBMClassicAPI.EX_BLOCK_REGISTRY.enableContent(ex.getRegistryName()));
        explosiveRegistry.getExplosives().stream().filter(ex -> ex.getTier() != EnumTier.NONE).forEach(ex -> ICBMClassicAPI.EX_MISSILE_REGISTRY.enableContent(ex.getRegistryName()));
        explosiveRegistry.getExplosives().stream().filter(ex -> ex.getTier() != EnumTier.NONE).forEach(ex -> ICBMClassicAPI.EX_MINECART_REGISTRY.enableContent(ex.getRegistryName()));
        explosiveRegistry.getExplosives().stream().filter(ex -> ex.getTier() == EnumTier.ONE).forEach(ex -> ICBMClassicAPI.EX_GRENADE_REGISTRY.enableContent(ex.getRegistryName()));
        //TODO configs to disable types per explosive
        //TODO mesh mapper to match model to state

        //Lock all registry, done to prevent errors in data generation for renders and content
        explosiveRegistry.completeLock();

        //Save registry, at this point everything should be registered
        explosiveRegistry.saveReg();
    }

    /**
     * This is the first of four commonly called events during mod initialization.
     *
     * Called before {@link FMLClientSetupEvent} or {@link FMLDedicatedServerSetupEvent} during mod startup.
     *
     * Called after {@link net.minecraftforge.event.RegistryEvent.Register} events have been fired.
     *
     * Either register your listener using {@link net.minecraftforge.fml.AutomaticEventSubscriber} and
     * {@link net.minecraftforge.eventbus.api.SubscribeEvent} or
     * {@link net.minecraftforge.eventbus.api.IEventBus#addListener(Consumer)} in your constructor.
     *
     * Most non-specific mod setup will be performed here. Note that this is a parallel dispatched event - you cannot
     * interact with game state in this event.
     *
     * @see net.minecraftforge.fml.DeferredWorkQueue to enqueue work to run on the main game thread after this event has
     * completed dispatch
     */
    @SubscribeEvent
    public void init(FMLCommonSetupEvent event)
    {
        proxy.init();
        packetHandler.init();
        CREATIVE_TAB.init();

        if (ConfigItems.ENABLE_CRAFTING_ITEMS)
        {
            if (ConfigItems.ENABLE_INGOTS_ITEMS)
            {
                ItemReg.itemIngot.registerOreNames();
            }

            if (ConfigItems.ENABLE_PLATES_ITEMS)
            {
                ItemReg.itemPlate.registerOreNames("iron");
            }

            if (ConfigItems.ENABLE_CIRCUIT_ITEMS)
            {
                ItemReg.itemCircuit.registerOreNames();
            }

            if (ConfigItems.ENABLE_WIRES_ITEMS)
            {
                ItemReg.itemWire.registerOreNames();
            }
        }

        //TODO//OreDictionary.registerOre("dustSulfur", new ItemStack(ItemReg.itemSulfurDust));
        //TODO//OreDictionary.registerOre("dustSaltpeter", new ItemStack(ItemReg.itemSaltpeterDust));

        /** Potion Effects */ //TODO move to effect system
        //TODO//PoisonToxin.INSTANCE = Effects.POISON;//new PoisonToxin(true, 5149489, "toxin");
        //TODO//PoisonContagion.INSTANCE = Effects.POISON;//new PoisonContagion(false, 5149489, "virus");
        //TODO//PoisonFrostBite.INSTANCE = Effects.POISON;//new PoisonFrostBite(false, 5149489, "frostBite");

        /** Dispenser Handler */
        if (ItemReg.itemGrenade != null)
        {
            DispenserBlock.registerDispenseBehavior(ItemReg.itemGrenade, new GrenadeDispenseBehavior());
        }

        if (ItemReg.itemBombCart != null)
        {
            DispenserBlock.registerDispenseBehavior(ItemReg.itemBombCart, new BombCartDispenseBehavior());
        }
        proxy.init();
    }

    /*
    @SubscribeEvent
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
    */

    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event)
    {
        /*
        //Get command manager
        ICommandManager commandManager = FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager();
        ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager);

        //Setup commands
        ICBMCommands.init();

        //Register main command
        serverCommandManager.registerCommand(new CommandEntryPoint("icbm", ICBMCommands.ICBM_COMMAND));
        */

        WorkerThreadManager.INSTANCE = new WorkerThreadManager(ConfigThread.THREAD_COUNT);
        WorkerThreadManager.INSTANCE.startThreads();
    }

    @SubscribeEvent
    public void serverStopping(FMLServerStoppingEvent event)
    {
        WorkerThreadManager.INSTANCE.killThreads();
    }

}
