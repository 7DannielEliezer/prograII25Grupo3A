package gt.edu.miumg.prograigrupo72025;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;


import java.util.InputMismatchException;


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
                    ordenardes();
                    break;
                case 'f':
                case 'F':
                    ordenaras();
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



        public static void agregarmamifero(){
        if (count < array.length) {
            Nombre idanimal = new Nombre();
            Scanner sc = new Scanner(System.in);

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

            System.out.print("¿Desea agregar otro animal? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Registro de mamífero finalizado.");
            }
        } else {
            System.out.println("No se pueden agregar más mamíferos. Arreglo lleno.");
        }
        }

    public static void agregarave() {
        System.out.println("\n-- Registro de Ave --");
        if (count < array.length) {
            Nombre idanimal = new Nombre();
            Scanner sc = new Scanner(System.in);

            System.out.println("\n-- Registro de ave --");
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

            System.out.print("¿Desea agregar otro animal? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Registro de ave finalizado.");
            }
        } else {
            System.out.println("No se pueden agregar más mamíferos. Arreglo lleno.");
        }
    
    }
    public static void agregarreptil() {
        System.out.println("\n-- Registro de Reptil --");
        if (count < array.length) {
            Nombre idanimal = new Nombre();
            Scanner sc = new Scanner(System.in);

            System.out.println("\n-- Registro de reptil --");
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

            System.out.print("¿Desea agregar otro animal? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                System.out.println("Registro de reptil finalizado.");
            }
        } else {
            System.out.println("No se pueden agregar más mamíferos. Arreglo lleno.");
        }
    
    }
    
    public static void ordenardes() {
        System.out.println("  Ordenar arreglo ");

    }
    public static void ordenaras() {
        System.out.println("  Ordenar arreglo ");
          System.out.println("  Ordenar arreglo ");
 System.out.println("Arreglo desordenado: " + Arrays.toString(array));
        ordenamientoSeleccion(array, count);
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    // Ordenamiento por selección para ordenar por ID
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

    // Método para intercambiar dos elementos en el arreglo
    private static void intercambiar(Nombre[] array, int primero, int segundo) {
        Nombre temporal = array[primero];
        array[primero] = array[segundo];
        array[segundo] = temporal;
    }

    public static void mostrararreglo() {
        System.out.println("-- Mostrar arreglo actual --");
        if (count == 0) {
            System.out.println("No hay datos ingresados.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(array[i]);
            }
        }
 
        
}
}


         
         
         
         
         
         
         
         
        









