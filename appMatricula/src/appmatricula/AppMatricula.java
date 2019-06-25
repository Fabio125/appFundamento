/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmatricula;

import vista.VCurso;

/**
 *
 * @author Frequena Chuyes
 */
public class AppMatricula {

    /**
     * @param args the command line arguments
     */
    private static VCurso vcurso=null;
    public static void main(String[] args) {
        // TODO code application logic here
        vcurso=new VCurso();
        vcurso.setLocationRelativeTo(null); 
        vcurso.setResizable(false);
        vcurso.setVisible(true);
        //vcurso.show();
        
    }
    
}
