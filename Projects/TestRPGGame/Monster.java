package TestRPGGame;

public class Monster {
    private String name;
    private int health;
    private int attack;
    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
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

    public int attack() {
        return attack;
    }

    @Override
    public String toString() {
        return name +
                " (Health=" + health +
                ", Attack=" + attack +
                ")";
    }
}
