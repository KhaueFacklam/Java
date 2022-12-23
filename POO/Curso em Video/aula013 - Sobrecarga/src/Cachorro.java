public class Cachorro extends Lobo {

    // =========== SOBREPOSIÇÃO =============

    @Override
    public void emitirSom() {
        System.out.println("AU... Au... au... rrrr!");
    }

    // ============ SOBRECARGA ==============
    // mesmo método com assinaturas diferentes

    public void reagir(String frase) {
        if (frase == "Toma comida" || frase == "Olá") {
            System.out.println("Abanando e latindo...");
        } else {
            System.out.println("Rosnando...");
        }
    }

    public void reagir(int hora, int minuto) {
        if (hora > 12) {
            System.out.println("Abanando e latindo...");
        } else if (hora >= 18) {
            System.out.println("Ignorou");
        } else {
            System.out.println("Abanando...");
        }
    }

    public void reagir(boolean dono) {
        if (dono) {
            System.out.println("Abanando...");
        } else {
            System.out.println("Latindo e Rosnando...");
        }
    }

    public void reagir(int idade, float peso) {
        if (idade < 5) {
            if (peso < 10) {
                System.out.println("Abanando...");
            } else {
                System.out.println("Latindo...");
            }
        } else {
            if (peso < 10) {
                System.out.println("Rosnando...");
            } else {
                System.out.println("Ignorou");
            }
        }
    }

}
