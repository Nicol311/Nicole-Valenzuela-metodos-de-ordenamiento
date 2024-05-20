import java.util.Scanner;
public class Metodos {

    int array[] = {54, 26, 93, 17, 77, 31, 44, 55, 20}; //array original

    public void MuestraArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("\n");
    }
    
// Método de burbuja
    public void bubleSort(int[] a) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        int n = a.length;
        int comp = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (a[j - 1] > a[j]) {  
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
                comp++;
            }
            this.MuestraArray(a);
        }
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
        System.out.println("Complejidad de: (O(n^2))");
    }

// Método de selección
    public void selectionSort(int[] a) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        int n = a.length;
        int comp = 0;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (a[j] < a[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = a[i];
            a[i] = a[indiceMinimo];
            a[indiceMinimo] = temp;
            this.MuestraArray(a);
        }
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
        System.out.println("Complejidad de: (O(n^2))");

    }

// Método de inserción
    public void insertionSort(int[] a) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        int n = a.length;
        int comp = 0;
        for (int i = 1; i < n; i++) {
            int valorActual = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > valorActual) {
                a[j + 1] = a[j];
                j--;
                comp++;
            }
            a[j + 1] = valorActual;
            this.MuestraArray(a);
        }
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
        System.out.println("Complejidad de: (O(n^2))");

    }

// Método de shellSort
    public void shellSort(int[] a) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        int n = a.length;
        int incremento = n;
        int comp = 0;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < n; i += incremento) {
                    int j = i;
                    comp++;
                    while (j - incremento >= 0 && a[j] < a[j - incremento]) {
                        int tmp = a[j];
                        a[j] = a[j - incremento];
                        a[j - incremento] = tmp;
                        j -= incremento;
                    }
                }
            }
            this.MuestraArray(a);
        } while (incremento > 1);
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
        System.out.println("Complejidad de: (O(n^2))");
    }

// Método de mergeSort
    public void mergeSort(int[] a) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        mergeSort(a, 0, a.length - 1);
        System.out.println("Complejidad de: (O(n log n))");
    }

    public void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int[] left = new int[mid - low + 1];
            int[] right = new int[high - mid];
            System.arraycopy(a, low, left, 0, mid - low + 1);
            System.arraycopy(a, mid + 1, right, 0, high - mid);
            mergeSort(left, 0, left.length - 1);
            mergeSort(right, 0, right.length - 1);
            merge(a, left, right);
            this.MuestraArray(a);
        }
    }

    public void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int comp = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
            comp++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
    }

// Método de quickSort
    public void quickSort(int[] arr) {
        System.out.println("Arreglo original:");
        this.MuestraArray(array);
        System.out.println("\nArreglo ordenado:");
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Complejidad de: (O(n log n))");
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            this.MuestraArray(arr);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int comp = 0;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            comp++;
        }
        swap(arr, i + 1, high);
        System.out.println("Cantidad de comparaciones realizadas: " + comp);
        return i + 1;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}