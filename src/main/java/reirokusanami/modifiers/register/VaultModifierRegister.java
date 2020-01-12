package reirokusanami.modifiers.register;

import reirokusanami.modifiers.ModDoubleEdges;
import reirokusanami.modifiers.ModHeavyCaliber;
import reirokusanami.modifiers.ModInfestedQuiver;
import slimeknights.tconstruct.library.modifiers.Modifier;

import static reirokusanami.items.vaultitems.VaultItems.*;

public class VaultModifierRegister {
    public static Modifier modDoubleEdges;
    public static Modifier modHeavyCaliber;
    public static Modifier modInfestedQuiver;

    public static void setupModifier() {
        // -- Modifier: DoubleEdges
        modDoubleEdges = new ModDoubleEdges(75);
        modDoubleEdges.addItem(itemGlassWhetStone);

        // -- Modifier: HeavyCaliber
        modHeavyCaliber = new ModHeavyCaliber(45);
        modHeavyCaliber.addItem(itemBloodfeather);

        // -- Modifier: InfestedQuiver
        modInfestedQuiver = new ModInfestedQuiver(75);
        modInfestedQuiver.addItem(itemClockWorkGear);
    }
}
