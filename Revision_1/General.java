/*Clase con metodos generales de la mascota*/

import java.util.*;

public class General{

    //Random para hacer las cosas mas interesantes
    Random genRand = new Random();
    
    //Atributos de la clase,son objetos que se referenciaran
    private Mascota tempMascota;
    private Niveles tempNivel;
    
    //Referenciar los atibutos
    public void setGeneral(Niveles tempNivel,Mascota tempMascota){
	this.tempNivel = tempNivel;
	this.tempMascota = tempMascota;
    }

    //Metodo que alimenta a la mascota,se valida que no este en el tope y hace las sumas y restas necesarias
    public void alimentar(Mascota tempMascota,int subVida,int bajHambre,int subFelicidad){
	int validVida,validHambre,validFelicidad;
	if(subVida < 50){
	    validVida = tempMascota.getVida() + ((genRand.nextInt(10000) % 5) + 1);
	    validVida = validaTope(validVida);
	    tempMascota.setVida(validVida);
	}
	
	if(subFelicidad < 50){
	    validFelicidad = tempMascota.getFelicidad() + ((genRand.nextInt(10000) % 5) + 1);
	    validFelicidad = validaTope(validFelicidad);
	    tempMascota.setFelicidad(validFelicidad);
	}

	if(bajHambre > 0){
	    validHambre = tempMascota.getHambre() - ((genRand.nextInt(10000) % 5) + 1);
	    validHambre = validaMin(validHambre);
	    tempMascota.setHambre(validHambre);
	}
    }

    //Metodo que simula que la mascota juegue,se valida que los atributos no esten en su tope y hace las sumas y restas necesarias
    public void jugar(Mascota tempMascota,int bajVida,int subHambre,int subFelicidad){
	int validVida,validHambre,validFelicidad;
	if(bajVida > 0){
	    validVida = tempMascota.getVida() - ((genRand.nextInt(10000) % 5) + 1);						 
	    validVida = validaMin(validVida);
	    tempMascota.setVida(validVida);
	}
	if(subHambre < 50){
	    validHambre = tempMascota.getHambre() + ((genRand.nextInt(10000) % 5) + 1);
	    validHambre = validaTope(validHambre);
	    tempMascota.setHambre(validHambre);
	}
	if(subFelicidad < 50){
	    validFelicidad = tempMascota.getFelicidad() + ((genRand.nextInt(10000) % 5) + 1);
	    validFelicidad = validaTope(validFelicidad);
	    tempMascota.setFelicidad(validFelicidad);
	}
    }

    public void entrenar(){
	tempNivel.subNivel();
    }
    
    /*Metodos de validacion,tanto tope maximo como tope minimo*/
    public int validaTope(int temp){
	if(temp > tempMascota.getTopeGen()){
	    return tempMascota.getTopeGen();
	}
	return temp;
    }
    
    public int validaMin(int temp){
	if(temp < 0){
	    return 0;
	}
	return temp;
    }
}