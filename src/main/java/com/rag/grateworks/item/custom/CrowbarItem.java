package com.rag.grateworks.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class CrowbarItem extends Item {
    public CrowbarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockState state =  world.getBlockState(context.getBlockPos());
        Block clickedBLock = state.getBlock();

        if(Blocks.STONE == clickedBLock) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), Blocks.BRICKS.getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS);
                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS);
            }
        } else if (Blocks.IRON_DOOR == clickedBLock) {
            if (!world.isClient()) {
                if (state.get(DoorBlock.OPEN).equals(false)) {
                    world.setBlockState(context.getBlockPos(), state.with(DoorBlock.OPEN, true));

                    context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                            item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                    world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS);
                    world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS);
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}