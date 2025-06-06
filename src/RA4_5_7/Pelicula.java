package RA4_5_7;

public class Pelicula extends Producto{
    private int numeroProtagonistas;

    public Pelicula(int id, String nombreProducto, int duracion, Genero genero, String director,
                    int numeroProtagonistas) {
        super(id, nombreProducto, duracion, genero, director);
        if (numeroProtagonistas > 0)
            this.numeroProtagonistas = numeroProtagonistas;

    }
    public int getNumeroProtagonistas() {
        return numeroProtagonistas;
    }

    public void setNumeroProtagonistas(int numeroProtagonistas) {
        if (numeroProtagonistas > 0)
            this.numeroProtagonistas = numeroProtagonistas;
    }

    @Override
    public String mostrarInformacion() {
        StringBuilder builder = new StringBuilder();
        builder.append(mostrarInformacion()).append('\n');
        builder.append("Nº protagonistas: ").append(numeroProtagonistas);
        String informacion = builder.toString();
        return informacion;
    }
}



