package RA4_5_7;

public class Serie extends Producto{
    private int temporadas;
    private int capitulos;

    public Serie(int id, String nombreProducto, int duracion, Genero genero, String director,
                 int temporadas, int capitulos) {
        super(id, nombreProducto, duracion, genero, director);
        if (temporadas > 0)
            this.temporadas = temporadas;
        if (capitulos > 0)
            this.capitulos = capitulos;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        if (temporadas > 0)
            this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        if (capitulos > 0)
            this.capitulos = capitulos;
    }

    @Override
    public String mostrarInformacion() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.mostrarInformacion()).append('\n');
        builder.append("Temporadas: ").append(temporadas).append('\n');
        builder.append("Capítuloss: ").append(capitulos);
        String informacion = builder.toString();
        return informacion;
    }
}
