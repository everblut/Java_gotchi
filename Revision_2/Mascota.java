/*
Clase "Mascota",la cual incluye metodos escenciales para que la Mascota viva.
*/

import java.util.*;

public class Mascota{

    /*Random utilizado para que el juego sea mas interesante*/
    Random genRand = new Random();

    /*Atributos de la mascota*/
    private int vida;
    private int hambre;
    private int felic;
    private int topVida;
    private int topHambre;
    private int topFelic;
    private String nombre;
    private General tempGeneral;
    private Imprimir tempImprimir;

    /*Metodos de la mascota*/
    
    /*Metodo encargado de dar "vida" a la mascota,inicializar los atributos*/
    public void crearMascota(String asignarNombre,Niveles tempNivel){
	this.nombre = asignarNombre;
	this.vida = (genRand.nextInt(10000) % 25) + 1; 
	this.hambre = (genRand.nextInt(10000) % 25) + 1;
	this.felic = (genRand.nextInt(10000) % 25) + 1;
	this.topVida = 25;
	this.topHambre = 25;
	this.topFelic = 25;
	tempNivel.setNivel(this);
    }

    /*Getters*/
    public String getNombre(){
	return this.nombre;
    }

    public int getVida(){    
	return this.vida;
    }                    
    public int getHambre(){    
	return this.hambre;
    }                    
    public int getFelicidad(){    
	return this.felic;
    }                    
  
    public int getTopVida(){
	return this.topVida;
    }

    public int getTopHambre(){
	return this.topHambre;
    }

    public int getTopFelic(){
	return this.topFelic;
    }                

    /*Setters*/
    public void setMascota(General tempGeneral,Imprimir tempImprimir){
	this.tempGeneral = tempGeneral;
	this.tempImprimir = tempImprimir;
    }

   public void setVida(int temp){
	this.vida = temp;
    }

    public void setFelicidad(int temp){
	this.felic = temp;
    }

    public void setHambre(int temp){
	this.hambre = temp;
    }

    /*Metodo que modifica los atributos a traves del hilo de ejecucion*/
    public void modHilo(){
	this.vida -= ((genRand.nextInt(10000)%3) + 1);
	this.hambre += ((genRand.nextInt(10000)%3) + 1);
	this.felic -= ((genRand.nextInt(10000)%3) + 1);
	this.vida = tempGeneral.validaMin(this.vida);
	this.hambre = tempGeneral.validaTope(this.hambre,2);
	this.felic = tempGeneral.validaMin(this.felic);
	verMuerto(this.vida,this.hambre,this.felic,tempImprimir);
    }

    /*Metodo que modifica el tope de los atributos,aumentando cada que el nivel avanza*/
    public void modAtrNivel(){
	this.topVida += ((genRand.nextInt(10000) % 3) +1);
	this.topHambre += ((genRand.nextInt(10000) % 3) +1);
	this.topFelic += ((genRand.nextInt(10000) % 3) +1);
    }

    /*Metodo para ver si la mascota esta vida o no*/
    public void verMuerto(int vida,int hambre,int felicidad,Imprimir tempImprimir){
	if(vida <= 0 || hambre >= 50 || felicidad <= 0){
	    tempImprimir.imprEstad(0);
	    System.out.println("Su mascota ha muerto :'(");
	    System.exit(0);
	}
    }

    /*Metodo de suicidio de la mascota.~to do:Implementarlo en el hilo,en vez que la masota muera que se suicide*/
    public void suicidio(){
	this.vida = 0;
	this.hambre = 0;
	this.felic = 0;
	tempImprimir.imprEstad(0);
	System.out.println("Me mataste :c,asesino!");
	System.exit(0);
    }

}