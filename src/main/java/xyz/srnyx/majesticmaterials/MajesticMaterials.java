package xyz.srnyx.majesticmaterials;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.potion.PotionEffect;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;
import xyz.srnyx.annoyingapi.PluginPlatform;
import xyz.srnyx.annoyingapi.file.AnnoyingResource;

import java.util.EnumMap;
import java.util.Map;


public class MajesticMaterials extends AnnoyingPlugin {
    @NotNull private final AnnoyingResource config = new AnnoyingResource(this, "config.yml");
    @NotNull public Map<Material, PotionEffect> effects = new EnumMap<>(Material.class);

    public MajesticMaterials() {
        options
                .pluginOptions(pluginOptions -> pluginOptions.updatePlatforms(
                        PluginPlatform.modrinth("majestic-materials"),
                        PluginPlatform.hangar(this, "srnyx"),
                        PluginPlatform.spigot("123456")))
                .bStatsOptions(bStats -> bStats.id(20888))
                .registrationOptions.toRegister(this,
                        PlayerListener.class,
                        ReloadCmd.class);

        reload();
    }

    @Override
    public void reload() {
        effects = new EnumMap<>(Material.class);
        final ConfigurationSection section = config.getConfigurationSection("materials");
        if (section != null) for (final String materialName : section.getKeys(false)) {
            final Material material = Material.getMaterial(materialName);
            if (material == null || !material.isEdible()) continue;
            final PotionEffect effect = config.getPotionEffect("materials." + materialName);
            if (effect != null) effects.put(material, effect);
        }
    }
}
