# MUD Controller – Homework Assignment

## Overview

This project involved creating a MUD controller that processes basic player commands (e.g., movement, look, pick up, inventory). The goal was to implement a command-line experience where players can interact with a virtual world.


---

## Objectives

1. **Command Parsing:**  
   - I implemented a system that reads and parses commands (e.g., move forward, pick up sword) to execute actions with the appropriate arguments.



2. **Room & Movement Logic:**  
   -The controller checks if a room has a valid connection for the specified direction. If valid, the player moves; if not, an error message is shown (e.g., "You can’t go that way!").
   
4. **Interaction with Entities:**  
   - Look: Describes the current room (name, items, NPCs).
   - Pick up: Adds an item to the player’s inventory and removes it from the room.
   - Inventory: Lists the items in the player’s inventory.

5. **Help & Exit:**  
   -The help command displays available commands. The quit or exit command ends the game loop.

6. **SOLID & Clean Code:**  
   -I ensured each method had a single responsibility and kept the code concise and maintainable.

7. **Integration with Other Classes:**
   -The controller interacts with existing classes like Player, Room, and Item to manage the game world and player actions.

8. **Main Method:**
   -A main method was created to initialize rooms, place the player, and run the game loop for testing.



---

##Example Gameplay
look
Room: A small stone chamber
Items here: sword, shield
No NPCs present

pick up sword
You pick up the sword.

inventory
You are carrying:
- sword

move forward
You can't go that way!

help
Available commands:
- look
- move <forward|back|left|right>
- pick up <item>
- inventory
- help
- quit/exit


## Submission
The MUD controller was successfully implemented, providing interactive gameplay with robust error handling and clear feedback to the player. The code is structured, tested, and efficient.

