package jueguito;

import processing.core.PImage;

public class Jugador {
	private Main app;
	private int x;
	private int y;
	
	private PImage oni;
	private PImage tiger;
	
	public Jugador(Main app,int x, int y) {
		this.app = app;
		
		this.x=x;
		this.y=y;
		
		oni = app.loadImage("Oni.png");
		tiger = app.loadImage("Tiger.png");
	}
	
	public void pintarj1() {
		app.imageMode(app.CENTER);
		app.image(oni,x,y,120,161);
	}
	
	public void pintarj2 () {
		app.imageMode(app.CENTER);
		app.image(tiger,x,y,174,161);
	}
	
	public void moverArriba () {
		if(y-5>=3 && y<=527) {
			y-=5;
		}
	}
	
	public void moverAbajo () {
		if (y>=0 && y+5<=527) {
			y+=5;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


}
