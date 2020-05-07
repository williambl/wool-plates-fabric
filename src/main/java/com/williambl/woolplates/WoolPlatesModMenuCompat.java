package com.williambl.woolplates;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class WoolPlatesModMenuCompat implements ModMenuApi {
    @Override
    public String getModId() {
        return WoolPlates.MODID;
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> (Screen) AutoConfig.getConfigScreen(WoolPlatesConfig.class, screen).get();
    }

}
