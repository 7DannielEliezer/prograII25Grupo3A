package gt.edu.miumg.prograigrupo72025;

public abstract class Animal {
    protected String nombre;
    protected int edad;
    protected double consumoDiario; // Libras de alimento por día
    protected int idanimal;

    public Animal(String nombre, int edad, double consumoDiario, int idanimal) {
        this.nombre = nombre;
        this.edad = edad;
        this.consumoDiario = consumoDiario;
        this.idanimal = idanimal;
    }

    public abstract void hacerSonido();
    public abstract String getTipoDieta();

    public double calcularConsumo(int dias) {
        if (dias <= 0) return 0;
        return consumoDiario + calcularConsumo(dias - 1);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Nombre: " + nombre + ", Edad: " + edad + 
               ", Consumo diario: " + consumoDiario + " lbs, Dieta: " + getTipoDieta();
    }

    public String getNombre() { return nombre; }
    public double getConsumoDiario() { return consumoDiario; }
}




