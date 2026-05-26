package examenp3p2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtIDP1;
    private JTextField txtNombreP1;
    private JComboBox cmbCategoriaP1;
    private JTextField txtCantidadP1;
    private JTextField txtPrecioP1;
    private JButton btnAgregarP1;
    private JButton btnModificarP1;
    private JButton btnMostrarP1;
    private JButton btnOrdenarPrecioP2;
    private JTextField txtNombreP2;
    private JButton btnBuscarNombreP2;
    private JList listP2;
    private JButton btnMostrarP2;
    private JList listP1;

    private InventarioProductos inventario;
    private DefaultListModel dlmP1;
    private DefaultListModel dlmP2;

    public Ventana(){
        inventario = new InventarioProductos();
        inventario.cargarDatosIniciales();

        dlmP1 = new DefaultListModel();
        dlmP2 = new DefaultListModel();


        btnAgregarP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIDP1.getText());
                    String nombre = txtNombreP1.getText();
                    String categoria = cmbCategoriaP1.getSelectedItem().toString();
                    int cantidad = Integer.parseInt(txtCantidadP1.getText());
                    float precio = Float.parseFloat(txtPrecioP1.getText());

                    inventario.agregarProducto(new Producto(id,nombre,categoria,cantidad,precio));
                    mostrarListaP1();
                    limpiarCamposP1();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        btnModificarP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listP1.getSelectedIndex();
                if (index != -1){
                    Producto seleccionado = inventario.getProductos.get(index);
                }
            }
        });
    }



}
