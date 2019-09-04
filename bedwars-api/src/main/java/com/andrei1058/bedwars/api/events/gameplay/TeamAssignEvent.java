package com.andrei1058.bedwars.api.events.gameplay;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TeamAssignEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private ITeam team;
    private IArena arena;
    private boolean cancelled = false;

    /**
     * Called for each player when the waiting countdown == 0
     * You can cancel each team assign event in order to manage them yourself
     * but make sure to set BedWarsTeam#setBedDestroyed(false) if teams are marked as eliminated when they are not,
     * and use BedWarsTeam#firstSpawn(p) to spawn them. But first assign them to a team BedWarsTeam#addPlayers(p)
     */
    public TeamAssignEvent(Player player, ITeam team, IArena arena) {
        this.player = player;
        this.team = team;
        this.arena = arena;
    }

    /**
     * Get the team
     *
     * @return the team assigned to the player
     */
    public ITeam getTeam() {
        return team;
    }

    /**
     * Get the player
     *
     * @return the target player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the arena
     *
     * @return arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Check if the assign was cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancel/ Allow the assign event
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
