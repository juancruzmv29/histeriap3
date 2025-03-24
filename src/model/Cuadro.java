package model;

import utils.ColorCuadro;

public class Cuadro {
	
	
	private boolean activo;
	private ColorCuadro colorCuadro;
	
	
	
	public Cuadro(ColorCuadro colorCuadro) {
		this.colorCuadro = colorCuadro;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public ColorCuadro getColorCuadro() {
		return colorCuadro;
	}



	public void setColorCuadro(ColorCuadro colorCuadro) {
		this.colorCuadro = colorCuadro;
	}
	
	
	

}
