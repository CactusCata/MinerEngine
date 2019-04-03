package minerengine.main.gameplay.entity.stats;

import minerengine.main.utils.Modifier;

public final class Experience {

	private long experience;
	private final Modifier level;

	public Experience(long experience, int level) {
		this.setExperience(experience);
		this.level = new Modifier(level);
	}

	public Experience() {
		this(0, 1);
	}

	public final long getExperience() {
		return experience;
	}

	public final void setExperience(long experience) {
		this.experience = experience;
	}

	public final void addExperience(long experience) {
		this.setExperience(this.getExperience() + experience);
	}

	public final void removeExperience(long experience) {
		this.addExperience(-experience);
	}

	public final void resetExperience() {
		this.setExperience(0);
	}

	public final Modifier getLevel() {
		return this.level;
	}

}
