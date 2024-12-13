package net.forist.mccourse.datagen;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(ModItems.ALEXANDRITE.get());
        basicItem(ModItems.RAW_ALEXANDRITE.get());

        basicItem(ModItems.URIEL_MOCHI.get());
        basicItem(ModItems.LEVINA_MOCHI.get());
        basicItem(ModItems.HANNAH_MOCHI.get());

        basicItem(ModItems.METAL_DETECTOR.get());
        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.PEAT_BRICK.get());
    }
}
