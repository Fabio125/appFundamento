/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmatricula;

import vista.VAlumno;
import vista.VCurso;
import vista.VMatricula;

/**
 *
 * @author Frequena Chuyes
 */
public class AppMatricula {

    /**
     * @param args the command line arguments
     */
    private static VCurso vcurso=null;
   // private static VAlumno valumno=null;
    private static VMatricula vmatricula=null;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
<<<<<<< Updated upstream
       vcurso=new VCurso();
        vcurso.setLocationRelativeTo(null); 
        vcurso.setResizable(false);
=======
        vcurso=new VCurso();         
        vcurso.setLocationRelativeTo(null); 
        vcurso.setResizable(false);
        vcurso.activarOpciones(1);
>>>>>>> Stashed changes
        vcurso.setVisible(true);
       
       
        /*valumno=new VAlumno();
        valumno.setLocationRelativeTo(null); 
        valumno.setResizable(false);
        valumno.setVisible(true);*/
        
<<<<<<< Updated upstream
    /*    vmatricula=new VMatricula();
        vmatricula.setLocationRelativeTo(null); 
        vmatricula.setResizable(false);
        vmatricula.setVisible(true);
    */   
=======
        /*vmatricula=new VMatricula();
        vmatricula.setLocationRelativeTo(null); 
        vmatricula.setResizable(false);
        vmatricula.setVisible(true);*/
        
>>>>>>> Stashed changes
        
        //vcurso.show();
        
    }
    
}
