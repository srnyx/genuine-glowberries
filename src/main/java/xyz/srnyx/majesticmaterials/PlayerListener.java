package xyz.srnyx.majesticmaterials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;
import xyz.srnyx.annoyingapi.AnnoyingPlugin;


public class PlayerListener extends AnnoyingListener {
    @NotNull private final MajesticMaterials plugin;

    public PlayerListener(@NotNull MajesticMaterials plugin) {
        this.plugin = plugin;
    }

    @Override @NotNull
    public AnnoyingPlugin getAnnoyingPlugin() {
        return plugin;
    }

    @EventHandler
    public void onPlayerItemConsume(@NotNull PlayerItemConsumeEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPermission("majestic.use")) return;
        final PotionEffect effect = plugin.effects.get(event.getItem().getType());
        if (effect != null) player.addPotionEffect(effect);
    }
}
