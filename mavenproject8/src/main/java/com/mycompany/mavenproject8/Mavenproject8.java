package com.mycompany.mavenproject8;

import java.util.Scanner;
import java.util.Arrays;

class ID {
    public int id;

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

class Nombre extends ID {
    public String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

/**
 *
 * @author DELL
 */
public class Mavenproject8 {
    static Nombre[] array = new Nombre[10];
    static int count = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("--- FASE 2 ---");
            System.out.println("a. Agregar Mamífero");
            System.out.println("b. Agregar Ave");
            System.out.println("d. Agregar Reptil");
            System.out.println("e. Ordenar arreglo ascendente");
            System.out.println("f. Ordenar arreglo descendente");
            System.out.println("g. Mostrar arreglo");
            System.out.println("s. Volver al Menú");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.next().charAt(0);
            entrada.nextLine(); 

            switch (opcion) {
                case 'a':
                case 'A':
                    agregarmamifero();
                    break;
                case 'b':
                case 'B':
                    agregarave();
                    break;
                case 'd':
                case 'D':
                    agregarreptil();
                    break;
                case 'e':
                case 'E':
                    ordenaras();
                    break;
                case 'f':
                case 'F':
                    ordenardes();
                    break;
                case 'g':
                case 'G':
                    mostrararreglo();
                    break;
                case 's':
                case 'S':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida T.T");
            }
        } while (opcion != 's' && opcion != 'S');
    }

    public static void agregarmamifero() {
        Scanner sc = new Scanner(System.in);
        while (count < array.length) {
            Nombre idanimal = new Nombre();
            System.out.println("\n-- Registro de Mamífero --");
            System.out.print("Ingrese un nombre: ");
            String nombre = sc.nextLine();
            idanimal.setNombre(nombre);

            int id;
            boolean idRepetido;
            do {
                System.out.print("Ingrese un ID único: ");
                id = Integer.parseInt(sc.nextLine());
                idRepetido = false;
                for (int i = 0; i < count; i++) {
                    if (array[i].getID() == id) {
                        System.out.println("Este ID ya está en uso. Intente con otro.");
                        idRepetido = true;
                        break;
                    }
                }
            } while (idRepetido);

            idanimal.setID(id);
            array[count] = idanimal;
            count++;

            System.out.print("¿Desea agregar otro mamífero? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
        if (count == array.length) {
            System.out.println("No se pueden agregar más mamíferos. Arreglo lleno.");
        }
    }

    public static void agregarave() {
        Scanner sc = new Scanner(System.in);
        while (count < array.length) {
            Nombre idanimal = new Nombre();
            System.out.println("\n-- Registro de Ave --");
            System.out.print("Ingrese un nombre: ");
            String nombre = sc.nextLine();
            idanimal.setNombre(nombre);

            int id;
            boolean idRepetido;
            do {
                System.out.print("Ingrese un ID único: ");
                id = Integer.parseInt(sc.nextLine());
                idRepetido = false;
                for (int i = 0; i < count; i++) {
                    if (array[i].getID() == id) {
                        System.out.println("Este ID ya está en uso. Intente con otro.");
                        idRepetido = true;
                        break;
                    }
                }
            } while (idRepetido);

            idanimal.setID(id);
            array[count] = idanimal;
            count++;

            System.out.print("¿Desea agregar otro ave? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
        if (count == array.length) {
            System.out.println("No se pueden agregar más aves. Arreglo lleno.");
        }
    }

    public static void agregarreptil() {
        Scanner sc = new Scanner(System.in);
        while (count < array.length) {
            Nombre idanimal = new Nombre();
            System.out.println("\n-- Registro de Reptil --");
            System.out.print("Ingrese un nombre: ");
            String nombre = sc.nextLine();
            idanimal.setNombre(nombre);

            int id;
            boolean idRepetido;
            do {
                System.out.print("Ingrese un ID único: ");
                id = Integer.parseInt(sc.nextLine());
                idRepetido = false;
                for (int i = 0; i < count; i++) {
                    if (array[i].getID() == id) {
                        System.out.println("Este ID ya está en uso. Intente con otro.");
                        idRepetido = true;
                        break;
                    }
                }
            } while (idRepetido);

            idanimal.setID(id);
            array[count] = idanimal;
            count++;

            System.out.print("¿Desea agregar otro reptil? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
        if (count == array.length) {
            System.out.println("No se pueden agregar más reptiles. Arreglo lleno.");
        }
    }

    public static void ordenaras() {
        System.out.println("  Ordenar arreglo ");
 System.out.println("Arreglo desordenado: " + Arrays.toString(array));
        ordenamientoSeleccion(array, count);
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    public static void ordenardes() {
        System.out.println("  Ordenar arreglo ");
 System.out.println("Arreglo desordenado: " + Arrays.toString(array));
        ordenamientoSeleccionDescendente(array, count);
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    // Ordenamiento por selección para ordenar de forma ascendente por ID
    public static void ordenamientoSeleccion(Nombre[] array, int count){
        for (int i = 0; i < count - 1; i++) {
            int maspeque = i;
            for (int j = i + 1; j < count; j++) {
                if (array[j].getID() < array[maspeque].getID()) {
                    maspeque = j;
                }
            }
            intercambiar(array, i, maspeque);
        }
    }

    // Ordenamiento por selección para ordenar de forma descendente por ID
    public static void ordenamientoSeleccionDescendente(Nombre[] array, int count){
        for (int i = 0; i < count - 1; i++) {
            int masgrande = i;
            for (int j = i + 1; j < count; j++) {
                if (array[j].getID() > array[masgrande].getID()) {
                    masgrande = j;
                }
            }
            intercambiar(array, i, masgrande);
        }
    }

    public static void intercambiar(Nombre[] array, int i, int j){
        Nombre temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void mostrararreglo() {
        System.out.println("Arreglo actual:");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + array[i].getID() + ", Nombre: " + array[i].getNombre());
        }
    }
}