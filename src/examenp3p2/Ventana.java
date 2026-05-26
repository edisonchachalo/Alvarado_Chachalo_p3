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
                    Producto seleccionado = inventario.getProductos().get(index);
                    seleccionado.setNombre(txtNombreP1.getText());
                    seleccionado.setCategoria(cmbCategoriaP1.getSelectedItem().toString());
                    seleccionado.setCantidad(Integer.parseInt(txtCantidadP1.getText()));
                    seleccionado.setPrecio(Float.parseFloat(txtPrecioP1.getText()));
                    mostrarListaP1();
                    limpiarCamposP1();
                } else {
                    JOptionPane.showMessageDialog(null,"Seleccione un producto de la lista para modificar");
                }
            }
        });
        btnMostrarP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaP1();
            }
        });
        btnOrdenarPrecioP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inventario.ordenarPorPrecioDesc();
                } catch (Exception ex) {
                    mostrarListaP2();
                }
                mostrarListaP2();
            }
        });
        btnMostrarP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaP2();

            }
        });
        btnBuscarNombreP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombreP2.getText();
                    Producto encontrado = inventario.buscarPorNombre(nombre);
                    dlmP2.removeAllElements();
                    dlmP2.addElement(encontrado.toString());
                    listP2.setModel(dlmP2);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void mostrarListaP1(){
        DefaultListModel dlm = new DefaultListModel();
        for (Producto p : inventario.getProductos()){
            dlm.addElement(p.toString());
        }
        listP1.setModel(dlm);
    }

    public void mostrarListaP2(){
        DefaultListModel dlm = new DefaultListModel();
        for (Producto p : inventario.getProductos()){
            dlm.addElement(p.toString());
        }
        listP2.setModel(dlm);
    }

    private void limpiarCamposP1(){
        txtIDP1.setText("");
        txtNombreP1.setText("");
        cmbCategoriaP1.setSelectedIndex(0);
        txtCantidadP1.setText("");
        txtPrecioP1.setText("");
    }

    //list

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
