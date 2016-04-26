import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
public class Pantalla extends JFrame{
	
	static JTextArea pant;
	JPanel panel;
	 
	public Pantalla(){
		super("Servidor Control Remoto PC By Saul Blanco");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		pant= new JTextArea(35,65);
		pant.setEditable(false);
		add(pant);
		
		setSize(750,500);
		panel= new JPanel();
		//panel.setSize(500,500);
		
		add(panel);
		setVisible(true);
		
	}
	
	
	public void setText(String texto){
		pant.append("\n" + texto);
	}
	

}