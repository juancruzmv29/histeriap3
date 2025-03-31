package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaGameOver extends JDialog{

	private JLabel labelText;
	private JButton botonSeguir;
	private JButton botonSalir;
	
	
	public VentanaGameOver(JFrame parent) {
		super(parent);
		
		setSize(300, 150);
		setLocationRelativeTo(parent);
		setLayout(new FlowLayout());
		
		labelText = new JLabel("El juego ha terminado, quieres seguir jugando?");
		botonSeguir = new JButton("Seguir jugando");
		botonSalir = new JButton("Salir del juego");
		
		//botonSeguir.addActionListener(e -> parent.);
		
		add(labelText);
		add(botonSeguir);
		add(botonSalir);
		
		
		setVisible(true);
	}
	
	
	
}
