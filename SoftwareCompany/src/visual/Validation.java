package visual;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class Validation {
	private Character character;
	
	public void justInt(KeyEvent e) {
		char a=e.getKeyChar();
		
		if(a<'0'|| a>'9' ) {
			
			e.consume();
			
		}
		
	}
	
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

	public void justFloatNumbers(KeyEvent e, String number) { //Para campos que van para flotantes
		character = e.getKeyChar();
		boolean point = character == 46 && number.contains(".");
		if (!(character >= '0' && character <= '9') && !(character == 46)) {
			e.consume();
		} else if (point) {
			e.consume();
		}
	}
	
	public void justMailCharacter(KeyEvent e) {
		character = e.getKeyChar();
		if (!Character.isLetter(character) && !(character >= '0' && character <= '9') && !(character == 95) && !(character == 64) && !(character == 45) && !(character == 46)) {
			e.consume();
		}
	}
	
	public void setFocusBackground(Object object, boolean focus) { //focus = true (GainedFocus), focus = false (LostFocus)
		if (object instanceof JTextField) {
			if (focus) {
				((JTextField) object).setBackground(Color.yellow);
			} else {
				((JTextField) object).setBackground(Color.white);
			}
		} else if (object instanceof JComboBox) {
			if (focus) {
				((JComboBox) object).setBackground(Color.yellow);
			} else {
				((JComboBox) object).setBackground(Color.white);
			}
		} else if (object instanceof JSpinner) {
			if (focus) {
				((JSpinner) object).setBackground(Color.yellow);
			} else {
				((JSpinner) object).setBackground(Color.white);
			}
		}
	}
}