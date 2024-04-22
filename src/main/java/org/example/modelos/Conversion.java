package org.example.modelos;

import java.time.LocalDateTime;

public class Conversion {

    private String nombreMonedaAConvertir;
    private String nombreMoonedaConvertida;
    private Double valorMoneda;
    private Double importeAConvertir;
    private Double resultadoConversion;
    private LocalDateTime horaBusqueda;

    public Conversion(String nombreMonedaAConvertir, String nombreMoonedaConvertida,
                      Double valorMoneda, Double importeAConvertir, Double resultadoConversion) {
        this.nombreMonedaAConvertir = nombreMonedaAConvertir;
        this.nombreMoonedaConvertida = nombreMoonedaConvertida;
        this.valorMoneda = valorMoneda;
        this.importeAConvertir = importeAConvertir;
        this.resultadoConversion = resultadoConversion;
        this.horaBusqueda = LocalDateTime.now();
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

    public LocalDateTime getHoraBusqueda() {
        return horaBusqueda;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "Moneda a convertir = '" + nombreMonedaAConvertir.toUpperCase() + '\'' +
                ", Moneda convertida='" + nombreMoonedaConvertida.toUpperCase()+ '\'' +
                ", Valor moneda=" + valorMoneda +
                ", Importe a convertir=" + importeAConvertir +
                ", Resultado de Conversion=" + resultadoConversion +
                ", Hora de Busqueda=" + horaBusqueda +
                '}';
    }
}
