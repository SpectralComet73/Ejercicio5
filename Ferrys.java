package Ejercicio5;

import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


/*Se tienen dos ferris Portos y Celebrian, en donde Portos almacena los autos en Pila y Celebrian los almacena en forma de Cola.
Crea un programa en java que realice las siguientes operaciones.
Lea la matrícula del auto (cadena alfanumérica) y en cuál de los ferris irá (P o C).
Considera que la capacidad máxima de cada ferri es de 10 autos, por lo que deberás validar que se cumpla con esta restricción.
Después de cada inserción, imprime el contenido de Portos y Celebrian.
Cuando los ferris completen su viaje (el cual deberá simularse) los autos saldrán de acuerdo con la estructura implementada para cada caso.
Cada vez que salga un auto, deberá imprimirse el contenido restante de cada ferri. */


// Se crea la clase Ferrys

public class Ferrys {
    public static void main(String[]args) throws InterruptedException{
        Stack<String> portos = new Stack<>();
        Queue<String> celebrian = new LinkedList<>();
        Scanner sc= new Scanner(System.in);

        System.out.println("\nBeeenvenido al puejto de Veracru \n");
        System.out.println("\nLos ferris disponibles son: \n");
        System.out.println("\n1. El ferry Portos con direccio al puejto de Baja Califonia Su \n");
        System.out.println("\n2. El ferry Celebrian con direccio al puejto de Salina Cru \n");
        
        // Se crea el ciclo while que se ejecutara mientras la pila portos y la cola celebrian no esten llenas
        while(true){
            System.out.println("\nIngrese la matricula del auto(o 'salir' para cancelar) \n");
            String matricula = sc.nextLine();

            if (matricula.equals("salir")){
                break;
            }

            System.out.println("\nIngrese el ferris en el que desea que vaya el auto (P - Portos, C- Celebrian): \n");
            String ferris = sc.nextLine();

            if (ferris.equalsIgnoreCase("P")){
                if (portos.size() < 10){
                    portos.push(matricula);
                    System.out.println("\nEl auto con matricula " + matricula + " ha entrado al Ferry Portos \n");
                    System.out.println("\nLos autos que estan en el Ferry Portos son: \n");
                    System.out.println(portos);
                    System.out.println("\nLos autos que estan en el Ferry Celebrian son: \n");
                    System.out.println(celebrian);
                }
                else{
                    System.out.println("\nCapacidad maxima de Portos alcanzada. No ha podido ingresar el auto. \n");
                }
            }
            else if (ferris.equalsIgnoreCase("C")){
                if (celebrian.size() < 10){
                    celebrian.offer(matricula);
                    System.out.println("\nEl auto con matricula " + matricula + " ha entrado al Ferry Celebrian \n");
                    System.out.println("\nLos autos que estan en el Ferry Portos son: \n");
                    System.out.println(portos);
                    System.out.println("\n Los autos que estan en el Ferry Celebrian son: \n");
                    System.out.println(celebrian);
                }
                else{
                    System.out.println("\nCapacidad maxima de Celebrian alcanzada. No ha podido ingresar el auto \n");
                }
            }
            else{
                System.out.println("\nOpcion invalida. Ingrese P para mandar el auto a Portos o C para el Celebrian \n");
            }


        }

        System.out.println("\nIniciando el viaje de ambos ferrys...\n");
        String velas1 = "     \u2571\u23AA \u23AA\u2572";
        String velas2 = "    \u2571 \u23AA \u23AA \u2572";
        String velas3 = "   \u2571__\u23AA \u23AA__\u2572";
        String mastiles = "      \u23AA \u23AA";
        String timonel = "  \u2599\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u259f";
        System.out.print("\033[H\033[2J");
        System.out.print("\033[11;0H" + "\033[0;34;44m" + "\u2588".repeat(80) + "\033[0m");
        
        for (int i = 0; i < 20; i++) {
            int v = i + 1;
            System.out.print("\033[6;" + v + "H" + velas1);
            System.out.print("\033[7;" + v + "H" + velas2);
            System.out.print("\033[8;" + v + "H" + velas3);
            System.out.print("\033[9;" + v + "H" + mastiles);
            System.out.print("\033[10;" + v + "H" + timonel);
            TimeUnit.MILLISECONDS.sleep(500);
        }
        
        int i = 19;
        
        while (i > 0) {
            int v = i + 1;
            System.out.print("\033[6;" + v + "H" + velas1 + "\033[0K");
            System.out.print("\033[7;" + v + "H" + velas2 + "\033[0K");
            System.out.print("\033[8;" + v + "H" + velas3 + "\033[0K");
            System.out.print("\033[9;" + v + "H" + mastiles + "\033[0K");
            System.out.print("\033[10;" + v + "H" + timonel + "\033[0K");
            i--;
            TimeUnit.MILLISECONDS.sleep(500);
        }

        System.out.println("\n\nLos ferrys han llegado a su destino...\n\n");

        while (!portos.isEmpty()){
            System.out.println("\nEl auto con matricula " + portos.pop() + " ha salido del Ferry Portos \n");
            System.out.println("\nLos autos que estan en el Ferry Portos son: \n");
            System.out.println(portos);
            System.out.println("\nLos autos que estan en el Ferry Celebrian son: \n");
            System.out.println(celebrian);
        }

        while (!celebrian.isEmpty()){
            System.out.println("\nEl auto con matricula " + celebrian.poll() + " ha salido del Ferry Celebrian \n");
            System.out.println("\nLos autos que estan en el Ferry Portos son: \n");
            System.out.println(portos);
            System.out.println("\nLos autos que estan en el Ferry Celebrian son: \n");
            System.out.println(celebrian);
        }

        System.out.println("\nTodos los autos han salido \n");
        System.out.println("\nFin del viaje de ambos ferrys...\n");

    }
}