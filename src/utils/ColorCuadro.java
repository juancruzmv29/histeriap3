package utils;

import java.awt.Color;
import java.util.Random;

public enum ColorCuadro {
	
	
	AZUL(Color.BLUE),
	ROJO(Color.RED),
	VERDE(Color.GREEN),
	AMARILLO(Color.YELLOW),
	ROSA(Color.PINK),
	NARANJA(Color.ORANGE);
	
	private final Color color;
	
	ColorCuadro(Color color) {
		this.color = color;
	}
	
	
	public Color getColor() {
		return color;
	}
	
	public static ColorCuadro obtenerColorRandom() {
		ColorCuadro[] colores = values();
		
		return colores[new Random().nextInt(colores.length)];
	}

}
