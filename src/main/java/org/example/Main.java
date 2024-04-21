package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        String direccion = "https://v6.exchangerate-api.com/v6/68a3a9ac9f6fc5485ac355b1/latest/USD";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JSONObject jsonObject = new JSONObject(json);
            JSONObject valoresConversion = jsonObject.getJSONObject("conversion_rates");

            double valorPesoArgentino = valoresConversion.getDouble("ARS");
            double valorRealBrasil = valoresConversion.getDouble("BRL");
            double valorPesoColombiano = valoresConversion.getDouble("COP");
            int opcion = 0;

            do{
                menuPrincipal();
                opcion = lectura.nextInt();
                double cantidadDineroAConvertir = 0;
                if (opcion != 7){
                    System.out.println("Ingrese la cantidad de dinero a convertir");
                    cantidadDineroAConvertir = lectura.nextDouble();
                }

                switch (opcion){
                    case 1:
                        System.out.println("$" + cantidadDineroAConvertir + " USD en Pesos argentinos(ARS) es : $"
                                + (valorPesoArgentino * cantidadDineroAConvertir));
                        break;
                    case 2:
                        System.out.println("$" + cantidadDineroAConvertir + " ARS en Dolares(USD) es : $"
                                + (valorPesoArgentino / cantidadDineroAConvertir));
                        break;
                    case 3:
                        System.out.println("$" + cantidadDineroAConvertir + " USD en Real Brasileño(BRL) es : $"
                                + (valorRealBrasil * cantidadDineroAConvertir));
                        break;
                    case 4:
                        System.out.println("$" + cantidadDineroAConvertir + " BRL en Dolares(USD) es : $"
                                + (valorRealBrasil / cantidadDineroAConvertir));
                        break;
                    case 5:
                        System.out.println("$" + cantidadDineroAConvertir + " USD en Pesos colombianos(COP) es : $"
                                + (valorPesoColombiano * cantidadDineroAConvertir));
                        break;
                    case 6:
                        System.out.println("$" + cantidadDineroAConvertir + " COP en Dolares(USD) es : $"
                                + (valorPesoColombiano / cantidadDineroAConvertir));
                        break;
                }
            }while (opcion != 7);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error. " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debe separar los decimales con una ','");
        }

        System.out.println("Finalizando Programa");

    }

    private static void menuPrincipal(){
        System.out.println("""
                *************************************
                Bienvenidos al Conversor de monedas
                *************************************
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción valida:
                """);
    }
}