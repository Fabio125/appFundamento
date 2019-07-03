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
public class UAlumno {
    
    private Object[] arreglo;
    private Object[] propiedad;
    private int npropiedad=3;
    
    public boolean arregloCreado(){
    
        return arreglo!=null;
    } 
    
    public void crearAlumno(
            String idAlumno,
            String nombre){       
       
       int nelementos;  
       propiedad=new Object[npropiedad];
       
       if(!arregloCreado())      
       {    
            arreglo=new Object[1];  
            propiedad[0]=1;
            propiedad[1]=idAlumno;
            propiedad[2]=nombre;                       
            arreglo[0]=propiedad;            
            
       }else{
       
            nelementos=arreglo.length+1;
            arreglo= Arrays.copyOf(arreglo, nelementos);
            propiedad[0]=nelementos;
            propiedad[1]=idAlumno;
            propiedad[2]=nombre;                                           
            arreglo[nelementos-1]=propiedad;    
       }
    }
    
    public Object[] reportarAlumno(){
    
        return arreglo;        
    }
    
    public int posicionCodigo(String idalumno){
    
        int pos=-1;
        
        if(arregloCreado()){
        
            for(int i=0;i<arreglo.length;i++){
                
                if(String.valueOf(((Object[])arreglo[i])[1]).equals(idalumno)){
                
                    pos=i;
                    break;
                }
            }
        }                
        return pos;
    }
    
    public void modificaAlumno( 
            int index,
            String idalumno,
            String nombre ){
    
        if(arregloCreado()){
            
            propiedad=new Object[npropiedad];
            propiedad[0]=index+1;
            propiedad[1]=idalumno;
            propiedad[2]=nombre;          
            arreglo[index]=propiedad;
        }
    }
    
    public void elimnarAlumno(int index){
    
         Object[] arreglo_aux;
         int j=0;
         
         if(arregloCreado()){
         
             arreglo_aux=new Object[arreglo.length-1];
             
             for(int i=0;i<arreglo.length;i++)
             {
                 if(i!=index){
                     
                     arreglo_aux[j]=arreglo[i];                     
                     j++;
                 }             
             }
             
             arreglo=arreglo_aux;
             darPosicion();
         }
    }
    
    public void darPosicion(){
    
         int k=1;
         
         if(arregloCreado()){
          
              for(int i=0; i<arreglo.length; i++) { 
              
                  ((Object[])arreglo[i])[0]=k;
                  k++;
              }         
         }
    }
    
    public int[] posicionCadenaEnNombre(String cadena, int index){
        
       int cont=0;
       int j=0;
       int[] pos=null;
       
       for(int i=0;i<arreglo.length;i++){
       
           if(String.valueOf(((Object[])arreglo[i])[index]).contains(cadena)){
               
               cont++;
           }
       }
       
       if(cont>0){
       
            pos=new int[cont];     
           
            for(int i=0;i<arreglo.length;i++){
       
                if(String.valueOf(((Object[])arreglo[i])[index]).contains(cadena)){

                   pos[j]=i;
                   j++;
                }
            }
       }
       
       return pos;
    }
    
    public Object[] reportarAlumnoxNombre(String nombre){
    
         Object[] arreglo_aux=null;
         int[] pos;
         
         if(arregloCreado()){
          
             pos=posicionCadenaEnNombre(nombre,2);
             
             if(pos!=null){
             
                 if(pos.length>0){
                 
                     arreglo_aux=new Object[pos.length];
                     
                     for(int i=0;i<pos.length;i++){
                     
                         arreglo_aux[i]=arreglo[pos[i]];
                     }
                 }
             }
             
         }
        return arreglo_aux;        
    }
    
    public void ordenarAlumnoxNombre(){
    
         Object[] arreglo_aux;      
         
          if(arregloCreado()){
          
              for(int i=1; i<=arreglo.length; i++) {  
                  
                for(int j=0; j<arreglo.length-i; j++) { 
                    
                    if(((String)((Object[])arreglo[j])[2]).
                            compareTo( (String)((Object[])arreglo[j+1])[2] ) > 0 ) { 
                        arreglo_aux   = (Object[])arreglo[j]; 
                        arreglo[j] =(Object[])arreglo[j+1]; 
                        arreglo[j+1]= arreglo_aux; 
                    }    
                } 
            }    
              darPosicion();
             
         }
    }
}
