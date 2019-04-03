package minerengine.main.settings.message;

public abstract interface Message {

	public abstract void sendMessage(String message);

	public abstract String getAnswer(String question);

	public abstract int getInt(String question);

}
