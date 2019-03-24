package visual;

import java.awt.event.KeyEvent;

public class Validation {
	private Character character;
	
	public void justLetters(KeyEvent e) {
		character = e.getKeyChar();
		if (!Character.isLetter(character) && character != KeyEvent.VK_SPACE) {
			e.consume();
		}else {
			toUpperCase(e);
		}
	}
	
	public void toUpperCase(KeyEvent e) {
		character = e.getKeyChar();
		if (Character.isLowerCase(character)) {
			e.setKeyChar(Character.toUpperCase(character));
		}
	}

	public void justFloatNumbers(KeyEvent e, String number) {
		character = e.getKeyChar();
		boolean point = character == 46 && number.contains(".");
		if (!(character >= '0' && character <= '9') && !(character == 46)) {
			e.consume();
		} else if (point) {
			e.consume();
		}
	}
}