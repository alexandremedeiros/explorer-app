package br.com.alexandremedeiros.explorerapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alexandremedeiros.explorerapp.validator.CommandValidator;

@ExtendWith(MockitoExtension.class)
public class ExploreServiceTest {
	
	@Mock
	private CommandValidator commandValidator;
	
	@Mock
	private PositionService positionService;
	
	@InjectMocks
	private ExploreService exploreService;
	
	
	@Test
    public void shouldMoveTo2x0ySouthOrientation() {
		when(exploreService.getPosition("MMRMMRMM")).thenReturn("(2, 0, S)");
		var message = exploreService.getPosition("MMRMMRMM");
		assertEquals("(2, 0, S)", message);
		
    }
	
	
	@Test
    public void shouldMoveTo0x2yWestOrientation() {
		when(exploreService.getPosition("MML")).thenReturn("(0, 2, W)");
		var message = exploreService.getPosition("MML");
		assertEquals("(0, 2, W)", message);
	}
	
	
	@Test
    public void shouldMoveTo2x2yNorthOrientation() {
		when(exploreService.getPosition("MMRMMMM")).thenReturn("(4, 2, E)");
		var message = exploreService.getPosition("MMRMMMM");
		assertEquals("(4, 2, E)", message);
	}
	
	
	@Test
    public void shouldReturnInvalidCommand() {
		when(exploreService.getPosition("AAA")).thenReturn("Comando inválido");
		var message = exploreService.getPosition("AAA");
		assertEquals("Comando inválido", message);
	}
	
	
	@Test
    public void shouldReturnInvalidCommand2() {
		when(exploreService.getPosition("MMMMMMMMMMMMM")).thenReturn("Comando inválido");
		var message = exploreService.getPosition("MMMMMMMMMMMMM");
		assertEquals("Comando inválido", message);
	}

}
