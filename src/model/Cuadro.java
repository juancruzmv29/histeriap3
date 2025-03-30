package model;

import java.awt.Color;

import javax.swing.JButton;

import utils.ColorCuadro;

public class Cuadro {
	
	
	private boolean activo = false;
	private ColorCuadro colorCuadro;
	private Color color;
	private JButton boton;
	
	
	
	public Cuadro() {
		this.boton = new JButton();
		ponerEnGris();
		this.boton.addActionListener(e -> clickEnCuadro());
	}



	public boolean isActivo() {
		return activo;
	}



	public JButton getBoton() {
		return boton;
	}



	public void setBoton(JButton boton) {
		this.boton = boton;
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
