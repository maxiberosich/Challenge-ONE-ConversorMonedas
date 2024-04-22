package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.consumoAPI.AdaptadorFecha;
import org.example.consumoAPI.ConsumoApi;
import org.example.modelos.Conversion;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner lectura = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final String json = consumoApi.respuestaApi();
    public Menu() {

    }

    public void menu(){

        String opcion;
        List<Conversion> conversiones = new ArrayList<>();
        do{
            System.out.println("""
                *************************************
                Bienvenidos al Conversor de monedas
                *************************************
                Ingrese las siglas de la moneda que desea convertir a Dolar o viceversa:
                ARS	 -   Argentine Peso
                BOB  -   Boliviano boliviano
                BRL  -   Real brasileño
                CLP  -   Peso chileno
                COP  -   Peso colombiano
                LYD	 -   Libyan Dinar
                SSP	 -   South Sudanese Pound
                SYP	 -   Syrian Pound
                VES	 -   Venezuelan Bolívar Soberano
                YER	 -   Yemeni Rial
                ZWL	 -   Zimbabwean Dollar
                Debe ingresar las 3 primeras letras, luego presionar enter.
                0) Salir
                """);
            System.out.print("Ingrese las siglas: ");
            opcion =  lectura.next();
            double valorMoneda = 0;
            if (!opcion.equals("0")){
                try{
                    valorMoneda = valorBuscado(opcion);
                    calculos(opcion, valorMoneda, conversiones);
                }catch (JSONException e){
                    System.out.println("Debe ingresar un valor valido\n");
                }

            }
        }while ( !opcion.equals("0") );

        guardarLista(conversiones);
    }

    private void calculos(String nombreMoneda, Double valorMonedaElegida, List<Conversion> listaConversion){


        int eleccion = 1;
        double resultado = 0;
        do {
            System.out.println("""
                Seleccione que accion desea realizar:
                1)USD a""" + " " + nombreMoneda.toUpperCase()
                    + "\n2)" + nombreMoneda.toUpperCase() + " a USD"
                    + "\n0) Salir");

            eleccion = lectura.nextInt();

            switch (eleccion){
                case 1:
                    System.out.print("Ingrese la cantidad de USD: $");
                    double cantidadUsd = lectura.nextDouble();
                    resultado = (cantidadUsd * valorMonedaElegida);
                    System.out.println("$" + cantidadUsd + " USD ="
                            +" $" + resultado + " " + nombreMoneda.toUpperCase() + "\n");
                    listaConversion.add(new Conversion(nombreMoneda.toUpperCase(), "USD"
                            ,valorMonedaElegida, cantidadUsd, resultado));
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de " + nombreMoneda.toUpperCase() + " : $");
                    double cantidadMoneda = lectura.nextDouble();
                    resultado = (cantidadMoneda / valorMonedaElegida);
                    System.out.println("$" + cantidadMoneda + " " + nombreMoneda.toUpperCase() + " = "
                            + "$" + resultado + " USD\n");
                    listaConversion.add(new Conversion("USD", nombreMoneda.toUpperCase()
                            ,valorMonedaElegida, cantidadMoneda, resultado));
                    break;
            }

        }while (eleccion != 0);
    }

    private Double valorBuscado(String siglasMoneda){

        JSONObject jsonObject = new JSONObject(json);
        JSONObject valoresConversion = jsonObject.getJSONObject("conversion_rates");

        return valoresConversion.getDouble(siglasMoneda.toUpperCase());
    }

    private void guardarLista(List<Conversion> listaConversion){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .registerTypeAdapter(LocalDateTime.class,new AdaptadorFecha())
                .setPrettyPrinting()
                .create();
        try {
            FileWriter escritura = new FileWriter("conversiones.json");
            escritura.write(gson.toJson(listaConversion));
            escritura.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar la informacion. " + e.getMessage());
        }
    }

}
