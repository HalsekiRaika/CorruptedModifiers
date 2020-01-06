package reirokusanami.items.register;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import reirokusanami.CorruptedModifiers;
import reirokusanami.items.vaultitems.itemGlassWhetstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaultItemRegister {
    private static final List<Item> ITEMS = new ArrayList<>();

    public static Item registerItem(Item targetItem, IForgeRegistry<Item> event) {
        targetItem.setRegistryName(new ResourceLocation(CorruptedModifiers.MODID, targetItem.getUnlocalizedName().substring(5)));
        event.register(targetItem);
        ITEMS.add(targetItem);

        return targetItem;
    }

    public static List<Item> getItems() { return Collections.unmodifiableList(ITEMS); }
}
