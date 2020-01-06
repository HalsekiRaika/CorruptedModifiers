package reirokusanami.modifiers.register;

import reirokusanami.modifiers.ModDoubleEdges;
import slimeknights.tconstruct.library.modifiers.Modifier;

import static reirokusanami.items.vaultitems.InitializationItems.itemGlassWhetStone;

public class VaultModifierRegister {
    public static Modifier modDoubleEdges;

    public static void setupModifier() {
        modDoubleEdges = new ModDoubleEdges(1);
        modDoubleEdges.addItem(itemGlassWhetStone);
    }
}
