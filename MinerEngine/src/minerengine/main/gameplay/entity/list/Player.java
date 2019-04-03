package minerengine.main.gameplay.entity.list;

import minerengine.main.game.Game;
import minerengine.main.gameplay.entity.Entity;
import minerengine.main.gameplay.entity.EntityType;
import minerengine.main.gameplay.entity.stats.PlayerStatistics;

public class Player extends Entity {

	public Player() {
		this(new PlayerStatistics(EntityType.PLAYER.getRandomStats(), 0, 1));
	}

	public Player(PlayerStatistics statistics) {
		super(EntityType.PLAYER, statistics);
	}

	@Override
	public final void setDead() {
		super.setDead();
		Game.getInstance().getSettings().getMessage().sendMessage("Le joueur " + super.getName() + " a été tué !");
	}

}
