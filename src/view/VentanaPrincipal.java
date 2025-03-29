package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;

import controller.PartidaController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JButton[][] botones;
	private PartidaController pController;
	private final int FILAS = 5;
	private final int COLUMNAS = 5;
	
	

	public VentanaPrincipal(PartidaController pController) {
		//initialize();
		this.pController = pController;
		
		frame = new JFrame();
		frame.setSize(903, 300);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		
		// Generamos un boton en la grilla
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				botones[i][j] = new JButton();
				panel.add(botones[i][j]);

				// Seteamos un color determinado en gris
				botones[i][j].setBackground(Color.gray);
				final int fila = i;
				final int columna = j;
			}
		}
		
	}
	
	/*
	private void initialize() {
		frame = new JFrame();
		frame.setSize(903, 300);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(FILAS, COLUMNAS));
		
		// Generamos un boton en la grilla
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				botones[i][j] = new JButton();
				panel.add(botones[i][j]);

				// Seteamos un color determinado en gris
				botones[i][j].setBackground(Color.gray);
				final int fila = i;
				final int columna = j;
			}
		}
		
	}*/

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	
	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	

}
