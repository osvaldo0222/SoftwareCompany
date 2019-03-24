package visual;

import java.awt.event.KeyEvent;

public class Validation {

	
	Character character;
	
	public void justLetters(KeyEvent e) {
		character=e.getKeyChar();
		if (!Character.isLetter(character) && character!=KeyEvent.VK_SPACE) {
			e.consume();
			
		}else {
			if (Character.isLowerCase(character)) {
				e.setKeyChar(Character.toUpperCase(character));
			}
		}
		
	}
	
	
}