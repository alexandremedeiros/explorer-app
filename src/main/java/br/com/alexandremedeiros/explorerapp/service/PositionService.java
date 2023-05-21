package br.com.alexandremedeiros.explorerapp.service;

import org.springframework.stereotype.Service;

@Service
public class PositionService {
	
	private int x;
	private int y;
	private char orientation;
	
	
	private void rotate(char direction) {
		if (direction == 'L') {
			switch (orientation) {
			case 'N':
				orientation = 'W';
				break;
			case 'S':
				orientation = 'E';
				break;
			case 'E':
				orientation = 'N';
				break;
			case 'W':
				orientation = 'S';
				break;
			}
		} else if (direction == 'R') {
			switch (orientation) {
			case 'N':
				orientation = 'E';
				break;
			case 'S':
				orientation = 'W';
				break;
			case 'E':
				orientation = 'S';
				break;
			case 'W':
				orientation = 'N';
				break;
			}
		}
	}

	private void moveForward() {
		switch (orientation) {
		case 'N':
			if (y < 4) {
				y++;
			}
			break;
		case 'S':
			if (y > 0) {
				y--;
			}
			break;
		case 'E':
			if (x < 4) {
				x++;
			}
			break;
		case 'W':
			if (x > 0) {
				x--;
			}
			break;
		}
	}

	private String getPosition() {
		return "(" + x + ", " + y + ", " + orientation + ")";
	}
	
	private void move(String commands) {
		for (char command : commands.toCharArray()) {
			if (command == 'L' || command == 'R') {
				rotate(command);
			} else if (command == 'M') {
				moveForward();
			} else {
				return;
			}
		}
	}
	
	
	private void initVariables() {
		this.x = 0;
		this.y = 0;
		this.orientation = 'N';
	}
	
	public String getRobotPosition(String command) {
		initVariables();
		move(command);
		return getPosition();
	}

}
