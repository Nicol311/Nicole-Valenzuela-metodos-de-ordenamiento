import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Metodos metodo = new Metodos();
        int opcion;
        do {
            int array[] = {54,26,93,17,77,31,44,55,20};
            System.out.println("\n===Menu===");
            System.out.println("1. Burbuja");
            System.out.println("2. Inserción");
            System.out.println("3. Selección");
            System.out.println("4. ShellSort");
            System.out.println("5. MergeSort");
            System.out.println("6. QuickSort");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    metodo.bubleSort(array);
                    break;
                case 2:
                    metodo.insertionSort(array);
                    break;
                case 3:
                    metodo.selectionSort(array);
                    break;
                case 4:
                    metodo.shellSort(array);
                    break;
                case 5:
                    metodo.mergeSort(array);
                    break;
                case 6:
                    metodo.quickSort(array);
                    break;
                case 7:
                    System.out.println("\nFin del programa!\n");
                    break;
                default:
                    System.out.println("\nOpción no válida!");
                    break;
            }
        } while (opcion != 7);
        entrada.close();
    }
}