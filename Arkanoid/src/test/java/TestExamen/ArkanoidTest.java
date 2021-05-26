package TestExamen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import p014arcanoid.Arkanoid;
import p014arcanoid.Bloque;
import p014arcanoid.Pelota;

import java.awt.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArkanoidTest {

	@Spy
	private Arkanoid spyArkanoid;

	@Spy
	private Graphics g;

	@Mock
	private Pelota pelota;

	@Mock
	private Bloque raqueta;

	@Test
	void paint() {

		spyArkanoid.setNoseve(g);
		spyArkanoid.setPelota(pelota);
		spyArkanoid.setRaqueta(raqueta);
		spyArkanoid.setBloques(new Bloque[0][0]);
		spyArkanoid.setVidas(new Bloque[0]);
		spyArkanoid.setNumVidas(0);

		assertEquals(0, spyArkanoid.getNumVidas());

		spyArkanoid.paint(g);

		verify(g, times(1)).drawString("GAME OVER! LOOSER", 80, 100);
	}

	@Test
	void mouseDown() {

		spyArkanoid.setPelota(pelota);

		doNothing().when(spyArkanoid).init();
		spyArkanoid.setPuntuacion(7000);
		spyArkanoid.setNumVidas(0);


		assertEquals(0, spyArkanoid.getNumVidas());
		spyArkanoid.mouseDown(null, 0, 0);
		verify(spyArkanoid, times(1)).init();
		assertEquals(5, spyArkanoid.getNumVidas());
	}

}