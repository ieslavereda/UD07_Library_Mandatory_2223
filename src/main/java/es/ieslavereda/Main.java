package es.ieslavereda;

import es.ieslavereda.library.*;

public class Main {

    public static void main(String[] args) {
        Cliente cliente;
        Libro libro;
        Ejemplar e1,e2,e3,e4;

        cliente = new Cliente("Joaquin Alonso", "1234");
        libro = new Libro("Bruguera", 140, Publicacion.Impresion.COLOR, "Uno cualquiera", "Un titulo", "123455123");
        libro.crearEjemplares(10);

        e1 = libro.getEjemplar(1);
        e2 = libro.getEjemplar(2);
        e3 = libro.getEjemplar(3);
        e4 = libro.getEjemplar(4);

        cliente.prestar(e1);
        cliente.prestar(e2);
        cliente.prestar(e3);


        cliente.devolver(e1);
        cliente.devolver(e3);
        cliente.devolver(e2);

//        Biblioteca bibliotecaPobla = new Biblioteca();
//
//        //Dar de alta, baja y modificar los datos de un cliente.
//        Cliente blanca = new Cliente("Blanca", "1A");
//        Cliente pepa = new Cliente("Pepa", "2B");
//        Cliente luna = new Cliente("Luna", "3C");
//        Cliente karlota = new Cliente("Karlota", "4D");
//        Cliente marta = new Cliente("Marta", "5E");
//
//        bibliotecaPobla.altaCliente(blanca);
//        bibliotecaPobla.altaCliente(pepa);
//        bibliotecaPobla.altaCliente(luna);
//        bibliotecaPobla.altaCliente(karlota);
//        bibliotecaPobla.altaCliente(marta);
//        bibliotecaPobla.altaCliente(new Cliente("Emma", "6F"));
//
//        bibliotecaPobla.bajaCliente(karlota);
//        bibliotecaPobla.bajaCliente(karlota);
//        luna.setDni("73X");
//        luna.setNombre("Lluna");
//
////        System.out.println(bibliotecaPobla);
//
//        //Dar de alta cualquier tipo de publicacion
//        Revista time = new Revista("Richard Stengel", 200, true, "Time", "Actualidad", Revista.Periodicidad.SEMANAL);
//        bibliotecaPobla.altaPublicacion(time);
//        Publicacion jueves = new Revista("RBA", 50, true, "El Jueves", "Humor", Revista.Periodicidad.MENSUAL);
//        bibliotecaPobla.altaPublicacion(jueves);
//
//        bibliotecaPobla.altaPublicacion(new Periodico("PRISA",70,false,"El Pais", LocalDate.of(2023,02,14)));
//        Publicacion levante = new Periodico("Prensa iberica", 70, false, "Levante EMV", LocalDate.of(2023,02,28));
//        bibliotecaPobla.altaPublicacion(levante);
//
//        Libro quijote = new Libro("Edi1", 500, false, "Miguel de Cervantes", "Don Quijote de la Mancha", "ISBN1", 5);
//        Libro cienanyos = new Libro("Edi2", 300, false, "Gabriel García Márquez", "Cien años de soledad", "ISBN2", 3);
//        Libro hombresno = new Libro("Edi3", 400, false, "Stieg Larsson", "Los hombres que no amaban a las mujeres", "ISBN3", 1);
//        Libro guardian = new Libro("Edi4", 170, false, "Salinger", "El guardián entre el centeno", "ISBN4", -1);
//        bibliotecaPobla.altaPublicacion(quijote);
//        bibliotecaPobla.altaPublicacion(cienanyos);
//        bibliotecaPobla.altaPublicacion(hombresno);
//        bibliotecaPobla.altaPublicacion(guardian);
//
//        Publicacion borrar1 = new Libro("Edix", 100, true, "xxx", "para borrar", "ISBNX", 20);
//        Publicacion borrar2 = new Revista("RBA", 50, true, "El Jueves", "Humor", Revista.Periodicidad.MENSUAL);
//        Publicacion borrar3 = new Periodico("Prensa iberica", 70, false, "Levante EMV", LocalDate.of(2023,02,28));
//        bibliotecaPobla.altaPublicacion(borrar3);
//        bibliotecaPobla.altaPublicacion(borrar2);
//        bibliotecaPobla.altaPublicacion(borrar1);
//
////        System.out.println(bibliotecaPobla);
//
//        // Dar de baja cualquier tipo de publicacion
//        bibliotecaPobla.bajaPublicacion(borrar1);
//        bibliotecaPobla.bajaPublicacion(borrar1);
//        bibliotecaPobla.bajaPublicacion(borrar2);
//        bibliotecaPobla.bajaPublicacion(borrar1);
//        bibliotecaPobla.bajaPublicacion(borrar3);
//
////        System.out.println(bibliotecaPobla);
//
//        // Prestar o devolver ejemplar de un libro
//        bibliotecaPobla.devolverEjemplarLibro(guardian,pepa);
//        bibliotecaPobla.prestarEjemplarLibro(guardian,pepa);
//        bibliotecaPobla.prestarEjemplarLibro(guardian,pepa);
//        bibliotecaPobla.devolverEjemplarLibro(guardian,pepa);
//
//        bibliotecaPobla.devolverEjemplarLibro(hombresno,pepa);
//        bibliotecaPobla.prestarEjemplarLibro(hombresno,pepa);
//        bibliotecaPobla.prestarEjemplarLibro(hombresno,pepa);
//        bibliotecaPobla.devolverEjemplarLibro(hombresno,pepa);
//
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.devolverEjemplarLibro(quijote,luna);
//        bibliotecaPobla.devolverEjemplarLibro(quijote,luna);
//        bibliotecaPobla.devolverEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//        bibliotecaPobla.prestarEjemplarLibro(quijote,luna);
//
//        bibliotecaPobla.prestarEjemplarLibro(cienanyos,luna);
//        bibliotecaPobla.prestarEjemplarLibro(cienanyos,blanca);
//        bibliotecaPobla.prestarEjemplarLibro(cienanyos,blanca);
//
//        for (int i = 0; i < quijote.getCantidadEjemplares(); i++) {
//            System.out.println(quijote.getEjemplares().get(i).getHistoricoPrestados().toString());
//        }
//
//        System.out.println(bibliotecaPobla);

    }

}
