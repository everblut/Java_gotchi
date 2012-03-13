/*Clase que contiene los metodos de impresion en pantalla*/

import java.util.*;

public class Imprimir{

    /*Atributos de la clase*/
    private Mascota tempMascota;
    private General tempGeneral;
    private Niveles tempNivel;

    /*Referenciar los atributos para que sean los mismos en todo el programa*/
    public void setImprimir(Mascota tempMascota,General tempGeneral,Niveles tempNivel){
	this.tempMascota = tempMascota;
	this.tempGeneral = tempGeneral;
	this.tempNivel = tempNivel;
    }
 
   /*Metodo de impresion de estadisticas de la mascota,utilize una temporal para mostrar el menu de opciones cuando temp -> 1,y sera 1 cuando el metodo sea llamado por parte del hilo.No es lo mas optimo.*/
    public void imprEstad(int temp){
	System.out.println("~~Estadisticas de "+tempMascota.getNombre()+"~~");
	System.out.println("Vida: "+tempMascota.getVida()+"/"+tempMascota.getTopVida());
	System.out.println("Hambre: "+tempMascota.getHambre()+"/"+tempMascota.getTopHambre());
	System.out.println("Felicidad: "+tempMascota.getFelicidad()+"/"+tempMascota.getTopFelic());
	System.out.println("Nivel: "+tempNivel.getNivel());
	System.out.println("Experiencia: "+tempNivel.getExperiencia()+"/"+tempNivel.getSigNivel());
	System.out.println("Siguiente nivel: "+tempNivel.getSigNivel());
	if(temp == 1){
	    System.out.println("~~Que desea hacer con su mascota?~~");
	    System.out.println("1.-Alimentar mascota");               
	    System.out.println("2.-Jugar con mascota");               
	    System.out.println("3.-Entrenar mascota");                
	    System.out.println("4.-Salir del juego");                 
	    System.out.print("Numero de opcion: ");                   
	}
    }

    /*Impresion del menu en pantalla e ir a los otros metodos*/
    public void menu(){
	Scanner scanf = new Scanner(System.in);
	int opc;
	System.out.println("~~Que desea hacer con su mascota?~~");
	System.out.println("1.-Alimentar mascota");
	System.out.println("2.-Jugar con mascota");
	System.out.println("3.-Entrenar mascota");
	System.out.println("4.-Salir del juego");
	System.out.print("Numero de opcion: ");
	opc = scanf.nextInt();
	switch(opc){
	    
	case 1:
	    //Ir al metodo alimentar
	    tempGeneral.alimentar(tempMascota,tempMascota.getVida(),tempMascota.getHambre(),tempMascota.getFelicidad());
	    break;
	    
	case 2:
	    //Ir al metodo jugar
	    tempGeneral.jugar(tempMascota,tempMascota.getVida(),tempMascota.getHambre(),tempMascota.getFelicidad());
	    break;

	case 3:
	    //Ir al metodo entrenar
	    tempGeneral.entrenar();
	    break;

	case 4:
	    //Salida de la ejecucion del programa
	    System.exit(0);

	default:
	    System.out.println("Opcion invalida");
	}
	//Validar que la mascota siga viva
	tempMascota.verMuerto(tempMascota.getVida(),tempMascota.getHambre(),tempMascota.getFelicidad(),this);
    }
}