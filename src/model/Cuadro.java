package model;

import java.awt.Color;

import utils.ColorCuadro;

public class Cuadro {
	
	
	private boolean activo = false;
	private ColorCuadro colorCuadro;
	private Color color;
	
	
	
	public Cuadro() {
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo() {
		this.activo = true;
	}



	public ColorCuadro getColorCuadro() {
		return colorCuadro;
	}

	public void ponerEnGris() {
		this.color = Color.gray;
	}
 

	public void setColorCuadro() {
		this.colorCuadro = ColorCuadro.obtenerColorRandom();
	}
	
	// Funcion para colorear aleatoreamente un cuadro.
	public void clickEnCuadro() {
		this.setActivo();
		this.setColorCuadro();
	}
	
	
	

}
