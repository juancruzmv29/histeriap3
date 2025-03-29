package controller;

import model.Cuadro;
import view.VentanaPrincipal;

public class PartidaController {
	
	private Cuadro[][] cuadros;
	private int cuadrosColoreados;
	private int cuadrosTotal = 25;
	
	
	public PartidaController(Cuadro[][] cuadros) {
		this.cuadros = cuadros;
	}
	
	
	// Funcion para que al clickear un cuadro, se coloreen los de al lado
	public void colorearCuadro(Cuadro c) {
		c.clickEnCuadro();
	}
	
	
	// Funcion que si un cuadro no tiene nada al lado o arriba o abajo no haga nada
	
	
	// Funcion de que si todos los cuadros están activos y/o coloreados el jugador gana
	public boolean todosCuadrosActivos() {
		return cuadrosColoreados == cuadrosTotal;
	}
	
	
	// Funcion para reiniciar el juego y volver a colorear los cuadros a gris
	public void reiniciarJuego(Cuadro[][] cuadros) {
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				cuadros[i][j].ponerEnGris();;
			}
		}
		cuadrosColoreados = 0;
	}
	
	
	// Funcion sumar cuadros
	public void sumarCuadradosActivos() {
		this.cuadrosColoreados++;
	}
	
	
	
}
