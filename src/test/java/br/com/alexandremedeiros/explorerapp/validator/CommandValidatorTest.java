package br.com.alexandremedeiros.explorerapp.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CommandValidatorTest {
	
	
	private CommandValidator commandValidator;
	
	
	@BeforeEach
    public void setUp() {
		commandValidator = mock(CommandValidator.class);
    }
	
	@Test
	public void shouldBeValid() {
		when(commandValidator.validate("MMRMMRMM")).thenReturn(true);
		var result = commandValidator.validate("MMRMMRMM");
		assertEquals(true, result);
	}
	
	
	@Test
	public void shouldBeValid2() {
		when(commandValidator.validate("MML")).thenReturn(true);
		var result = commandValidator.validate("MML");
		assertEquals(true, result);
	}
	
	
	@Test
	public void shouldBeInvalid() {
		when(commandValidator.validate("AAA")).thenReturn(false);
		var result = commandValidator.validate("AAA");
		assertEquals(false, result);
	}

}
