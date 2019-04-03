package minerengine.main.settings;

import minerengine.main.settings.message.BoxMessage;
import minerengine.main.settings.message.ConsoleMessage;
import minerengine.main.settings.message.Message;

public enum MessageType {

	BOX(BoxMessage.class),
	CONSOLE(ConsoleMessage.class);

	private Message message;

	private MessageType(Class<? extends Message> clazz) {
		try {
			this.message = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			this.message = null;
			e.printStackTrace();
		}
	}

	public final Message getMessage() {
		return message;
	}

}
