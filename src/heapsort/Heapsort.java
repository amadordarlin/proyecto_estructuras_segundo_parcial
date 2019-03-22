/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author Mauricio
 */
public class Heapsort {
    public static void main(String a[]) {
        int lista[] = {10, 300, 400, 50, 20, 2, 0, 19, 80};
int desea;
        System.out.println("Bienvenido al ordenamiento por heapsort");
        do {
            System.out.println();
            System.out.println();
            System.out.println("Opciones para el método heapsort");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Ver el padre de un hijo");
            System.out.println("3. imprimir arreglo");
            System.out.println();
            LectorTeclado lt = new LectorTeclado(System.in);
            int op = lt.leerEnteroValidado("Ingrese una opción válida", "El dato ingresado no es válido intente de nuevo", 1, 4);
            switch (op) {
                case 1:
                    int x = lt.leerEntero("Ingrese la cantidad de datos a ingresar", "El valor no es correcto intente de nuevo");
                    int[] temp = new int[x + lista.length];
                    for (int i = 0; i < lista.length; i++) {
                        temp[i] = lista[i];
                    }
                    int l = 0;
                    for (int j = lista.length; j < temp.length; j++) {
                        l++;
                        temp[j] = lt.leerEntero("Ingrese el dato: " + l, "el dato ingresado no es valido intente de nuevo");

                    }
                    lista = temp;
                    imprimirArreglo(lista, lista.length);
                    break;
                case 2:
                    imprimirArreglo(lista, lista.length);
                    int o =lt.leerEnteroValidado("Ingrese la posicion del dato para ver su padre","intente de nuevo",1,lista.length);
                    int p=(o-1)/2;
                    System.out.println("El padre es el :"+lista[p]);
                    break;
                case 3:
                    System.out.println("_____________Arreglo_______________");
                    for (int k = 0; k <lista.length ; k++) {
                        System.out.print(lista[k]+"  ");

                    }
                    System.out.println();
                    break;
                case 6:
                    break;
            }
            System.out.println();
            desea=lt.leerEnteroValidado("Desea volver al menu principal 1.si 2.no","Intente de nuevo",1,3);
        }while (desea == 1);
    }

        public static void imprimirArreglo(int[]lista, int tamaño){
            int i;
            System.out.println();
            System.out.println("\n---------Arreglo desordenado---------------\n");
            for (i = 0; i < tamaño; i++) {
                System.out.print(" " + lista[i]);
            }
            for (i = tamaño; i > 1; i--) {
                heapSort(lista, i - 1);
            }

            System.out.println("\n\n-------------Arreglo ordenado---------------\n");

            for (i = 0; i < tamaño; i++) {
                System.out.print(" " + lista[i]);
            }

        }


    public static void heapSort(int array[], int indice) {

        int i, j;
        int hijoIzq, hijoDer, hijoMayor, padre, temp;
        padre = (indice - 1) / 2;
        for (j = padre; j >= 0; j--) {

            for (i = padre; i >= 0; i--) {
                hijoIzq = (2 * i) + 1;
                hijoDer = (2 * i) + 2;
                if ((hijoIzq <= indice) && (hijoDer <= indice)) {

                    if (array[hijoDer] >= array[hijoIzq])
                        hijoMayor = hijoDer;
                     else
                       hijoMayor = hijoIzq;

                } else {

                    if (hijoDer > indice)
                        hijoMayor = hijoIzq;
                    else
                      hijoMayor = hijoDer;

                }

                if (array[i] < array[hijoMayor]) {

                    temp = array[i];
                    array[i] = array[hijoMayor];
                    array[hijoMayor] = temp;

                }
            }
        }

        temp = array[0];
        array[0] = array[indice];
        array[indice] = temp;

    }
}