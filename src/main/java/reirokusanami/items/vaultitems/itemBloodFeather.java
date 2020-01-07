package reirokusanami.items.vaultitems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class itemBloodFeather extends Item {
    private static final String description =
            "The wings, shaped by blood, deliver a determined death according to the user's wishes.";
    public itemBloodFeather() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("bloodfeather");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_PURPLE + description);
    }
}
