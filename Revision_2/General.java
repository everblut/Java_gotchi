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
	//If que compara si el valor que entra de vida es menor a lo maximo que se puede tener,para poder aumentar su vida,si no,le deja el valor del maximo
	if(subVida < tempMascota.getTopVida()){
	    validVida = tempMascota.getVida() + ((genRand.nextInt(10000) % 5) + 1);
	    validVida = validaTope(validVida,1);
	    tempMascota.setVida(validVida);
	}
	//If que realiza lo mismo que el If para la vida,pero con el atributo de felicidad
	if(subFelicidad < tempMascota.getTopFelic()){
	    validFelicidad = tempMascota.getFelicidad() + ((genRand.nextInt(10000) % 5) + 1);
	    validFelicidad = validaTope(validFelicidad,3);
	    tempMascota.setFelicidad(validFelicidad);
	}
	//If que verifica que el hambre sea mayor a 0 para poder reducir el atributo
	if(bajHambre > 0){
	    validHambre = tempMascota.getHambre() - ((genRand.nextInt(10000) % 5) + 1);
	    validHambre = validaMin(validHambre);
	    tempMascota.setHambre(validHambre);
	}
    }

    //Metodo que simula que la mascota juegue,se valida que los atributos no esten en su tope y hace las sumas y restas necesarias
    public void jugar(Mascota tempMascota,int bajVida,int subHambre,int subFelicidad){
	int validVida,validHambre,validFelicidad;
	//Los if siguen la misma logica que con el metodo de alimentar
	if(bajVida > 0){
	    validVida = tempMascota.getVida() - ((genRand.nextInt(10000) % 5) + 1);						 
	    validVida = validaMin(validVida);
	    tempMascota.setVida(validVida);
	}
	if(subHambre < tempMascota.getTopHambre()){
	    validHambre = tempMascota.getHambre() + ((genRand.nextInt(10000) % 5) + 1);
	    validHambre = validaTope(validHambre,2);
	    tempMascota.setHambre(validHambre);
	}
	if(subFelicidad < tempMascota.getTopFelic()){
	    validFelicidad = tempMascota.getFelicidad() + ((genRand.nextInt(10000) % 5) + 1);
	    validFelicidad = validaTope(validFelicidad,3);
	    tempMascota.setFelicidad(validFelicidad);
	}
    }

    public void entrenar(){
	tempNivel.subNivel();
    }
    
    /*Metodos de validacion,tanto tope maximo como tope minimo
      Se utiliza como parametros:
      temp -> valor del atributo con el cual se accese al metodo 
      cambia -> se utiliza en un switch para poder manejar por separado el tope del atributo con el cual se accese al metodo donde:
         1->TopVida
	 2->TopHambre 
	 3->TopFelicidad
    */
    public int validaTope(int temp,int cambia){
	//Para cada caso: si el resultado de la adicion es mayor al tope,regresara el valor del tope;si no,regresara el valor de la adicion*Adicion realizada en los metodos de alimentar o jugar*
	switch(cambia){
	    
	case 1:
	    if(temp > tempMascota.getTopVida()){
		return tempMascota.getTopVida();
	    }
	    else{
		return temp;
	    }
	    
	case 2:
	    if(temp > tempMascota.getTopHambre()){
		return tempMascota.getTopHambre();
	    }
	    else{
		return temp;
	    }

	case 3:
	    if(temp > tempMascota.getTopFelic()){
		return tempMascota.getTopFelic();
	    }
	    else{
		return temp;
	    }
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