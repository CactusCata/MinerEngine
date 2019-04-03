package minerengine.main.gameplay.fight;

import minerengine.main.game.Game;
import minerengine.main.gameplay.entity.Entity;
import minerengine.main.gameplay.entity.EntityType;
import minerengine.main.utils.EnumUtils;

public class FightManager {

	private final Entity entity;

	public FightManager(Entity entity) {
		this.entity = entity;
	}

	public final void fight(Entity entity) {
		this.entity.attack(entity);
		Game.getInstance().getSettings().getMessage()
				.sendMessage("L'entité " + this.entity.getName() + " a frappé l'entité " + entity.getName() + " !");
		if (entity.isDead()) {
			Game.getInstance().getSettings().getMessage()
					.sendMessage("L'entité " + entity.getName() + " a été tué par " + this.entity.getName() + "!");
			entity.dropLoot(this.entity);
		}
	}

	public static Entity getRandomEntity() {
		return new Entity(EnumUtils.randomEnum(EntityType.class));
	}

}
