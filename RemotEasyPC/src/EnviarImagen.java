import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class EnviarImagen extends Thread{
	Socket sokete;
	boolean error;
public EnviarImagen(Socket a){
	sokete=a;
	error=false;
}

	public void run(){
		while(error==false){
			capturarPantalla(sokete);
			try {
				sleep(100); 
			} catch (InterruptedException e) {
				
			}
			
		}
	}
	
	private void capturarPantalla(Socket a){
		try {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ByteArrayOutputStream salidaImagen = new ByteArrayOutputStream();
		 ImageIO.write(image, "jpg", salidaImagen);
	     byte[] bytesImagen = salidaImagen.toByteArray();
	     ObjectOutputStream salida = new ObjectOutputStream( a.getOutputStream() );
	     salida.writeObject( bytesImagen );
	     salida.flush();
			
			
		} catch (IOException e) {
			error=true;
			//JOptionPane.showMessageDialog(null, "cerrao");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
