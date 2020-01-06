package reirokusanami.items.vaultitems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import reirokusanami.CorruptedModifiers;

import javax.annotation.Nullable;
import java.util.List;

public class itemGlassWhetstone extends Item {
    private final String description =
            "This whetstone is made of glass." + "\n" +
            "Normally, the material is not sharpened, but it can be brittle and sharpened to cut everything." + "\n" +
            "Who on earth made such a thing...";
    public itemGlassWhetstone() {
        super();
        this.setUnlocalizedName("glasswhetstone");
        this.setMaxStackSize(16);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_PURPLE + description);
    }
}