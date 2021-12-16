package Objetos;

import java.util.Arrays;

public class Ingresos {
    private String [] Tipo = {"Domestico", "Salvaje", "Otro"};
    private String [] Enfermedad = {"Brucelosis", "Fiebre Aftosa", "Salmonella", "Rabia"};
    private int [] TipoPrecio = {25000, 45000, 18000};
    private int [] EnfermedadPrecio = {75000, 22500, 35000, 54000};

    public Ingresos() {

    }

    public String[] getTipo() {
        return Tipo;
    }

    public void setTipo(String[] tipo) {
        Tipo = tipo;
    }

    public String[] getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        Enfermedad = enfermedad;
    }

    public int[] getTipoPrecio() {
        return TipoPrecio;
    }

    public void setTipoPrecio(int[] tipoPrecio) {
        TipoPrecio = tipoPrecio;
    }

    public int[] getEnfermedadPrecio() {
        return EnfermedadPrecio;
    }

    public void setEnfermedadPrecio(int[] enfermedadPrecio) {
        EnfermedadPrecio = enfermedadPrecio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingresos ingresos = (Ingresos) o;
        return Arrays.equals(Tipo, ingresos.Tipo) && Arrays.equals(Enfermedad, ingresos.Enfermedad);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(Tipo);
        result = 31 * result + Arrays.hashCode(Enfermedad);
        return result;
    }

    public int Resultado(int TipoPrecio, int EnfermedadPrecio){

        return TipoPrecio + EnfermedadPrecio;
    }


}
