package reirokusanami;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import reirokusanami.items.VaultMiscItems;
import reirokusanami.items.register.VaultItemRegister;
import reirokusanami.items.register.VaultMiscItemRegister;
import reirokusanami.items.vaultitems.VaultItems;
import reirokusanami.modifiers.register.VaultModifierRegister;
import slimeknights.tconstruct.common.ModelRegisterUtil;

@Mod(modid = CorruptedModifiers.MODID, name = CorruptedModifiers.MODNAME, version = CorruptedModifiers.VERSION, dependencies = CorruptedModifiers.DEPENDENCIES)
public class CorruptedModifiers {
    public static final String MODID = "vaultmod";
    public static final String MODNAME = "CorruptedModifiers";
    public static final String VERSION = "0.1.0";
    public static final String DEPENDENCIES =
            "required-after:mantle;" +
            "required-after:tconstruct@[1.12.2-2.12.0.135,);" +
            "required-after:forge@[14.23.5.2836,);";
    public static Logger logger;

    @Instance(CorruptedModifiers.MODID)
    public static CorruptedModifiers instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Initialization [CorruptedModifiers]");
    }

    @EventHandler
    public void construct(FMLConstructionEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void register(RegistryEvent.Register<Item> event) {
        VaultMiscItems.InitializationMiscItems(event.getRegistry());
        VaultItems.InitializationItems(event.getRegistry());
        VaultModifierRegister.setupModifier();
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        VaultMiscItemRegister.getVaultItems().forEach(item -> ModelRegisterUtil.registerItemModel(item));
        VaultItemRegister.getItems().forEach(item -> ModelRegisterUtil.registerItemModel(item));
    }
}
