/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package edunova;

import edunova.controller.ObradaDijete;
import edunova.model.Dijete;
import edunova.model.Entitet;
import edunova.model.Posjeta;
import edunova.util.EdunovaException;
import edunova.util.PocetniInsert;
import edunova.view.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veky
 */
public class Start {

    public Start() {
        new SplashScreen().setVisible(true);
      
    }

    private void testiranje(){
          /*PocetniInsert.izvedi();
        for(Posjeta p: new ObradaPosjeta().read()){
            System.out.println();
        }*/
        ObradaDijete od = new ObradaDijete();
        Dijete d = new Dijete();
        d.setIme("prvi");
        d.setPrezime("prezime");

        od.setEntitet(d);
        try {
            od.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        System.out.println(od.getEntitet().getSifra());
        
        Posjeta p = new Posjeta();
        p.setRoditeljskaPratnja(Boolean.TRUE);
        p.setGratis(Boolean.TRUE);
        //p.setOdgovornaOsoba(1);

    }
    
    public static void main(String[] args) {
        new Start();
        new PocetniInsert();  
    }
}
