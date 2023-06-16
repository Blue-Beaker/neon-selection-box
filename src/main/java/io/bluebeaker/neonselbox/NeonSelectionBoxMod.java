package io.bluebeaker.neonselbox;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod("neonselbox")
public class NeonSelectionBoxMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "neonselbox";
    public NeonSelectionBoxMod() {
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(Type.CLIENT, ConfigRegistry.CLIENT_CONFIG);
    }
}
