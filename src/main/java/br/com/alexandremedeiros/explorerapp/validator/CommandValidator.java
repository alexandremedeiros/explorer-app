package br.com.alexandremedeiros.explorerapp.validator;

import org.springframework.stereotype.Component;

@Component
public class CommandValidator {
	
	private boolean existsL = false;
	private boolean existsR = false;
	private boolean existsM = false;
	
	
	public Boolean validate(String command) {
		existsL = false;
		existsR = false;
		existsM = false;
		
		if (!validateString(command)) {
			return false;
		}
		
		if (command.contains("M")) {
            existsM = true;
        }
		if (command.contains("L")) {
            existsL = true;
        }
		if (command.contains("R")) {
            existsR = true;
        }
		
		if (!existsM && !(existsL || existsR)) {
			return false;
		}
		else if (existsM && !(existsL || existsR)) {
			return false;
		}
		
		return true;
	}
	
	private boolean validateString(String input) {
	    return input.matches("[MRL]+");
	}

}
