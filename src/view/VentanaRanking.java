package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class VentanaRanking extends JFrame {
	
	
	
	
	public VentanaRanking() {
        setTitle("Ranking de Ganadores");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

        try (BufferedReader reader = new BufferedReader(new FileReader("ranking.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                textArea.append(linea + "\n");
            }
        } catch (IOException e) {
            textArea.setText("No se pudo leer el archivo de ranking.");
        }

        setVisible(true);
    }
}
