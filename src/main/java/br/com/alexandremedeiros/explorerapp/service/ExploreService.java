package br.com.alexandremedeiros.explorerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.alexandremedeiros.explorerapp.dto.PositionDto;
import br.com.alexandremedeiros.explorerapp.validator.CommandValidator;

@Service
public class ExploreService {
	
	@Autowired
	private CommandValidator commandValidator;
	
	@Autowired
	private PositionService positionService;
	
	@Value("${message.invalid_command}")
	private String invalidCommandMessage;
	
	
	public String getPosition(String command) {
		return positionService.getRobotPosition(command);
	}
	
	
	public PositionDto explore(String command) {
		PositionDto positionDto = new PositionDto("", HttpStatus.OK);
		
		if (commandValidator.validate(command)) {
			positionDto.setHttpStatus(HttpStatus.OK);
			positionDto.setMessage(getPosition(command));
		}
		else {
			positionDto.setHttpStatus(HttpStatus.BAD_REQUEST);
			positionDto.setMessage(invalidCommandMessage);
		}
		
		return positionDto;
	}

}

