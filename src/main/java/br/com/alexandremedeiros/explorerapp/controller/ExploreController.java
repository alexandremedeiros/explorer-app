package br.com.alexandremedeiros.explorerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandremedeiros.explorerapp.dto.PositionDto;
import br.com.alexandremedeiros.explorerapp.service.ExploreService;

@RestController
public class ExploreController {
	
	@Autowired
	private ExploreService service;
	
	@GetMapping("/rest/mars/{command}")
	public ResponseEntity<String> explore(@PathVariable String command) {
		PositionDto destiny = service.explore(command);
		return ResponseEntity.status(destiny.getHttpStatus()).body(destiny.getMessage());
	}
	

}
