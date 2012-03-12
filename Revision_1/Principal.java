/*  ~Linea que diga que se modifico la mascota despues de cierto tiempo :B
*/

/*
  Clase principal del juego
*/

import java.util.*;

public class Principal{
    public static void main(String[] args){
	String tempNombre;//Variable utilizada para poder darle un nombre definido por el usuario a la mascota
	
	/*Creacion de todos los objetos necesarios*/
	Scanner scanf = new Scanner(System.in);
	General general = new General();
	Niveles nivel = new Niveles();
	Mascota tamagotchi = new Mascota();
	Imprimir imprimir = new Imprimir();
	Hilo hilo = new Hilo();
	Thread hiloC = new Thread(hilo);
	/*Empezar todos los objetos de manera "general"*/
	//hilo.setHilo(tamagotchi,imprimir)
	System.out.println("~~Bienvenido al tamagotchi~~");
	System.out.print("Ingrese el nombre de su mascota virtual: ");
	tempNombre = scanf.next();
	tamagotchi.crearMascota(tempNombre,nivel);
	/*Empezar los objetos de manera "general"*/
	hilo.setHilo(tamagotchi,imprimir);
	tamagotchi.setMascota(general,imprimir);
	general.setGeneral(nivel,tamagotchi);
	imprimir.setImprimir(tamagotchi,general,nivel);
	//Thread hiloC = new Thread(hilo);
	hiloC.start();//Empieza a ejecutarse el hilo que se encarga de que el tamagotchi viva aun y cuando no lo este usando el usuario
	while(true){//Menu desplegado 'n' veces
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
	    imprimir.imprEstad(0);
	    imprimir.menu();
	}
    }
}