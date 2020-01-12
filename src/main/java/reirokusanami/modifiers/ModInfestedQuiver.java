package reirokusanami.modifiers;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT;
import slimeknights.tconstruct.library.tools.ProjectileNBT;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.AmmoHelper;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;
import slimeknights.tconstruct.tools.ranged.TinkerRangedWeapons;

import java.util.List;

public class ModInfestedQuiver extends ToolModifier {
    private final int max;
    private static int level = 0;
    private static int bowlevel = 0;

    public ModInfestedQuiver(int max) {
        super("infectedquiver", 0xffffff);
        this.max = max;
        MinecraftForge.EVENT_BUS.register(this);
        addAspects(ModifierAspect.projectileOnly,
               new ModifierAspect.MultiAspect(this, 10, max, 1));
    }

    @SubscribeEvent
    public void EventCatch(ArrowNockEvent event) {
        ItemStack bow = event.getBow();
        if (isProjectileLauncher(bow)){
            NBTTagCompound bowData = TagUtil.getToolTag(bow);
            //ToolNBT bowOrigin = TagUtil.getOriginalToolStats(bowData);
            if (TagUtil.getModifiersTagList(AmmoHelper.findAmmoFromInventory(getAmmoItems(), event.getEntityPlayer())).toString().contains("infestedquiver")) {
                if (!(bowData.getBoolean("infected"))) {
                    bowData.setFloat(Tags.DRAWSPEED, linkEffect(bowData));
                }
            }
        }
    }

    private ImmutableList<Item> AmmoMatches = null;

    private List<Item> getAmmoItems() {
        if(AmmoMatches == null) {
            ImmutableList.Builder<Item> builder = ImmutableList.builder();
            if(TinkerRangedWeapons.bolt != null) {
                builder.add(TinkerRangedWeapons.bolt);
                builder.add(TinkerRangedWeapons.arrow);
            }
            AmmoMatches = builder.build();
        }
        return AmmoMatches;
    }

    @Override
    public void applyEffect(NBTTagCompound rootTag, NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        ToolNBT toolDataOrigin = TagUtil.getOriginalToolStats(rootTag);
        ProjectileNBT dataOrigin = new ProjectileNBT(TagUtil.getToolTag(rootTag));
        int durability = dataOrigin.durability;
        for (int count = data.current; count > 0; count--){
            if (durability <= 500){
                durability += 450;
            } else if (durability <= 700) {
                durability += 350;
            } else {
                durability += 200;
            }
        }

        NBTTagCompound tag = TagUtil.getToolTag(rootTag);
        durability -= toolDataOrigin.durability;
        durability += tag.getInteger(Tags.DURABILITY);
        //tag.setInteger("infectionlevel", 1);
        tag.setInteger(Tags.DURABILITY, durability);
    }

    public float linkEffect(NBTTagCompound rootTag) {
        //ModifierNBT.IntegerNBT linkData = ModifierNBT.readInteger(modifierTag);
        ProjectileLauncherNBT launcherData = new ProjectileLauncherNBT(rootTag);
        float drawSpeed = launcherData.drawSpeed;
        for (int count = max; count > 0; count--){
            if (drawSpeed <= 3.5f) {
                drawSpeed -= 0.003f;
            } else if (drawSpeed <= 2.7f) {
                drawSpeed -= 0.002f;
            } else {
                drawSpeed -= 0.0015f;
            }
        }
        drawSpeed += launcherData.drawSpeed;
        drawSpeed -= rootTag.getFloat(Tags.DRAWSPEED);
        if (!(drawSpeed <= 0.2f)) {
            float infestedDrawSpeed = drawSpeed;
            //rootTag.setInteger("infectionlevel");
            return infestedDrawSpeed;
        } else {
            drawSpeed = 0.3f;
            rootTag.setBoolean("infected", true);
            return drawSpeed;
        }
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        return super.getTooltip(modifierTag, detailed);
    }

    private boolean isProjectileLauncher(ItemStack itemStack){
        if (itemStack.getUnlocalizedName().contains("crossbow")
         || itemStack.getUnlocalizedName().contains("shortbow")
         || itemStack.getUnlocalizedName().contains("longbow")){
            return true;
        }
        return false;
    }

}
