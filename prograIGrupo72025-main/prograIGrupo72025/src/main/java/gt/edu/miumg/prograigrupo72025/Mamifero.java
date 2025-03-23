package gt.edu.miumg.prograigrupo72025;

public class Mamifero extends Animal {
    public Mamifero(String nombre, int edad, double consumoDiario) {
        super(nombre, edad, consumoDiario);
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
