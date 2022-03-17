package me.benjamin.chatblock;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final ChatBlock main;

    public ChatListener (ChatBlock cb){ this.main = cb; }

    @EventHandler
    public void onChat (AsyncPlayerChatEvent e){
        String permission = main.getConfig().getString("permission");
        if(e.getPlayer().hasPermission(permission != null ? permission : "chatblock.disable")) return;
        for (char c : main.getConfig().getCharacterList("char-list"))
            if(e.getMessage().contains(new StringBuilder(1).append(c))){
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_RED + main.getConfig().getString("error-message"));
                return;
            }
    }
}

