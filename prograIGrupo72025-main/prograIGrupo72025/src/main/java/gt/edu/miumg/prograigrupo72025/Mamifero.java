package gt.edu.miumg.prograigrupo72025;

public class Mamifero extends Animal {
    public Mamifero(String nombre, int edad, double consumoDiario, int idanimal) {
        super(nombre, edad, consumoDiario, idanimal);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Rugido!");
    }

    @Override
    public String getTipoDieta() {
        return "Carnívoro";
    }
}
