package reirokusanami.items.vaultitems;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import reirokusanami.items.register.VaultItemRegister;

public class InitializationItems {
    public static Item itemGlassWhetStone;

    public static void Init(IForgeRegistry<Item> event) {
        itemGlassWhetStone = VaultItemRegister.registerItem(new itemGlassWhetstone(), event);
    }
}
