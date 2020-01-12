package reirokusanami.items.vaultitems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class itemClockworkGear extends Item {
    private static final String description =
            "It was like a gear used in fine watchmaking." + "\n" +
            "But is this just a gear?" + "\n" +
            "I feel strange and the sense of time is distorted...";

    public itemClockworkGear() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("clockworkgear");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_PURPLE + description);
    }
}
