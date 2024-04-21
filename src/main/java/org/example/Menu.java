package org.example;

import org.example.consumoAPI.ConsumoApi;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Menu {

    private final Scanner lectura = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final String json = consumoApi.respuestaApi();
    public Menu() {

    }

    public void menu(){

        String opcion;
        do{
            System.out.println("""
                *************************************
                Bienvenidos al Conversor de monedas
                *************************************
                Ingrese que moneda desea convertir a Dolar o viceversa:
                ARS	    Argentine Peso
                LYD	    Libyan Dinar
                SSP	    South Sudanese Pound
                SYP	    Syrian Pound
                VES	    Venezuelan Bolívar Soberano
                YER	    Yemeni Rial
                ZWL	    Zimbabwean Dollar
                Debe ingresar las 3 primeras letras, luego presionar enter.
                0) Salir
                """);
            System.out.print("Elija una opción valida: ");
            opcion =  lectura.next();
            double valorMoneda = 0;
            if (!opcion.equals("0")){
                try{
                    valorMoneda = valorBuscado(opcion);
                    calculos(opcion, valorMoneda);
                }catch (JSONException e){
                    System.out.println("Debe ingresar un valor valido\n");
                }

            }
        }while ( !opcion.equals("0") );

    }

    private void calculos(String nombreMoneda, Double valorMonedaElegida){

        System.out.println("""
                Seleccione que accion desea realizar:
                1)USD a""" + " " + nombreMoneda.toUpperCase()
                + "\n2)" + nombreMoneda.toUpperCase() + " a USD");
        int eleccion = lectura.nextInt();
        switch (eleccion){
            case 1:
                System.out.print("Ingrese la cantidad de USD: $");
                double cantidadUsd = lectura.nextDouble();
                System.out.println("$" + cantidadUsd + " USD ="
                        +" $" + (cantidadUsd * valorMonedaElegida) + " " + nombreMoneda.toUpperCase() + "\n");
                break;
            case 2:
                System.out.print("Ingrese la cantidad de " + nombreMoneda.toUpperCase() + " : $");
                double cantidadMoneda = lectura.nextDouble();
                System.out.println("$" + cantidadMoneda + " " + nombreMoneda.toUpperCase() + " = "
                        + "$" + (cantidadMoneda / valorMonedaElegida) + " USD\n");
                break;
        }

    }

    public Double valorBuscado(String siglasMoneda){

        JSONObject jsonObject = new JSONObject(json);
        JSONObject valoresConversion = jsonObject.getJSONObject("conversion_rates");

        return valoresConversion.getDouble(siglasMoneda.toUpperCase());
    }

}
