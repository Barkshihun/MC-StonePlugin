package io.github.barkshihun;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("Enable Plugin");
    getCommand("stone").setExecutor(new CustomCommand());
  }

  @Override
  public void onDisable() {
    getLogger().info("Disable Plugin");
  }
}
