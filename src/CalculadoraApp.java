import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {

            System.out.println("**** Aplicación Calculadora ****");
            //Menu
            mostrarMenu();

            try {
                var operacion = Integer.parseInt(consola.nextLine());

                if (operacion >= 1 && operacion <= 8) {
                    // Raíz cuadrada no requiere un segundo operando
                    if (operacion == 6) {
                        System.out.print("Proporciona el valor para calcular la raíz cuadrada: ");
                        var operando1 = Integer.parseInt(consola.nextLine());

                        if (operando1 >= 0) {
                            double resultado = calcularRaiz(operando1);
                            System.out.println("Resultado de la raíz cuadrada: " + resultado);
                        } else {
                            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                        }
                    } else if (operacion == 8) {
                        System.out.println("Hasta pronto...");
                        break;
                    } else {
                        // Operaciones que requieren dos operandos
                       ejecutarOperacion(operacion, consola);
                    }
                } else {
                    System.out.println("Operación fuera del rango permitido.");
                }
                //salto de linea
                System.out.println();
            } //fin try
            catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }//fin del while
    }
    //Menu
    private static void mostrarMenu(){
        // Mostramos el menú
        System.out.println("1. Suma \n2. Resta \n3. Multiplicación \n4. División \n5. Potencia \n6. Radicación \n7. Resto de la división \n8. Salir");

        System.out.print("Operación a realizar? ");
    }

    private static void ejecutarOperacion(int operacion, Scanner consola){
        System.out.print("Proporciona el primer valor: ");
        var operando1 = Integer.parseInt(consola.nextLine());
        System.out.print("Proporciona el segundo valor: ");
        var operando2 = Integer.parseInt(consola.nextLine());
        double resultado;
        switch (operacion) {
            case 1 -> { // Suma
                resultado = operando1 + operando2;
                System.out.println("Resultado Suma: " + resultado);
            }
            case 2 -> { // Resta
                resultado = operando1 - operando2;
                System.out.println("Resultado Resta: " + resultado);
            }
            case 3 -> { // Multiplicación
                resultado = operando1 * operando2;
                System.out.println("Resultado Multiplicación: " + resultado);
            }
            case 4 -> { // División
                if (operando2 != 0) {
                    resultado = (double) operando1 / operando2;
                    System.out.println("Resultado División: " + resultado);
                } else {
                    System.out.println("Error: División entre cero no permitida.");
                }
            }
            case 5 -> { // Potencia
                resultado = calcularPotencia(operando1, operando2);
                System.out.println("Resultado Potencia: " + resultado);
            }
            case 7 -> { // Resto de la división
                resultado = operando1 % operando2;
                System.out.println("Resto de la división: " + resultado);
            }
            default -> System.out.println("Operación no válida.");
        }
    }

    // Método para calcular potencia
    public static double calcularPotencia(int base, int exponente) {
        return Math.pow(base, exponente);
    }

    // Método para calcular raíz cuadrada
    public static double calcularRaiz(int radicando) {
        return Math.sqrt(radicando);
    }
}
