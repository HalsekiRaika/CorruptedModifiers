package reirokusanami.modifiers;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ProjectileNBT;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModHeavyCaliber extends ToolModifier {
    private final int max;
    public ModHeavyCaliber(int max) {
        super("heavycaliber", 0xc78000);
        this.max = max;
        addAspects(new ModifierAspect.MultiAspect(this, 10, max, 1));
    }

    @Override
    public void applyEffect(NBTTagCompound rootTag, NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        ToolNBT toolDataOrigin = TagUtil.getOriginalToolStats(rootTag);
        ProjectileNBT DataOrigin = new ProjectileNBT(TagUtil.getToolTag(rootTag));
        float accuracy = DataOrigin.accuracy;
        float attack = toolDataOrigin.attack;
        int level = data.current / max;
        for (int count = data.current; count > 0; count--) {
            if (attack <= 3f) {
                accuracy -= 0.017f;
                attack += 0.50f - 0.20f * attack / 10f;
            } else if (attack <= 2f) {
                accuracy -= 0.016f;
                attack += 0.30f - 0.2f * attack / 20f;
            } else {
                accuracy -= 0.014f;
                attack += 0.20f;
            }
        }

        attack += level * 0.25f;
        //accuracy -= accuracy - (level * 0.02);

        NBTTagCompound tag = TagUtil.getToolTag(rootTag);
        attack -= toolDataOrigin.attack;
        attack += tag.getFloat(Tags.ATTACK);
        accuracy -= DataOrigin.accuracy;
        accuracy += tag.getFloat(Tags.ACCURACY);
        if (!(accuracy <= 0.001f)){
            tag.setFloat(Tags.ACCURACY, accuracy);
        } else {
            tag.setFloat(Tags.ACCURACY, 0.001f);
        }
        tag.setFloat(Tags.ATTACK, attack);
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        return super.getTooltip(modifierTag, detailed);
    }
}