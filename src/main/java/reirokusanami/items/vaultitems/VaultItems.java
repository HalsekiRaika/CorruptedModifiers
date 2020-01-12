package reirokusanami.items.vaultitems;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import reirokusanami.items.register.VaultItemRegister;

public class VaultItems {
    public static Item itemGlassWhetStone;
    public static Item itemBloodfeather;
    public static Item itemClockWorkGear;

    public static void InitializationItems(IForgeRegistry<Item> event) {
        itemGlassWhetStone = VaultItemRegister.registerItem(new itemGlassWhetstone(), event);
        itemBloodfeather   = VaultItemRegister.registerItem(new itemBloodFeather(),   event);
        itemClockWorkGear  = VaultItemRegister.registerItem(new itemClockworkGear(),  event);
    }
}
