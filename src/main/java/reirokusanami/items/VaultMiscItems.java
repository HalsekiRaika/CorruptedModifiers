package reirokusanami.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import reirokusanami.items.register.VaultMiscItemRegister;

public class VaultMiscItems {
    public static Item itemCrystalCluster;

    public static void InitializationMiscItems(IForgeRegistry<Item> event) {
        //itemCrystalCluster = VaultMiscItemRegister.RegisterItems("crystalcluster", 64, event);
    }
}
