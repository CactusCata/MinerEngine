package minerengine.main.settings.message;

import java.util.Scanner;

public final class ConsoleMessage implements Message {

	@Override
	public final void sendMessage(String message) {
		System.out.println(message);
	}

	@Override
	public final String getAnswer(String question) {
		final Scanner sc = new Scanner(System.in);
		final String answer = sc.nextLine();
		sc.close();
		return answer;
	}

	@Override
	public final int getInt(String question) {
		return Integer.parseInt(this.getAnswer(question));
	}

}
