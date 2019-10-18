package jueguito;

import processing.core.PApplet;
public class Main extends PApplet {

	private Logica log;
	public static void main(String[] args) {
	PApplet.main("jueguito.Main");
	
	}
	
	public void settings () {
	size(1000,600);
	}
	
	public void setup () {
		log = new Logica(this);
		
	}
	
	public void draw () {
		log.pintar();
	}
	
	public void keyPressed () {
		log.moverJugadores();
	}
	
	public void keyReleased () {
		log.pararJugadores();
	}
	
	public void mouseClicked () {
		log.click();
	}	

}
