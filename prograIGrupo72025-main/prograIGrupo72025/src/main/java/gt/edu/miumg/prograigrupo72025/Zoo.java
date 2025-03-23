package gt.edu.miumg.prograigrupo72025;

import java.io.*;
import java.util.*;

public class Zoo {
    private List<Animal> animales = new ArrayList<>();
    private static final String ARCHIVO_CSV = "zoo_data.csv";

    public void agregarAnimal(Animal animal) {
        for (Animal a : animales) {
            if (a.getClass().equals(animal.getClass())) {
                System.out.println("❌ Ya hay un " + animal.getClass().getSimpleName() + " registrado.");
                return;
            }
        }
        animales.add(animal);
        System.out.println("✅ Animal agregado: " + animal);
    }

    public void listarAnimales() {
        if (animales.isEmpty()) System.out.println("⚠ No hay animales registrados.");
        else animales.forEach(System.out::println);
    }

    public void alimentarAnimales() {
        if (animales.isEmpty()) System.out.println("⚠ No hay animales para alimentar.");
        else animales.forEach(a -> System.out.println("🍽 Alimentando a " + a.getNombre() + " con dieta " + a.getTipoDieta()));
    }

    public void calcularConsumoTotal(int dias) {
        try{
        if (dias <= 0) System.out.println("⚠ El número de días debe ser mayor a 0.");
  
        else {
            double total = animales.stream().mapToDouble(a -> a.calcularConsumo(dias)).sum();
            System.out.println("📊 Total de alimento necesario para " + dias + " días: " + total + " libras.");
        }
                       }
        catch(Exception e){
        System.out.println("Hubo un ERROR");
                }finally{
        }
        }
        
        
    
    

    public void exportarCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_CSV))) {
            writer.println("Tipo,Nombre,Edad,ConsumoDiario,Dieta");
            animales.forEach(a -> writer.println(a.getClass().getSimpleName() + "," + a.getNombre() + "," + a.edad + "," + a.getConsumoDiario() + "," + a.getTipoDieta()));
            System.out.println("✅ Datos exportados a " + ARCHIVO_CSV);
        } catch (IOException e) {
            System.out.println("❌ Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}

