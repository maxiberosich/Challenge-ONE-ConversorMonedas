package org.example.modelos;

public class Conversion {

    private String nombreMonedaAConvertir;
    private String nombreMoonedaConvertida;
    private Double valorMoneda;
    private Double importeAConvertir;
    private Double resultadoConversion;

    public Conversion(String nombreMonedaAConvertir, String nombreMoonedaConvertida, Double valorMoneda, Double importeAConvertir, Double resultadoConversion) {
        this.nombreMonedaAConvertir = nombreMonedaAConvertir;
        this.nombreMoonedaConvertida = nombreMoonedaConvertida;
        this.valorMoneda = valorMoneda;
        this.importeAConvertir = importeAConvertir;
        this.resultadoConversion = resultadoConversion;
    }

    public String getNombreMonedaAConvertir() {
        return nombreMonedaAConvertir;
    }

    public String getNombreMoonedaConvertida() {
        return nombreMoonedaConvertida;
    }

    public Double getValorMoneda() {
        return valorMoneda;
    }

    public Double getImporteAConvertir() {
        return importeAConvertir;
    }

    public Double getResultadoConversion() {
        return resultadoConversion;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "nombreMonedaAConvertir='" + nombreMonedaAConvertir + '\'' +
                ", valorMoneda=" + valorMoneda +
                ", importeAConvertir=" + importeAConvertir +
                ", resultadoConversion=" + resultadoConversion +
                '}';
    }
}
