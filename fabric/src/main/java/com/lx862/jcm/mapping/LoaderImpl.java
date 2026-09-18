package com.lx862.jcm.mapping;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.mtr.mapping.holder.BlockSettings;

/**
 * Fabric implementation via official Mojang mappings
 */
public class LoaderImpl {
	public static boolean isRainingAt(org.mtr.mapping.holder.World world, org.mtr.mapping.holder.BlockPos pos) {
		return ((Level) world.data).isRainingAt((BlockPos) pos.data);
	}

	/** Get a block settings forcing it to be solid, as we don't want water to break our block. */
	public static BlockSettings getSolidBlockSettings(BlockSettings settings) {
		return new BlockSettings(((BlockBehaviour.Properties) settings.data).forceSolidOn());
	}
}
