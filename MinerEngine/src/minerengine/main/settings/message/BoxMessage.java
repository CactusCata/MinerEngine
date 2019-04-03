package minerengine.main.settings.message;

import javax.swing.JOptionPane;

import minerengine.main.game.Game;

public final class BoxMessage implements Message {

	@Override
	public final void sendMessage(String message) {
		JOptionPane.showMessageDialog(null, message, Game.getInstance().getGameName(), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public final String getAnswer(String question) {
		return JOptionPane.showInputDialog(null, question, Game.getInstance().getGameName(),
				JOptionPane.QUESTION_MESSAGE);
	}

	@Override
	public final int getInt(String question) {
		return Integer.parseInt(getAnswer(question));
	}

}
