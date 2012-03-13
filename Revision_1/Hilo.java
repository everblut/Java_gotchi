/*Clase del hilo de ejecucion*/

import java.util.*;

public class Hilo implements Runnable{
    
    //Atributos de la clase
    private Mascota tempMascota;
    private Imprimir tempImprimir;

    //Referenciar los atributos
    public void setHilo(Mascota tempMascota,Imprimir tempImprimir){
	this.tempMascota = tempMascota;
	this.tempImprimir = tempImprimir;
    }

    //Metodo que usa el hilo para existir,llamado en main
    /*La logica seguida fue:
      ~Decidi que cada 5 minutos,se haga un "refresh" de los estados de la mascota,es decir,que baje su vida,suba su hambre,etc.
      ~Esto se logro a partir de tomar la hora del sistema y en un ciclo infinito ir haciendo diferencias entre otra hora del sistema,asi que cuando la diferencia sea 5 minutos (300000 milisegundos) se modificaran los atributos.
     */
    public void run(){
	long start = System.currentTimeMillis();
	while(true){
	    long end = System.currentTimeMillis();
	    long diff = end - start;
	    if(diff >= 3000){
		tempMascota.modHilo();
		System.out.print("\n\n~~Pasaron 5 minutos~~\n\n");
		tempImprimir.imprEstad(1);
		start = System.currentTimeMillis();
	    }
	}
    }

}