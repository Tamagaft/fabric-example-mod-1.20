package net.tamagaft.testmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.TestMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GemPolishingScreenHandler> GEM_POLISHING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TestMod.MOD_ID, "gem_polishing"),
                    new ExtendedScreenHandlerType<>(GemPolishingScreenHandler::new));

    public static void registerScreenHandler(){
        TestMod.LOGGER.info("Registering Screen Handler for " + TestMod.MOD_ID);
    }
}
