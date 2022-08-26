package io.github.magicquartz.environmentalarmor.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class GlassBowlItem extends Item {
    private final Item filled;
    
    public GlassBowlItem(Settings settings, Item filled) {
        super(settings);
        this.filled = filled;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        BlockHitResult blockHit = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if(blockHit.getType().equals(HitResult.Type.BLOCK)) {
            BlockPos pos = blockHit.getBlockPos();
            if (world.canPlayerModifyAt(user, pos)) {
                BlockState state = world.getBlockState(pos);
                if (world.getFluidState(pos).isOf(Fluids.WATER) &&
                    state.getBlock() instanceof FluidDrainable drainable &&
                    !drainable.tryDrainFluid(world, pos, state).isEmpty()
                ) {
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    drainable.getBucketFillSound().ifPresent((sound) -> user.playSound(sound, 1.0F, 1.0F));
                    world.emitGameEvent(user, GameEvent.FLUID_PICKUP, pos);
                    return TypedActionResult.success(filled.getDefaultStack(), world.isClient);
                }
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    
}