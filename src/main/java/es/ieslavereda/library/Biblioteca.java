package es.ieslavereda.library;

import es.ieslavereda.tad.ListLib;

public class Biblioteca {

    private ListLib<Cliente> clientes;
    private ListLib<Publicacion> publicaciones;

    public Biblioteca() {
        clientes = new ListLib<>();
        publicaciones = new ListLib<>();
    }

    public void altaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean bajaCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            cliente.devolverTodo();
            clientes.remove(clientes.search(cliente));
            return true;
        }
        return false;
    }

    public void altaPublicacion(Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    public boolean bajaPublicacion(Publicacion publicacion){
        if(publicaciones.contains(publicacion)){
            publicaciones.remove(publicaciones.search(publicacion));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Biblioteca: " +
                "\n clientes=" + clientes +
                "\n publicaciones=" + publicaciones;
    }

    //    Dar de alta cualquier tipo de publicacion
//    Dar de baja cualquier tipo de publicacion
//    Prestar y devolver un ejemplar de un libro


}
