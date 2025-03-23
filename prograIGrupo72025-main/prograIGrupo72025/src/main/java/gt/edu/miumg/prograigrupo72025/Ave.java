package gt.edu.miumg.prograigrupo72025;

public class Ave extends Animal {
    public Ave(String nombre, int edad, double consumoDiario) {
        super(nombre, edad, consumoDiario);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Pío Pío!");
    }

    @Override
    public String getTipoDieta() {
        return "Herbívoro";
    }
}
