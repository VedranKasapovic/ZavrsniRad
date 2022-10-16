/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edunova;

import edunova.util.HibernateUtil;





/**
 *
 * @author Veky
 */
public class Start {

    public Start() {
//       PocetniInsert.izvedi();
//        for(Dijete d: new ObradaDijete().read()){
//            System.out.println(d.getIme());
  /*      ObradaDijete od = new ObradaDijete();
        Dijete d = new Dijete();
        //d.setIme("Prvi pomoću kontrolera");
        od.setEntitet(d);
        try {
            od.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        System.out.println(od.getEntitet().getSifra());
*/  HibernateUtil.getSession();
    
    }

    public static void main(String[] args) {
        new Start();

    }
}
