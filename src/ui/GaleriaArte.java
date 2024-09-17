import java.util.Scanner;

public class GaleriaArte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar número de obras de arte
        System.out.print("¿Cuántas obras de arte quieres registrar? ");        
        int numObras = scanner.nextInt();

        // Crear arreglos para almacenar nombres y precios
        // arreglo de String para los nombres de las obras
        // arreglo de double para los precios (de tamaño numObras)
      

        // Supongamos que tienes una variable que define el tamaño del arreglo
        int tamaño = numObras;

        // Crear un arreglo con el tamaño definido por la variable
        String[] nombresArreglo = new String[tamaño];
        double[] preciosArreglo = new double[tamaño];
        

        // Registrar obras de arte
        registrarObrasDeArte(nombresArreglo, preciosArreglo, scanner);

        // Mostrar menú de opciones
        mostrarMenu(nombresArreglo, preciosArreglo, scanner, tamaño);

        scanner.close();
    }

    /**
     * Contrato: Registrar el nombre y precio de cada obra de arte.
     * @param nombresArreglo Arreglo que almacena los nombres de las obras.
     * @param preciosArreglo Arreglo que almacena los precios de las obras.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
    public static void registrarObrasDeArte(String[] nombresArreglo, double[] preciosArreglo, Scanner scanner) {
        for (int i = 0; i < nombresArreglo.length; i++) {
            System.out.println("Obra de arte #" + (i + 1));
            
            // Solicitar el nombre de la obra
            System.out.print("Nombre de la obra: ");
            nombresArreglo[i] = scanner.next();
    
            // Solicitar y validar el precio
            double precio;
            do {
                System.out.print("Precio de la obra (Entre 100 y 10000 dólares): ");
                precio = scanner.nextDouble();
                if (precio < 100 || precio > 10000) {
                    System.out.println("Error: El precio debe estar entre 100 y 10000 dólares. Inténtalo de nuevo.");
                }
            } while (precio < 100 || precio > 10000);
    
            preciosArreglo[i] = precio; // Solo asignar el precio después de validarlo
        }
    }

    /**
     * Contrato: Mostrar el menú de opciones y ejecutar las funciones correspondientes.
     * @param nombresArreglo Arreglo que almacena los nombres de las obras.
     * @param preciosArreglo Arreglo que almacena los precios de las obras.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
    public static void mostrarMenu(String[] nombresArreglo, double[] preciosArreglo, Scanner scanner, int tamaño) {
        int opcion;
        do {
            System.out.println("\nOpciones:");
            System.out.println("1. Mostrar todas las obras de arte y sus precios");
            System.out.println("2. Mostrar la obra de arte más cara");
            System.out.println("3. Mostrar la obra de arte más barata");
            System.out.println("4. Calcular el precio promedio de las obras de arte");
            System.out.println("5. Mostrar obras de arte cuyo precio esté por encima de un valor");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarObras(nombresArreglo, preciosArreglo, tamaño);
                    break;
                case 2:
                    mostrarObraMasCara(nombresArreglo, preciosArreglo, tamaño);
                    break;
                case 3:
                    mostrarObraMasBarata(nombresArreglo, preciosArreglo, tamaño);
                    break;
                case 4:
                    mostrarPrecioPromedio(preciosArreglo);
                    break;
                case 5:
                    System.out.print("Introduce el valor de precio mínimo: ");
                    double precioMinimo = scanner.nextDouble();
                    mostrarObrasPorPrecio(nombresArreglo, preciosArreglo, precioMinimo, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 6);
    }

    /**
     * Contrato: Muestra las obras de arte una por una, con su respectivo nombre y precio
     * @param nombresArreglo Arreglo que almacena los nombres de cada obra
     * @param preciosArreglo Arreglo que almacena los precios de cada obra
     * @param tamaño Variable que define el tamaño de cada arreglo, según las obras que registe el usuario
     */
    public static void mostrarObras(String[] nombresArreglo, double[] preciosArreglo, int tamaño) {
        // Completar: Mostrar todas las obras y sus precios

        for (int i = 0; i < tamaño; i++)
        {
            System.out.println("Obra de arte: "+(i+1)+ ", Nombre: "+nombresArreglo[i]+", Precio: "+preciosArreglo[i] );
        }
    }

    /**
     * Contrato: Muestra el nombre de la obra de arte más cara, junto con el precio asociado
     * @param nombresArreglo Arreglo que almacena los nombres de cada obra
     * @param preciosArreglo Arreglo que almacena los precios de cada obra
     * @param tamaño Variable que define el tamaño de cada arreglo, según las obras que registe el usuario
     */
    public static void mostrarObraMasCara(String[] nombresArreglo, double[] preciosArreglo, int tamaño) {
        // Completar: Encontrar y mostrar la obra más cara
        double valorMasAlto = preciosArreglo[0];
        String nombreMasAlto = nombresArreglo[0];

        // Recorremos el arreglo con un ciclo for
        for (int i = 1; i < tamaño; i++) {
            if (preciosArreglo[i] > valorMasAlto) {
                valorMasAlto = preciosArreglo[i]; // Actualizamos el valor más alto
                nombreMasAlto = nombresArreglo[i];
            }
        }

        System.out.println("El nombre de la obra con el precio más alto es: "+nombreMasAlto+ ", con un precio de: " +valorMasAlto);
    }

    
    /**
     * Contrato: Muestra el nombre de la obra de arte más barata, junto con el precio asociado
     * @param nombresArreglo Arreglo que almacena los nombres de cada obra
     * @param preciosArreglo Arreglo que almacena los precios de cada obra
     * @param tamaño Variable que define el tamaño de cada arreglo, según las obras que registe el usuario
     */
    public static void mostrarObraMasBarata(String[] nombresArreglo, double[] preciosArreglo, int tamaño) {
        // Completar: Encontrar y mostrar la obra más cara
        double valorMasBajo = preciosArreglo[0];
        String nombreMasBajo = nombresArreglo[0];

        // Recorremos el arreglo con un ciclo for
        for (int i = 1; i < tamaño; i++) {
            if (preciosArreglo[i] < valorMasBajo) {
                valorMasBajo = preciosArreglo[i]; // Actualizamos el valor más alto
                nombreMasBajo = nombresArreglo[i];
            }
        }

        System.out.println("El nombre de la obra con el precio más bajo es: "+nombreMasBajo+ ", con un precio de: " +valorMasBajo);
    }

    /**
     * Contrato: Muestra el precio promedio de todas las obras
     * @param preciosArreglo Arreglo que almacena los precios de cada obra
     */
    public static void mostrarPrecioPromedio(double[] preciosArreglo) 
    {
        double suma = 0;

        for (double valor : preciosArreglo) {
            suma += valor;
        }

        double promedio = (double) suma / preciosArreglo.length;

        System.out.println("El precio promedio de todas las obras es: " + promedio);

    }

    /**
     * Contrato: Muestra todas las obras con un precio superior al valor dado, con su respectivo nombre y precio
     * @param nombresArreglo Arreglo que almacena los nombre de cada obra
     * @param preciosArreglo Arreglo que almacena los precios de cada obra
     * @param precioMinimo Precio mínimo dado por el usuario
     * @param scanner Objeto sccaner para leer la entrada del usuairo
     */
    public static void mostrarObrasPorPrecio(String[] nombresArreglo, double[] preciosArreglo, double precioMinimo, Scanner scanner) 
    {
        System.out.println("Digite el valor mínimo");
        precioMinimo = scanner.nextDouble();

        for (int i = 0; i < preciosArreglo.length; i++) {
            if (preciosArreglo[i] > precioMinimo) 
            {
                System.out.println(nombresArreglo[i]+" tinene un valor de "+preciosArreglo[i]);
            }
        }

    } 
    
}
