package TestRPGGame;

public class Player {

    private String name;
    private int health;
    public int attack;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attack = 10;
        this.level = 1;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    private void levelUp() {
        level++;
        attack += 5;
        health = 100;
        System.out.println("Level Up! You are now level " + level);
    }

    private void gainExperience(int exp) {
        experience += exp;
        if (experience >= level*10) {
            levelUp();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", level=" + level +
                ", experience=" + experience +
                '}';
    }
}
