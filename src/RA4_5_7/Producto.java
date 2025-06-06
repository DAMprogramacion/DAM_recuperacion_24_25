package RA4_5_7;

import java.util.Objects;

/**
 * Clase Producto, que es la raíz de herencia de la aplicación
 * @author manuel
 * @version  1.0
 */
public class Producto {
    private final int id;
    private String nombreProducto;
    private int duracion;
    private Genero genero;
    private String director;

    /**
     * Constructor
     * @param id clave primaria BD
     * @param nombreProducto indica el nombre del producto
     * @param duracion indica la duración del producto en minutos
     * @param genero indica el género, que puede ser Comedia, Drama, Acción o Terror
     * @param director indica el nomber del director del prodcto.
     */
    public Producto(int id, String nombreProducto, int duracion,
                    Genero genero, String director) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
    }

    /**
     * Getter para obtener el id
     * @return el valor del id, que es un valor entero
     */
    public int getId() {
        return id;
    }

    /**
     * Getter del nombre del producto
     * @return el nobre del producto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Setter del nombre del producto
     * @param nombreProducto que debe ser una cadena
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * Metodo que devueve una cadena con la información del producto
     * con el siguiente formato:
     * Nombre: Inception
     * Duración: 148 minutos
     * Género: Acción
     * Director: Nolan
     * Número de protagonistas: 3
     * @return una cadena con dicha información
     */
    public String mostrarInformacion() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre: ").append(nombreProducto).append('\n');
        builder.append("Duración: ").append(duracion).append(" minutos").append('\n');
        builder.append("Genero: ").append(genero).append('\n');
        builder.append("Director: ").append(director);
        String informacion = builder.toString();
        return informacion;
    }


}
