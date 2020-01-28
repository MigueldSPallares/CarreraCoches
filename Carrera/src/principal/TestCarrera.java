package principal;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.Coche;

class TestCarrera {
	
	Coche c;
	
	@BeforeEach
	void configurar() {
		c = new Coche("Miguel", 4, 1000);
	}
	
	@Test
	void test() {
		c.acelerarTest(80);
		assertEquals(80,c.getVelocidad());
	}
	@Test
	void test2() {
		c.acelerarTest(200);
		assertEquals(0, c.getVelocidad());
	}
	
	@Test
	void test3() {
		c.setVelocidad(100);
		c.frenarTest(30);
		assertEquals(70, c.getVelocidad());
	}
	
	@Test
	void test4() {
		c.setVelocidad(300);
		c.acelerarTest(0);
		c.frenarTest(30);
		assertEquals(0, c.getVelocidad());
	}
	@Test
	void test5() {
		c.setVelocidad(100);
		c.frenarTest(130);
		assertEquals(0, c.getVelocidad());
	}
}
