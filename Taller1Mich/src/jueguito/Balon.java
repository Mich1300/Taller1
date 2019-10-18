package jueguito;

import java.awt.Rectangle;

import org.w3c.dom.css.Rect;

import processing.core.PImage;

public class Balon extends Thread {
	private Main app;
	
	private int x;
	private int y;
	private int tam;
	private boolean gol;
	private int img;
	private int dx;
	private int dy;
	private int isTocando;
	
	private PImage skull;
	
	public Balon (Main app) {
		this.app = app;
		x=500;
		y=250;
		tam=20;
		gol=false;		
		img=5;	
		
		skull = app.loadImage("Skull.png");
	}
	
	public void iniciar() {
		x=500;
		y=250;
		dx = (int)app.random(-4,4);
		dy = (int) app.random(-4,4);
		isTocando= 0;
	}
	
	public void pintar () {
		app.imageMode(app.CENTER);
		app.image(skull,60,30);
		}
	
	public void mover () {
		if (Logica.pantallas == 2 && dx!=0 && dy!=0) {
			x += dx;
			y += dy;
		}
		
		if (y<0) {
			dy = -dy;
			img= (int) Math.floor(app.random(0,5));
		}
		
		if (y>480) {
			dy =-dy;
			img= (int) Math.floor(app.random(0,5));
		}
	}
	 public void run (){
		 System.out.println("shit");
		 if (x>=Logica.jugadores[0].getX() && x< Logica.jugadores[0].getX()+30 && y>= Logica.jugadores[0].getY() && y<= Logica.jugadores[0].getY()+120 && isTocando==2||
				 x>= Logica.jugadores[0].getX() && x<= Logica.jugadores[0].getX()+30 && y>= Logica.jugadores[0].getY() && y<= Logica.jugadores[0].getY()+120 && isTocando==0) {
				isTocando=1;
				if(dx==0 || dy==0) {
					dx = (int)app.random(-4,4);
					dy = (int) app.random(-4,4);
					System.out.println("mierda");
				}
				 if (dx>0) {
					dx+=0.4;
				}
				if (dx<0) {
					dx-=0.4;
				
				}
				if (dy>0) {
					dy+=0.4;
				}
				
				if (dy<0) {
					dy-=0.4;
				}
				dy = (int)app.random(-4,4);
				img = (int) Math.floor(app.random(0,5));
				if(dx==0 || dy==0) {
					dx = (int)app.random(-4,4);
					dy = (int) app.random(-4,4);
				}
				dx =-dx;	
				return;
			}
	
			 if (x>=Logica.jugadores[1].getX() && x< Logica.jugadores[1].getX()+30 && y>= Logica.jugadores[2].getY() && y<= Logica.jugadores[1].getY()+120 && isTocando==1||
				 x>= Logica.jugadores[1].getX() && x<= Logica.jugadores[1].getX()+30 && y>= Logica.jugadores[2].getY() && y<= Logica.jugadores[1].getY()+120 && isTocando==0) {
				isTocando=2;
				if(dx==0 || dy==0) {
					dx = (int)app.random(-4,4);
					dy = (int) app.random(-4,4);
				}
				if (dx>0) {
					dx+=0.4;
				}
				if (dx<0) {
					dx-=0.4;
				}
				if (dy>0) {
					dy+=0.4;
				}
				if (dy<0) {
					dy-=0.4;
				}
				img = (int) Math.floor(app.random(0,5));
				dy = (int)app.random(-4,4);
				dx = -dx;
				if(dx==0 || dy==0) {
					dx = (int)app.random(-4,4);
					dy = (int) app.random(-4,4);
				}
				return;
			}
			
	 }
	
	 public void eliminarBalon(){
		 isTocando = 0;
	 }

	public int getX() {
		return x;
	}	
}
