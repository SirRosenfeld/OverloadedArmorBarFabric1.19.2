/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfar.overpoweredarmorbar.mixins;

import com.mojang.math.Matrix4f;
import net.minecraft.client.gui.GuiComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.overpoweredarmorbar.OverloadedArmorBar;

/**
 *
 * @author gbl
 */
@Mixin(GuiComponent.class)
public class DrawableHelperMixin {
    @Inject(method="innerBlit(Lcom/mojang/math/Matrix4f;IIIIIFFFF)V", at=@At("HEAD"), cancellable = true)
    private static void checkDrawSuppressed(Matrix4f matrices, int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1, CallbackInfo ci) {
        if (OverloadedArmorBar.drawTextureSuppressed) {
            ci.cancel();
        }
    }
}
