/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.util.Arrays;

/**
 *
 * @author Frequena Chuyes
 */
public class UCurso {    

    private Object[] arreglo;
    private Object[] propiedad;
    private int npropiedad=5;
    
    public UCurso(){}
      
    public boolean arregloCreado(){
    
        return arreglo!=null;
    }    
       
    public void crearCurso(
            String idcurso,
            String nombre,
            int ncredito,
            int ciclo,
            String prerequisito){       
       
       int nelementos;  
       propiedad=new Object[npropiedad];
       
       if(!arregloCreado())      
       {    
            arreglo=new Object[1];
            propiedad[0]=idcurso;
            propiedad[1]=nombre;
            propiedad[2]=ncredito;
            propiedad[3]=ciclo;
            propiedad[4]=prerequisito;
            arreglo[0]=propiedad;            
            
       }else{
       
            nelementos=arreglo.length+1;
            arreglo= Arrays.copyOf(arreglo, nelementos);
            propiedad[0]=idcurso;
            propiedad[1]=nombre;
            propiedad[2]=ncredito;
            propiedad[3]=ciclo;
            propiedad[4]=prerequisito;
            arreglo[nelementos-1]=propiedad;    
       }
    }
    
    public int posicionCodigo(String idcurso){
    
        int pos=-1;
        
        if(arregloCreado()){
        
            for(int i=0;i<arreglo.length;i++){
                
                if(String.valueOf(((Object[])arreglo[i])[0]).equalsIgnoreCase(idcurso)){
                
                    pos=i;
                    break;
                }
            }
        }                
        return pos;
    }
    
    public Object[] reportarCurso(){
    
        return arreglo;        
    }
}
