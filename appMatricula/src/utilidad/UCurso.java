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
    private int npropiedad=6;
    
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
            propiedad[0]=1;
            propiedad[1]=idcurso;
            propiedad[2]=nombre;
            propiedad[3]=ncredito;
            propiedad[4]=ciclo;
            propiedad[5]=prerequisito;            
            arreglo[0]=propiedad;            
            
       }else{
       
            nelementos=arreglo.length+1;
            arreglo= Arrays.copyOf(arreglo, nelementos);
            propiedad[0]=nelementos;
            propiedad[1]=idcurso;
            propiedad[2]=nombre;
            propiedad[3]=ncredito;
            propiedad[4]=ciclo;
            propiedad[5]=prerequisito;          
            arreglo[nelementos-1]=propiedad;    
       }
    }
    
    public int posicionCodigo(String idcurso){
    
        int pos=-1;
        
        if(arregloCreado()){
        
            for(int i=0;i<arreglo.length;i++){
                
                if(String.valueOf(((Object[])arreglo[i])[1]).equalsIgnoreCase(idcurso)){
                
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
    
    public void modificaCurso( 
            int index,
            String idcurso,
            String nombre,
            int ncredito,
            int ciclo,
            String prerequisito){
    
        if(arregloCreado()){
            
            propiedad=new Object[npropiedad];
            propiedad[0]=index+1;
            propiedad[1]=idcurso;
            propiedad[2]=nombre;
            propiedad[3]=ncredito;
            propiedad[4]=ciclo;
            propiedad[5]=prerequisito;
            arreglo[index]=propiedad;
        }
    }
    
    public void elimnarCurso(int index){
    
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
    
    public int[] posicionCadenaEnCurso(String cadena, int index){
        
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
    
    public Object[] reportarCursoxNombre(String nombre){
    
         Object[] arreglo_aux=null;
         int[] pos;
         
         if(arregloCreado()){
          
             pos=posicionCadenaEnCurso(nombre,2);
             
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
    
    public Object[] reportarCursoxCiclo(int nciclo){
    
         Object[] arreglo_aux=null;
         int[] pos;
         
         if(arregloCreado()){
          
             pos=posicionCadenaEnCurso(String.valueOf(nciclo),4);
             
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
    
    public void ordenarCursoxNombre(){
    
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
    
    
    public void ordenarCursoxCiclo(){
    
         Object[] arreglo_aux;
    
          if(arregloCreado()){
          
              for(int i=1; i<=arreglo.length; i++) {  
                  
                for(int j=0; j<arreglo.length-i; j++) { 
                    
                    if(((int)((Object[])arreglo[j])[4])<=
                             (int)((Object[])arreglo[j+1])[4]) { 
                        arreglo_aux   = (Object[])arreglo[j]; 
                        arreglo[j] =(Object[])arreglo[j+1]; 
                        arreglo[j+1]= arreglo_aux; 
                    }    
                } 
            }   
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
}
