package es.ieslavereda.library;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Biblioteca bibliotecaPobla = new Biblioteca();

        //Dar de alta, baja y modificar los datos de un cliente.
        Cliente blanca = new Cliente("Blanca", "1A");
        Cliente pepa = new Cliente("Pepa", "2B");
        Cliente luna = new Cliente("Luna", "3C");
        Cliente karlota = new Cliente("Karlota", "4D");
        Cliente marta = new Cliente("Marta", "5E");

        bibliotecaPobla.altaCliente(blanca);
        bibliotecaPobla.altaCliente(pepa);
        bibliotecaPobla.altaCliente(luna);
        bibliotecaPobla.altaCliente(karlota);
        bibliotecaPobla.altaCliente(marta);
        bibliotecaPobla.altaCliente(new Cliente("Emma", "6F"));

        bibliotecaPobla.bajaCliente(karlota);
        bibliotecaPobla.bajaCliente(karlota);
        luna.setDni("73X");
        luna.setNombre("Lluna");

        System.out.println(bibliotecaPobla);

        //Dar de alta cualquier tipo de publicacion
        Revista time = new Revista("Richard Stengel", 200, true, "Time", "Actualidad", Revista.Periodicidad.SEMANAL);
        bibliotecaPobla.altaPublicacion(time);
        Publicacion jueves = new Revista("RBA", 50, true, "El Jueves", "Humor", Revista.Periodicidad.MENSUAL);
        bibliotecaPobla.altaPublicacion(jueves);
        bibliotecaPobla.altaPublicacion(new Periodico("PRISA",70,false,"El Pais", LocalDate.of(2023,02,14)));
        Publicacion levante = new Periodico("Prensa iberica", 70, false, "Levante EMV", LocalDate.of(2023,02,28));
        bibliotecaPobla.altaPublicacion(levante);
//        Libro quijote = new Libro("Edi1", 500, false, "Miguel de Cervantes", "Don Quijote de la Mancha", )

//        Dar de baja cualquier tipo de publicacion

    }

}
