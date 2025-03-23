package gt.edu.miumg.prograigrupo72025;

public class Reptil extends Animal {
    public Reptil(String nombre, int edad, double consumoDiario) {
        super(nombre, edad, consumoDiario);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Ssshh!");
    }

    @Override
    public String getTipoDieta() {
        return "Omnívoro";
    }
}
