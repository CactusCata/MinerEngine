package minerengine.main;

import minerengine.lwjgl.LwjglWindows;
import minerengine.main.game.Game;
import minerengine.main.gameplay.entity.list.Player;
import minerengine.main.gameplay.world.World;
import minerengine.main.gameplay.world.WorldType;
import minerengine.main.gameplay.world.location.Location;
import minerengine.main.settings.Difficulty;
import minerengine.main.settings.MessageType;
import minerengine.main.settings.Settings;

public final class Main {

	public static void main(String[] args) {

		Settings setting = new Settings(Difficulty.MEDUIM, MessageType.CONSOLE, 60);
		Game game = new Game("MinerEngine 1.0.0", setting);

		LwjglWindows lwjglWindow = new LwjglWindows(game);
		lwjglWindow.createWindows();
		lwjglWindow.start();
		
		World world = new World(WorldType.NORMAL);
		world.generate();

		Player player = new Player();
		player.spawn(new Location(world, 55, 28));

//		while (running.isRunning()) {
//
//			while (!player.isDead()) {
//				FightManager fight = new FightManager(player);
//				Entity entity = FightManager.getRandomEntity();
//				entity.spawn(new Location(world, 55, 28));
//				fight.fight(entity);
//				FightManager fight2 = new FightManager(entity);
//				fight2.fight(player);
//			}
//		}
	}
}
