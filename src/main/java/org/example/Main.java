package org.example;

import org.example.consumoAPI.ConsumoApi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Menu menuPrincipal = new Menu();

        menuPrincipal.menu();

        System.out.println("\nFinalizando Programa");

    }

}