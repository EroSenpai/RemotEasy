import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor extends Thread {
	Pantalla p1;
	
	
	public Servidor(){
		
		 p1=new Pantalla();
		Thread hilo = new Thread(this);
		hilo.start();
	}

	public void run(){
		try {
			
			
			ServerSocket servidor = new ServerSocket(9097);
			Socket cliente;
			p1.setText("SERVIDOR INICIADO CORRECTAMENTE...");
			while(true){
				cliente= servidor.accept();
				p1.setText("nueva conexion entrante desde: "+ cliente.getInetAddress());
				String aux=cliente.getInetAddress().toString();
				new Entrante(cliente, p1, aux);
				
				
			}//fin while
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p1.setText("ERRORAL INICIAR EL SERVIDOR... "
		     + "COMPRUEBA QUE EL PUERTO 9098 ESTA LIBRE Y REINICIE LA APLICACION");
		}
	}	//fin run
	
	
	public static void main(String[] args) {
		
		new Servidor();
	}
}