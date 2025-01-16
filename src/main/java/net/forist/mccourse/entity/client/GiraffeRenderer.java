package net.forist.mccourse.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.entity.custom.GiraffeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GiraffeRenderer extends MobRenderer<GiraffeEntity, GiraffeModel<GiraffeEntity>> {
    public GiraffeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GiraffeModel<>(pContext.bakeLayer(ModModelLayers.GIRAFFE)), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(GiraffeEntity pEntity) {
        if(pEntity.isSaddled()) {
            return ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/giraffe/giraffe_saddled.png");
        } else {
            return ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/giraffe/giraffe.png");
        }
    }

    @Override
    public void render(GiraffeEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.55f, 0.45f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
