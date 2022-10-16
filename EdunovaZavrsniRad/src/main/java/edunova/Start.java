/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package edunova;

import edunova.controller.ObradaDijete;
import edunova.model.Dijete;
import edunova.util.EdunovaException;

/**
 *
 * @author Veky
 */
public class Start {

    public Start() throws EdunovaException {
        /*PocetniInsert.izvedi();
        for(Posjeta p: new ObradaPosjeta().read()){
            System.out.println();
        }*/
        ObradaDijete od = new ObradaDijete();
        Dijete d = new Dijete();
        d.setIme("prvi");
        d.setPrezime("prezime");
        
        od.setEntitet(d);
        od.create();
        System.out.println(od.getEntitet().getSifra());
        
    }

    public static void main(String[] args) throws EdunovaException {
        new Start();

    }
}
