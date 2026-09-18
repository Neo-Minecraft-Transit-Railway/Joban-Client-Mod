package com.lx862.jcm.mod;

import com.lx862.jcm.mod.registry.JCMRegistry;
import com.lx862.jcm.mod.util.JCMLogger;
import org.mtr.mod.Keys;

public class JCM {
    public static void initialize() {
        try {
            JCMLogger.info("Joban Client Mod v{} @ MTR {}", Constants.MOD_VERSION, Keys.class.getField("MOD_VERSION").get(null));
        } catch (Exception e) {
            JCMLogger.warn("Cannot obtain MTR Version, countdown to disaster...");
        }
        // Fabric may run jsblock's main entrypoint before mtr's. APGDoorDRL's
        // constructor then loads org.mtr.mod.Blocks, whose nested registerBlock
        // would clear PENDING_BLOCK_ID and crash 1.21.11 with "Block id not set".
        try {
            Class.forName("org.mtr.mod.Blocks");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        JCMRegistry.register();
    }
}