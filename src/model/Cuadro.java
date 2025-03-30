package model;

import java.awt.Color;

import javax.swing.JButton;

import utils.ColorCuadro;

public class Cuadro extends JButton {
	
	
	private boolean activo = false;
	private ColorCuadro colorCuadro;
	private Color color;
	
	
	
	public Cuadro() {
		this.color = Color.gray;
		this.addActionListener(e -> clickEnCuadro());
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
		this.setBackground(ColorCuadro.obtenerColorRandom().getColor());
	}
	
	// Funcion para colorear aleatoreamente un cuadro.
	public void clickEnCuadro() {
		this.setActivo();
		this.setColorCuadro();
	}
	
	
	

}
