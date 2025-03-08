package cdpw.pfm.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyBindHandler {

    public static final String MOD_ID = "point-for-me";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static final KeyBinding MARK_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.point-for-me.mark",
            InputUtil.Type.MOUSE,
            GLFW.GLFW_MOUSE_BUTTON_MIDDLE,
            "category.point-for-me"
    ));

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (MARK_KEY.wasPressed()) {
                System.out.println("中键");
            }
        });
    }
}
