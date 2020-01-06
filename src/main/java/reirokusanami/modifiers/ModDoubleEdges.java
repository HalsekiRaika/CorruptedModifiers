package reirokusanami.modifiers;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModDoubleEdges extends ToolModifier {
    private final int max;
    public ModDoubleEdges(int max){
        super("doubleedges", 0xf5001a);
        this.max = max;
        addAspects(new ModifierAspect.DataAspect(this), new ModifierAspect.MultiAspect(this, 5, max, 1));
    }

    @Override
    public void applyEffect(NBTTagCompound rootTag, NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        ToolNBT toolDataOrigin = TagUtil.getOriginalToolStats(rootTag);
        ToolNBT toolData = TagUtil.getToolStats(rootTag);
        float attack = toolDataOrigin.attack;
        int durability = toolData.durability;
        int level = data.current / max;
        for (int count = data.current; count > 0; count--){
            if(attack <= 5f) {
                durability -= 50;
                attack += 0.5f - 0.25f * attack / 10f;
            } else if (attack <= 2f) {
                durability -= 30;
                attack += 0.25f - 0.1 * attack / 20f;
            } else {
                durability -= 20;
                attack += 0.15;
            }
        }

        attack += level * 0.25f;

        NBTTagCompound tag = TagUtil.getToolTag(rootTag);
        attack -= toolDataOrigin.attack;
        attack += tag.getFloat(Tags.ATTACK);
        durability -= toolData.durability;
        durability += tag.getInteger(Tags.DURABILITY);
        if (!(durability <= 1)){
            tag.setInteger(Tags.DURABILITY, durability);
            tag.setFloat(Tags.ATTACK, attack);
        } else {
            tag.setInteger(Tags.DURABILITY, 1);
            tag.setFloat(Tags.ATTACK, attack);
        }
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        return super.getTooltip(modifierTag, detailed);
    }
}
