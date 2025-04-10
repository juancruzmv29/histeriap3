package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaNombre extends JDialog {
	private HashMap<String, Integer> listaJugadores;
	private JTextField nombreJugador;
	private JLabel labelText;
	private JButton botonAceptar;
	
	/*
	public VentanaNombre(JFrame parent, HashMap<String, Integer> jugadores) {
		super(parent,"Ingrese su nombre", true);
		this.listaJugadores = jugadores;
		
		
		setSize(300, 150);
		setLocationRelativeTo(parent);
		setLayout(new GridLayout(2, 1));
		
		JPanel panelInput = new JPanel();
		nombreJugador = new JTextField(15);
		labelText = new JLabel("Ingrese su nombre");
		panelInput.add(labelText);
		panelInput.add(nombreJugador);
		
		JPanel panelBoton = new JPanel();
		botonAceptar = new JButton("Aceptar");
		panelBoton.add(botonAceptar);
		
		
		add(panelInput);
		add(panelBoton);
		
		nombreJugador.addActionListener(e -> guardarNombreYJugar());
		botonAceptar.addActionListener(e -> guardarNombreYJugar());
		
	}*/
	
	public VentanaNombre(JFrame parent, HashMap<String, Integer> jugadores) {
        super(parent, "Ingresar nombre", true);
        setSize(300, 100);
        setLocationRelativeTo(parent);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Nombre del jugador:");
        nombreJugador = new JTextField(15);
        add(label);
        add(nombreJugador);

        // Escuchamos Enter en el campo de texto
        nombreJugador.addActionListener(e -> {
        	String nombre = nombreJugador.toString();
            nombre = nombreJugador.getText().trim();
            if (!nombre.isEmpty()) {
                dispose(); // Cierra esta ventana
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.");
            }
        });
    }
	
	
	private void guardarNombreYJugar() {
		String nombre = nombreJugador.getText().trim();
		if(nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
		}
		
	}


	public String getNombreJugador() {
		return nombreJugador.toString();
	}


	public void setNombreJugador(JTextField nombreJugador) {
		this.nombreJugador = nombreJugador;
	}


	public JLabel getLabelText() {
		return labelText;
	}


	public void setLabelText(JLabel labelText) {
		this.labelText = labelText;
	}
	
	
}
