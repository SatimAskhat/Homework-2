package com.example.mud.controller;

import java.util.Scanner;
import com.example.mud.player.Player;
import com.example.mud.room.Room;
import com.example.mud.item.Item;

public class MUDController {

    private final Player player;
    private boolean running;
    private final Scanner scanner;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
        this.scanner = new Scanner(System.in);
    }

    public void runGameLoop() {
        System.out.println("Welcome to the MUD game! Type 'help' for commands.");
        
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
    }

    public void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pickup":
                pickUp(argument);
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
                running = false;
                System.out.println("Thanks for playing!");
                break;
            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");
                break;
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("You are in " + currentRoom.getDescription());
        System.out.println("Exits: " + currentRoom.getExits());
        System.out.println("Items: " + currentRoom.getItems());
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where? Usage: move <direction>");
            return;
        }
        
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            lookAround();
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Pick up what? Usage: pickup <item>");
            return;
        }
        
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            player.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up " + item.getName());
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying: " + player.getInventory());
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("  look - Describe the current room");
        System.out.println("  move <direction> - Move in a direction (e.g., north, south)");
        System.out.println("  pickup <item> - Pick up an item");
        System.out.println("  inventory - Show your inventory");
        System.out.println("  help - Show this help menu");
        System.out.println("  quit - Exit the game");
    }
}
