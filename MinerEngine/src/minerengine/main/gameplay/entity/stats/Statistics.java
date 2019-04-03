package minerengine.main.gameplay.entity.stats;

import minerengine.main.utils.Modifier;

public class Statistics {

	private final Modifier attack, defense, health, maxHealth;

	public Statistics(Modifier health, Modifier maxHealth, Modifier attack, Modifier defense) {
		this(health.getValue(), maxHealth.getValue(), attack.getValue(), defense.getValue());
	}

	public Statistics(Statistics statistics) {
		this(statistics.getHealth(), statistics.getMaxHealth(), statistics.getAttack(), statistics.getDefense());
	}

	public Statistics(final int health, final int attack, final int defense) {
		this(health, health, attack, defense);
	}

	public Statistics(final int health, final int maxHealth, final int attack, final int defense) {
		this.attack = new Modifier(attack);
		this.defense = new Modifier(defense);
		this.health = new Modifier(health);
		this.maxHealth = new Modifier(maxHealth);
	}

	public final Modifier getAttack() {
		return attack;
	}

	public final Modifier getDefense() {
		return defense;
	}

	public final Modifier getHealth() {
		return health;
	}

	public final Modifier getMaxHealth() {
		return maxHealth;
	}

}
