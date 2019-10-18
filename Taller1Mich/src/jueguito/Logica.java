package jueguito;

import processing.core.PImage;

public class Logica {
	private Main app;
	public static int pantallas=0;
	public static Jugador [] jugadores;
	
	private int jugador1;
	private int jugador2;
	private int puntajej1;
	private int puntajej2;
	private boolean j1arriba;
	private boolean j1abajo;
	private boolean j2arriba;
	private boolean j2abajo;
	private int y = 190;
	private Contador contador;
	private Balon balon;
	
	private PImage fondo1;
	private PImage fondo2;
	private PImage fondo3;
	private PImage oniWin;
	private PImage tigerWin;

	
	public Logica(Main app) {
		this.app = app;
		balon = new Balon(app);
		jugadores = new Jugador [2];
		jugador1 = 143;
		jugador2 = 843;
		jugadores[0] = new Jugador (app, jugador1, y);
		jugadores[1] = new Jugador (app, jugador2, y);
		contador = new Contador();
		contador.start();
		fondo1 = app.loadImage("1.png");
		fondo2 = app.loadImage("2.png");
		fondo3 = app.loadImage("3.png");
		fondo3.resize(1000, 600);
		oniWin = app.loadImage("OniWin.png");
		tigerWin = app.loadImage("TigerWin.png");
		
	}
	
	public void pintar() {
		switch(pantallas) {
		case 0:
			app.image(fondo1,0,0,1000,600);
		break;
		case 1:
			app.image(fondo2,0,0,1000,600);
		break;
		case 2:
			update();
			app.image(fondo3,app.width/2,app.height/2);
			
			app.textSize(60);
			app.fill(0);
			app.text(puntajej1,320,575);
			app.text(puntajej2,690,575);
			balon.pintar();
			balon.run();
			jugadores[0].pintarj1();
			jugadores[1].pintarj2();
			
			
			
			
			if(puntajej1==5) {
				pantallas=3;
			}
			if (puntajej2==5) {
				pantallas=4;
			}
			app.text(contador.contador, 500, 550);
		break;
		case 3:
			app.image(oniWin,0,0);
		break;
		case 4:
			app.image(tigerWin, 0, 0);
		break;
		}
	}
	
	public void moverJugadores() {

		if (app.keyCode == app.UP && pantallas == 2) {
			j2arriba = true;
			
		}

		if (app.keyCode == app.DOWN && pantallas == 2) {
			j2abajo = true;
		}
		
		if (app.key == 'w' && pantallas == 2) {
			j1arriba = true;
			
		}
		
		if (app.key == 's' && pantallas == 2) {
			j1abajo = true;
		}
	}
	
	public void pararJugadores() {
		if (app.keyCode == app.UP && pantallas == 2) {
			j2arriba = false;
		}
		
		if (app.keyCode == app.DOWN && pantallas == 2) {
			j2abajo = false;
		}
		
		if (app.key == 'w' && pantallas == 2) {
			j1arriba = false;
		}
		
		if (app.key == 's' && pantallas == 2) {
			j1abajo = false;
		}
	}
	
	public void update () {
		if (j1arriba) {
			jugadores[0].moverArriba();
		}
		if (j1abajo) {
			jugadores[0].moverAbajo();
		}
		if (j2arriba) {
			jugadores[1].moverArriba();
		}
		if (j2abajo) {
			jugadores[1].moverAbajo();
		}
	}
	
	public void meterGol() {
		if (balon.getX() < 0) {
			balon.eliminarBalon();
			puntajej2++;
			if (app.frameCount == 100) {
				balon.start();
			}
		}
		
		if (balon.getX() > 1000) {
			balon.eliminarBalon();
			puntajej1++;
			if (app.frameCount == 100) {
				balon.start();
			}
		}
	}
	
	public void click () {
		 
		 System.out.println("x" + app.mouseX + "y" +  app.mouseY);
		
		switch(pantallas) {
		case 0:
			if (app.mouseX>=507 && app.mouseY>=417 && app.mouseX<=895 && app.mouseY<=556) {
				pantallas = 1;
			}
		break;
		case 1:
			if (app.mouseX>=551 && app.mouseY>=501 && app.mouseX<=964 && app.mouseY<=571) {
				pantallas = 2;
			}
		break;
		case 3:
			if (app.mouseX>=645 && app.mouseY>=380 && app.mouseX<=940 && app.mouseY<=520) {
				pantallas = 2;
				puntajej1=0;
				puntajej2=0;
			}
		break;
		case 4:
			if (app.mouseX>=645 && app.mouseY>=380 && app.mouseX<=940 && app.mouseY<=520) {
				pantallas = 2;
				puntajej1=0;
				puntajej2=0;
			}
		break;
		}
		
	}
}
