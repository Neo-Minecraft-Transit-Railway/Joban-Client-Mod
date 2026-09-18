package com.lx862.jcm.mapping;

import org.mtr.mapping.holder.MinecraftClient;
import org.mtr.mapping.holder.Screen;
import org.mtr.mapping.holder.Util;
import org.mtr.mapping.mapper.ScreenExtension;

/**
 * Fabric implementation via official Mojang mappings
 */
public class LoaderImplClient {

	public static void openURLScreen(ScreenExtension parentScreen, String url) {
		MinecraftClient mc = MinecraftClient.getInstance();
		mc.openScreen(
				new Screen(new net.minecraft.client.gui.screens.ConfirmLinkScreen((confirmed) -> {
					if (confirmed) {
						Util.getOperatingSystem().open(url);
					}
					mc.openScreen(new Screen(parentScreen));
				}, url, true))
		);
	}
}
