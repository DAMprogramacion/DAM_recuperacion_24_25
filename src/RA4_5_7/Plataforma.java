package RA4_5_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Plataforma {
    private String nombrePlataforma;
    private List<Producto> productos = new ArrayList<>();

    public Plataforma(String nombrePlataforma) {
        this.nombrePlataforma = nombrePlataforma;
    }
    public void agregarProducto(Producto producto) {
        if (! productos.contains(producto))
            productos.add(producto);
    }
    public void mostrarInformación() {
        System.out.println(nombrePlataforma);
        System.out.println("================================");
        for (Producto producto : productos){
            System.out.println(producto.mostrarInformacion());
            System.out.println("-------------------------------");
        }
    }
    public long obtenerProductosPorGenero (Genero genero) {
        return productos.stream().
                filter(producto -> producto.getGenero().equals(genero)).
                count();
    }
    public long obtenerDuracionProductos() {
        return productos.stream().
                mapToInt(Producto::getDuracion).
                sum();
    }
    public long obtenerPeliculasPorProtagonistas (int protagonistas){
        return productos.stream().
                filter(producto -> producto instanceof Pelicula).
                filter(producto -> ((Pelicula) producto).getNumeroProtagonistas() > protagonistas).
                count();
    }
    public static void cargarProductosDesdeArchivo(String nombreArchivo, Plataforma plataforma) {
        Path path = Path.of(nombreArchivo);
        try {
            List<String> lineas = Files.readAllLines(path);
            for (String linea : lineas) {
                String[] tokens = linea.split(",");
                int id = Integer.parseInt(tokens[1]);
                String nombre = tokens[2];
                int duracion = Integer.parseInt(tokens[3]);
                String sGenero = tokens[4].toLowerCase();
                Genero genero = null;
                switch (sGenero) {
                    case "acción" -> genero = Genero.ACCION;
                    case "terror" -> genero = Genero.TERROR;
                    case "drama"  -> genero = Genero.DRAMA;
                    case  "comedia"      -> genero = Genero.COMEDIA;
                }
                String director = tokens[5];
                if (tokens[0].equalsIgnoreCase("pelicula")) {
                    int numeroProtagonistas = Integer.parseInt(tokens[6]);
                    Producto pelicula = new Pelicula(
                            id, nombre, duracion, genero, director, numeroProtagonistas);
                    plataforma.agregarProducto(pelicula);
                } else {
                    int temporadas = Integer.parseInt(tokens[6]);
                    int capitulos  = Integer.parseInt(tokens[7]);
                    Producto pelicula = new Serie(
                            id, nombre, duracion, genero, director, temporadas, capitulos);

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
