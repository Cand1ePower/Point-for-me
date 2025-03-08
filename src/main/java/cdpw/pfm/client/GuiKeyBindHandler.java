package cdpw.pfm.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import java.lang.reflect.Field;

public class GuiKeyBindHandler {
    private static int tickCounter = 0; // 计时器

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.currentScreen instanceof HandledScreen<?>) {
                HandledScreen<?> screen = (HandledScreen<?>) client.currentScreen;
                if (tickCounter >= 30) {
                    tickCounter = 0; // 重置计时器

                    ScreenMouseEvents.allowMouseClick(screen).register((_screen, mouseX, mouseY, button) -> {
                        if (button == 2) {
                            try {
                                // 使用反射获取 focusedSlot 字段
                                Field focusedSlotField = HandledScreen.class.getDeclaredField("focusedSlot");
                                focusedSlotField.setAccessible(true); // 允许访问私有字段
                                Slot slot = (Slot) focusedSlotField.get(screen);

                                if (slot != null && slot.hasStack()) {
                                    ItemStack itemStack = slot.getStack();
                                    int slotIndex = slot.id;
                                    System.out.println("Clicked on item: " + itemStack.getName().getString());
                                    System.out.println("Slot index: " + slotIndex);
                                    System.out.println("Item count: " + itemStack.getCount());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return true; // 允许事件继续传播
                    });
                } else {
                    tickCounter++;
                }
            }
        });
    }
}
