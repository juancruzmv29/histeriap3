package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaGameOver extends JDialog{

	private JLabel labelText;
	private JButton botonSeguir;
	private JButton botonSalir;
	private JButton botonLista;
	
	
	public VentanaGameOver(JFrame parent) {
		super(parent, "Juego terminado");
		
		setSize(400, 350);
		setLocationRelativeTo(parent);
		setLayout(new FlowLayout());
		
		JPanel panelVentana = new JPanel();
		
		labelText = new JLabel("El juego ha terminado, quieres seguir jugando?");
		botonSeguir = new JButton("Seguir jugando");
		botonSalir = new JButton("Salir del juego");
		botonLista = new JButton("Ver lista de jugadores ganadores");
		panelVentana.add(labelText);
		panelVentana.add(botonSeguir);
		panelVentana.add(botonSalir);
		panelVentana.add(botonLista);
		
		// Agregue para añadir las cosas al panel
		
		//botonSeguir.addActionListener(e -> parent.);
		
		add(panelVentana);
		
		
		setVisible(true);
	}


	public JButton getBotonSeguir() {
		return botonSeguir;
	}


	public void setBotonSeguir(JButton botonSeguir) {
		this.botonSeguir = botonSeguir;
	}


	public JButton getBotonSalir() {
		return botonSalir;
	}


	public void setBotonSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}


	public JButton getBotonLista() {
		return botonLista;
	}


	public void setBotonLista(JButton botonLista) {
		this.botonLista = botonLista;
	}
	
	
	
	
	
}
