package reirokusanami.items.register;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import reirokusanami.CorruptedModifiers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaultMiscItemRegister {
    private static final List<Item> ITEMS = new ArrayList<>();

    public static Item RegisterItems(String name, int stackNum, IForgeRegistry<Item> event) {
        Item item = new Item();
        item.setUnlocalizedName(name);
        item.setMaxStackSize(stackNum);
        item.setRegistryName(new ResourceLocation(CorruptedModifiers.MODID, item.getUnlocalizedName().substring(5)));
        event.register(item);
        ITEMS.add(item);

        return item;
    }

    public static List<Item> getVaultItems() { return Collections.unmodifiableList(ITEMS); }
}
