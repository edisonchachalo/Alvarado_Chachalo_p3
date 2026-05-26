package examenp3p2;

import java.util.ArrayList;

public class InventarioProductos {
    /* Autores
    * Alvarado Joel
    * Chachalo Edison
     */

    private ArrayList<Producto> productos;

    public InventarioProductos(){
        productos = new ArrayList<Producto>();
    }

    //Método para agregar producto con Id único
    public void agregarProducto(Producto p) throws Exception{
        for (Producto prod : productos){
            if (prod.getId() == p.getId()){
                throw new Exception("El ID "+p.getId()+" ya existe.");
            }
        }
        productos.add(p);
    }

    //Método para buscar producto por ID
    public Producto buscarPorId(int idBuscado) throws Exception{
        for (Producto prod : productos){
            if (prod.getId()==idBuscado) {
                return prod;
            }
        }
        throw new Exception("Producto con ID "+idBuscado+" no encontrado.");
    }

    //Método para buscar por categoria
    public ArrayList<Producto> buscarPorCategoria(String categoria) {
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        for (Producto prod : productos){
            if (prod.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(prod);
            }
        }
        return resultado;
    }

    //Método ordenar
    public void ordenarPorPrecioDesc() throws Exception{
        for (int i = 0; i < productos.size()-1; i++){
            for (int j = 0; j < productos.size()-i-1;j++){
                if (productos.get(j).getPrecio()<productos.get(j+1).getPrecio()){
                    Producto aux = productos.get(j);
                    productos.set(j, productos.get(j+1));
                    productos.set(j+1, aux);
                }
            }
        }
    }

    //método de búsqueda menor precio
    public  Producto buscarMenorPrecio() throws Exception{
        if (productos.isEmpty()){
            throw new Exception("El inventario está vacío");
        }
        Producto menor = productos.get(0);
        for (Producto prod : productos){
            if (prod.getPrecio() < menor.getPrecio()){
                menor = prod;
            }
        }
        return menor;
    }

    //Mostrar para mostrar todos los productos
    public String mostrarProductos(){
        String resultado = "";
        for (Producto prod : productos){
            resultado += prod.toString()+" | ";
        }
        return resultado;
    }

    //
    public Producto buscarPorNombre (String nombreBuscado) throws Exception{
        for (Producto prod : productos){
            if (prod.getNombre().equalsIgnoreCase(nombreBuscado)){
                return prod;
            }
        }
        throw new Exception("Producto con nombre "+nombreBuscado+" no encontrado");
    }

    //Cargar productos
    public void cargarDatosIniciales(){
        try {
            agregarProducto(new Producto(1,"Router","Red",10,45));
            agregarProducto(new Producto(2,"Switch","Red",15,30));
            agregarProducto(new Producto(3,"PC","Computador",5,250));
            agregarProducto(new Producto(4,"Laptop","Computador",12,350));
            agregarProducto(new Producto(5,"Teclado","Periferico",50,15.5f));
            agregarProducto(new Producto(6,"Mouse","Periferico",45,5.6f));

        } catch (Exception e){
            System.out.println("Error al cargar datos");
        }

    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
