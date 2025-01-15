package net.forist.mccourse.worldgen.tree;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BALSA = new TreeGrower(MCCourseMod.MOD_ID + ":balsa",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BALSA_KEY), Optional.empty());
}
