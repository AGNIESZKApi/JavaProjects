package TestRPGGame;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    public void start() {
        System.out.println("Welcome to the new RPG Game!");
        createCharacter();
        mainMenu();
    }

    private void createCharacter() {
        System.out.println("Create character`s name: ");
        String name = scanner.nextLine();
        player = new Player(name);
        System.out.println("Good job! Welcome " + player.getName());
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("1. Fight");
            System.out.println("2. Show stats");
            System.out.println("3. Exit");
            System.out.print("Choose an option:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    fight();
                    break;
                case 2:
                    showStats();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the game...");
                    break;
                default:
                    System.out.println("Default option!");
            }
        }
    }

    private void fight() {
    }

    private Monster generateMonster() {
        String[] names = {"Goblin", "Orc", "Shadow", "Troll"};
        int health = (int) (Math.random()*50 + 50);
        int attack = (int) (Math.random()*10 + 5);
        String name = names[(int) (Math.random()* names.length)];
        return new Monster(name, health, attack);
    }

    private void fightMonster() {
        Monster monster = generateMonster();
        System.out.println("Monster " + monster + "appeared!");
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("1. Attack");
            System.out.println("2. Run");
            int action = scanner.nextInt();
            if (action == 1) {
                monster.takeDamage(player.attack);
                System.out.println(monster.getName() + " gets hit by " + player.getName());
                if (monster.getHealth() <= 0) {
                    System.out.println("Monster " + monster.getName() + " is defeated!");
                }
                player.takeDamage(monster.attack());
                System.out.println(monster.getName() + " hits " + player.getName() + " " + monster.attack() + "damage!");
                if (player.getHealth() <= 0) {
                    System.out.println("You`re defeated!");
                }
            } else {
                System.out.println("You run away!");
                break;
            }
            if (player.getHealth() <= 0) {
                System.out.println("You`re defeated by the " + monster.getName());
            }
        }

    }

    private void showStats() {
        System.out.println(player);
    }
}
