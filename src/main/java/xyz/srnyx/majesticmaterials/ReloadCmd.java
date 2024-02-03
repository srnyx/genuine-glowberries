package xyz.srnyx.majesticmaterials;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;
import xyz.srnyx.annoyingapi.command.AnnoyingCommand;
import xyz.srnyx.annoyingapi.command.AnnoyingSender;
import xyz.srnyx.annoyingapi.message.AnnoyingMessage;


public class ReloadCmd extends AnnoyingCommand {
    @NotNull private final MajesticMaterials plugin;

    public ReloadCmd(@NotNull MajesticMaterials plugin) {
        this.plugin = plugin;
    }

    @Override @NotNull
    public AnnoyingPlugin getAnnoyingPlugin() {
        return plugin;
    }

    @Override @NotNull
    public String getName() {
        return "majesticreload";
    }

    @Override @NotNull
    public String getPermission() {
        return "majestic.reload";
    }

    @Override
    public void onCommand(@NotNull AnnoyingSender sender) {
        plugin.reloadPlugin();
        new AnnoyingMessage(plugin, "reload").send(sender);
    }
}
