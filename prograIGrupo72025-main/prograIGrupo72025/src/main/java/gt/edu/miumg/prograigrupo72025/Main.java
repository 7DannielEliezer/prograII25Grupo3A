package gt.edu.miumg.prograigrupo72025;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Zoo");
            System.out.println("2. Fase II (Próximamente)");
            System.out.println("3. Fase III (Próximamente)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> menuZoo(scanner, zoo);
                case 4 -> {
                    System.out.println("👋 Gracias por usar el sistema del Zoológico La Aurora.");
                    return;
                }
                default -> System.out.println("⚠ Opción no válida.");
            }
        }
    }

    public static void menuZoo(Scanner scanner, Zoo zoo)throws IOException {
        while (true) {
            System.out.println("\n--- Gestión del Zoo ---");
            System.out.println("1. Agregar nuevo animal");
            System.out.println("2. Ver todos los animales");
            System.out.println("3. Alimentar animales");
            System.out.println("4. Calcular consumo de alimentos");
            System.out.println("5. Exportar datos a CSV");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarAnimal(scanner, zoo);
                case 2 -> zoo.listarAnimales();
                case 3 -> zoo.alimentarAnimales();
                case 4 -> {
                    System.out.print("Ingrese el número de días: ");
                    int dias = scanner.nextInt();
                    zoo.calcularConsumoTotal(dias);
                }
                case 5 -> zoo.exportarCSV();
                case 6 -> { return; }
                default -> System.out.println("⚠ Opción no válida.");
            }
        }
    }

    
    //prueba
    
public static void agregarAnimal(Scanner scanner, Zoo zoo)throws IOException {
    
        
        System.out.println("Ingrese nombre, edad y consumo diario del animal:");
        
        File archivo = new File("/Users/DELL/Downloads/Animals.csv"); //RUTA DE ARCHIVO
        FileWriter fw = new FileWriter(archivo, true);  //COMANDO DE ESCRITURA
        try(BufferedWriter bw = new BufferedWriter(fw)){

        String cadena = null;   //PRIMERO ESTA VACÍO
        String nombre = scanner.next(); //USUARIO ESCRIBE VARIABLE
        cadena = nombre;
        bw.write(cadena + ",");  //SE GUARDA EN CSV AUTOMATICAMENTE
        
        int cadenab;
        int edad = scanner.nextInt();
        cadenab = edad;
        bw.write(cadenab + ",");
        
        double cadenac;
        double consumo = scanner.nextDouble();
        cadenac = consumo;
        bw.write(cadenac + ",");
        
        
        zoo.agregarAnimal(new Mamifero(nombre, edad, consumo)); //SE GUARDAN LOS DATOS DE HERENCIA
        
        
        bw.newLine();
        bw.close(); // SE CIERRA LA FILA DE CSV.
        
        }
        catch(InputMismatchException e){
        System.out.println("Hubo un ERROR");
                }
        catch(Exception e){
        System.out.println("Hubo un ERROR");
                } finally{
        }
        }
        }
        


