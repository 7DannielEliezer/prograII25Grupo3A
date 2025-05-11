package gt.edu.miumg.prograigrupo72025;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;


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
                case 2 -> Fase2();
                case 4 -> {
                    System.out.println("Gracias por usar el sistema del Zoológico La Aurora.");
                    return;
                }
                default -> System.out.println("Opción no válida.");
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
                default -> System.out.println(" Opción no válida.");
                
                
            }
        }
    }
public static void agregarAnimal(Scanner scanner, Zoo zoo)throws IOException {
    
        
        System.out.println("Ingrese nombre, edad y consumo diario del animal:");
        
        File archivo = new File("/Users/DELL/Downloads/Animals.csv"); // RUTA DE ARCHIVO
        FileWriter fw = new FileWriter(archivo, true);  // crea nuevo archivo
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
        
        
        //SE GUARDAN LOS DATOS DE HERENCIA
        
        
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


        static Nombre[] array = new Nombre[10];//NUEVO ARRAY Y CONTADOR
        static int count = 0;

        
public static void Fase2(){

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
            entrada.nextLine(); //
            
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
                    ordenardes();
                    break;
                case 'f':
                case 'F':
                    ordenaras();
                    break;//SÍ
                case 'g':
                case 'G':
                    mostrararreglo();
                    break;//E
                case 's':
                case 'S':
                    System.out.println("Saliendo...");
                    break;//ESTO SALE AL MENU INCIAL
                default:
                    System.out.println("Opción no válida T.T");
            }
        } while (opcion != 's' && opcion != 'S');
}


//ESTO AGREGA UN ANIMAL
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
                    if (array[i].getID() == id) {//AQUI COMPRUEBA SI ESTA REPETIDO
                        System.out.println("Este ID ya está en uso. Intente con otro.");
                        idRepetido = true;
                        break;
                    }
                }
            } while (idRepetido);//Y CONTINUA

            idanimal.setID(id);
            array[count] = idanimal;//LO PONE EN UN ARRAY Y EL COUNT ES EL NUMERO
            count++;

            System.out.print("¿Desea agregar otro mamífero? (s/n): ");
            String respuesta = sc.nextLine();//ACA PREGUNTA SI DESEA CONTINUAR
            if (!respuesta.equalsIgnoreCase("s")) {//VERIFICA SI PONE SI O NO
                break;
            }
        }
        if (count == array.length) {
            System.out.println("No se pueden agregar más mamíferos. Arreglo lleno.");
        }//AQUI AVISA SI YA ESTA LLENO
    }

    public static void agregarave() {
 
        Scanner sc = new Scanner(System.in);
        
        
        
        
        
        while (count < array.length) {//A PARTIR DE AQUÍ
            
             try {
                 //ESTE ES EL TRY
                 
                 
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
            
            //SE TIENE QUE COLOCAR ASI PARA QUE NO TRUENE
            
            
        } catch (NumberFormatException e) {
            System.out.println("Error!");
            continue;
        }//ESTE ES EL CATCH
             
             
             
             //
             
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
//EL CUAL ES EL REPTIL Y EL MAMIFERO
    
    
    public static void agregarreptil() {
        Scanner sc = new Scanner(System.in);
        while (count < array.length) {
                         try {
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

                    } catch (NumberFormatException e) {
            System.out.println("Error!");
            continue;
        }
            
            
            
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
//ESTO LO ORDENA 
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
                    maspeque = j;//ESTO ES LO QUE VIMOS EN CLASE
                    //EL PROFESOR NO QUIERE EL ARRAY.SORT()
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
 
        




         
         
         
         
         
         
         
         
        









