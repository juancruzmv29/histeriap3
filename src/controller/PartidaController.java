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
	
	
	
	public void colorearCuadro(Cuadro c) {
	    int fila = -1, columna = -1;

	    // Buscar la posición del cuadro clickeado
	    for (int i = 0; i < cuadros.length; i++) {
	        for (int j = 0; j < cuadros[i].length; j++) {
	            if (cuadros[i][j] == c) {
	                fila = i;
	                columna = j;
	                break;
	            }
	        }
	    }

	    if (fila == -1 || columna == -1) return; // No se encontró el cuadro (por seguridad)

	    // Activar el cuadro clickeado
	    c.clickEnCuadro();

	    // Lista de vecinos (arriba, abajo, izq, der)
	    int[][] vecinos = {
	        {fila - 1, columna}, // arriba
	        {fila + 1, columna}, // abajo
	        {fila, columna - 1}, // izquierda
	        {fila, columna + 1}  // derecha
	    };

	    for (int[] v : vecinos) {
	        int i = v[0];
	        int j = v[1];

	        if (i >= 0 && i < cuadros.length && j >= 0 && j < cuadros[0].length) {
	            Cuadro vecino = cuadros[i][j];
	            vecino.clickEnCuadro(); // activar vecino

	            if (vecino.getColorCuadro() != null && c.getColorCuadro() != null &&
	                vecino.getColorCuadro().equals(c.getColorCuadro())) {
	                // Si tiene mismo color, poner ambos en gris
	                vecino.ponerEnGris();
	                c.ponerEnGris();
	            }
	        }
	    }
	}
	
	
	// Funcion que pone en gris los cuadros... el clikeado y los de alrededor.
	/*
	private void ponerCuadrosEnGris(Cuadro c) {
		c.ponerEnGris();
	}*/
	
	
	// Funcion de que si todos los cuadros están activos y/o coloreados el jugador gana
	public boolean todosCuadrosActivos(Cuadro[][] cuadros) {
		int cont = 0;
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					cont++;
				}
			}
		}
		return cont == cuadrosTotal;
	}
	
	// Funcion para ver si todos los cuadros están activos
	/*
	public boolean todosLosCuadrosActivos(Cuadro[][] cuadros) {
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}*/
	
	public boolean todosLosCuadrosActivos(Cuadro[][] cuadros) {
	    for (int i = 0; i < cuadros.length; i++) {
	        for (int j = 0; j < cuadros[0].length; j++) {
	            if (!cuadros[i][j].isActivo()) {
	                return false; // si encontramos uno que no esté activo, aún no ganó
	            }
	        }
	    }
	    return true; // todos estaban activos
	}
	
	// Funcion privada para cuando un cuadro se compare con el color de otro cuadro
	private boolean mismoColor(Cuadro c, Cuadro c1) {
		return c.getColorCuadro().equals(c1.getColorCuadro());
	}
	
	
	
	// Funcion para cuando alguno de los colores que esten alrededor de un cuadro sea igual. AGREGAR INTENTOS
	/*
	public boolean perdisteJuego(Cuadro[][] cuadros) {
		
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				if(cuadros[i][j].isActivo()) {
					if(mismoColor(cuadros[i][j], cuadros[i+1][j])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i][j+1])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i-1][j])) {
						return true;
					}
					if(mismoColor(cuadros[i][j], cuadros[i][j-1])) {
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}*/
	
	public boolean perdisteJuego(Cuadro[][] cuadros) {
	    for (int i = 0; i < cuadros.length; i++) {
	        for (int j = 0; j < cuadros[0].length; j++) {
	            Cuadro actual = cuadros[i][j];

	            if (actual.isActivo()) {
	                // Vecinos posibles
	                int[][] vecinos = {
	                    {i - 1, j}, // arriba
	                    {i + 1, j}, // abajo
	                    {i, j - 1}, // izquierda
	                    {i, j + 1}  // derecha
	                };

	                for (int[] v : vecinos) {
	                    int fila = v[0];
	                    int col = v[1];

	                    if (fila >= 0 && fila < cuadros.length && col >= 0 && col < cuadros[0].length) {
	                        Cuadro vecino = cuadros[fila][col];

	                        if (vecino.isActivo() && mismoColor(actual, vecino)) {
	                            return true; // hay dos cuadros activos con mismo color
	                        }
	                    }
	                }
	            }
	        }
	    }

	    return false; // no se encontró condición de pérdida
	}
	
	// Funcion para reiniciar el juego y volver a colorear los cuadros a gris
	public void reiniciarJuego(Cuadro[][] cuadros) {
		for(int i = 0; i < cuadros.length; i++) {
			for(int j = 0; j < cuadros[0].length; j++) {
				cuadros[i][j].ponerEnGris();
			}
		}
		cuadrosColoreados = 0;
	}
	
	
	// Funcion sumar cuadros
	public void sumarCuadradosActivos() {
		this.cuadrosColoreados++;
	}
	
	
	
}
