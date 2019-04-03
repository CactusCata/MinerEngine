package minerengine.main.gameplay.entity.stats;

public final class PlayerStatistics extends Statistics {

	private final Experience experience;

	public PlayerStatistics(int health, int maxHealth, int attack, int defense, int experience, int level) {
		super(health, maxHealth, attack, defense);
		this.experience = new Experience(experience, level);
	}

	public PlayerStatistics(Statistics statistics, int experience, int level) {
		this(statistics.getHealth().getValue(), statistics.getMaxHealth().getValue(), statistics.getAttack().getValue(),
				statistics.getDefense().getValue(), experience, level);
	}

	public final Experience getLevel() {
		return this.experience;
	}

}
