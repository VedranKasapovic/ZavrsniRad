/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Veky
 */
public class IgraonicaListModel<T> extends DefaultListModel<T>{

    public IgraonicaListModel(List<T> podaci) {
        super();
        addAll(podaci);
    }  
}
