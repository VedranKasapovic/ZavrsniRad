/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import edunova.model.Dijete;
import edunova.model.Posjeta;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public class PosjetaTableModel extends AbstractTableModel {

    private String[] colNames = new String[]{"Djete", "Vrijeme dolaska", "Vrijeme odlaska", "Plaćeno", "Roditeljska pratnja", "Gratis", "Ormarić"};

    public Class[] m_colTypes = {String.class, String.class, String.class, Boolean.class,
        Boolean.class, Boolean.class, Integer.class};

    private List<Posjeta> posjete;
    private SimpleDateFormat df;

    public PosjetaTableModel(List<Posjeta> posjete) {
        this.posjete = posjete;
        df = new SimpleDateFormat("HH:mm");

    }

    @Override
    public int getRowCount() {
        return posjete == null ? 0 : posjete.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var p = posjete.get(rowIndex);
        switch (columnIndex) {
            case 0:
                String djeca;
                djeca = "";
                for (Dijete d : p.getDjeca()) {
                    djeca += d.getIme() + " " + d.getPrezime() + ", ";
                }
                if (djeca.length() > 2) {
                    djeca = djeca.substring(0, djeca.length() - 2);
                }
                return djeca;
            case 1:
                if (p.getVrijemeDolaska() != null) {
                    return df.format(p.getVrijemeDolaska());
                } else {
                    return "";
                }
            case 2:
                if (p.getVrijemeOdlaska() != null) {
                    return df.format(p.getVrijemeOdlaska());
                } else {
                    return "";
                }
            case 3:
                return p.isPlaceno();
            case 4:
                return p.isRoditeljskaPratnja();
            case 5:
                return p.isGratis();
            case 6:
                return p.getOrmaric();
        }
        return "";
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    public Class getColumnClass(int col) {
        return m_colTypes[col];
    }

    public Posjeta getPosjeta(int rowIndex) {
        return posjete.get(rowIndex);
    }

}
