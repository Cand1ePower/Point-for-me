package cdpw.pfm;

import cdpw.pfm.client.KeyBindHandler;
import cdpw.pfm.client.GuiKeyBindHandler;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PointForMeClient implements ClientModInitializer {

    public static final String MOD_ID = "point-for-me";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("pointForMECLIENT OKKKKKKKKKKKKK");
        KeyBindHandler.register();
        GuiKeyBindHandler.register();
    }

}
