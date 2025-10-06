import java.util.Scanner;

public class prueba {
        public static void main(String[] args) {
            //creo una variable que me permita recibir datos por teclado
            Scanner entrada = new Scanner(System.in);
            //creo las variables numericas
            //int num1 = 0;
            //int num2 = 0;
            int num1, num2;
            //pido ambos numeros
            System.out.println("introduce el primer numero");
            while(!entrada.hasNextInt()) {
                System.out.println("el tipo de dato es incorrecto, introduce otro");
                entrada.next();
            }
            num1 = entrada.nextInt();
            System.out.println("introduce el segumdo numero");
            while(!entrada.hasNextInt()) {
                System.out.println("el tipo de dato es incorrecto, introduce otro");
                entrada.next();
            }
            num2 = entrada.nextInt();
            System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
            //cierro el scanner antes de salir
            entrada.close();
        }
}
