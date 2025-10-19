import java.util.Scanner;
public class ZonasyMatrices {
    
    private String[] zonas;
    private int[][] distanciasKm;
    private int[][] tiemposMin;
    private int zonasCount;
    
    public ZonasyMatrices() {                    // Constructor: Se inicia con datos de las zonas
        inicializarDatos();
    }
   
    private void inicializarDatos() {
        
        zonas = new String[] {"Cartago Centro", "Paraiso", "Oreamuno", "La Union", "El Guarco"};        // Llenamos la matriz con las zonas disponibles
        zonasCount = zonas.length;
        
        distanciasKm = new int[zonasCount][zonasCount];                                                 // Inicializar matrices (ejemplo simétrico)
        tiemposMin = new int[zonasCount][zonasCount];

        inicializarMatrices();                                                                          // Llenar con datos iniciales
    }
        
    
    private void inicializarMatrices() {                                                                // Inicializar todas las posiciones con 0                                 
        for (int i = 0; i < zonasCount; i++) {
            for (int j = 0; j < zonasCount; j++) {
                distanciasKm[i][j] = 0;
                tiemposMin[i][j] = 0;
            }
        }
                                                                       
        // Cartago Centro - Paraíso                             
        distanciasKm[0][1] = 8;                                 // Hacemos un calculo de diastancias y tiempo que pueden haber entre todas las zonas de la matriz
        distanciasKm[1][0] = 8;                                 // y se llenan las matrices de distancias y tiempos que pueden tener entre las zonas.
        
        // Cartago Centro - Oreamuno
        distanciasKm[0][2] = 5;
        distanciasKm[2][0] = 5;
        
        // Cartago Centro - La Unión
        distanciasKm[0][3] = 12;
        distanciasKm[3][0] = 12;
        
        // Cartago Centro - El Guarco
        distanciasKm[0][4] = 6;
        distanciasKm[4][0] = 6;
        
        // Paraíso - Oreamuno
        distanciasKm[1][2] = 10;
        distanciasKm[2][1] = 10;
        
        // Paraíso - La Unión
        distanciasKm[1][3] = 15;
        distanciasKm[3][1] = 15;
        
        // Paraíso - El Guarco
        distanciasKm[1][4] = 9;
        distanciasKm[4][1] = 9;
        
        // Oreamuno - La Unión
        distanciasKm[2][3] = 18;
        distanciasKm[3][2] = 18;
        
        // Oreamuno - El Guarco
        distanciasKm[2][4] = 8;
        distanciasKm[4][2] = 8;
        
        // La Unión - El Guarco
        distanciasKm[3][4] = 14;
        distanciasKm[4][3] = 14;
        
        
        // Tiempos entre lugares
        tiemposMin[0][1] = 17;                                      // Calculo de tiempos entre zonas
        tiemposMin[1][0] = 17;                                      // Cartago Centro - Paraíso
        
        // Cartago Centro - Oreamuno
        tiemposMin[0][2] = 12;
        tiemposMin[2][0] = 12;
        
        // Cartago Centro - La Unión
        tiemposMin[0][3] = 25;
        tiemposMin[3][0] = 25;
        
        // Cartago Centro - El Guarco
        tiemposMin[0][4] = 15;
        tiemposMin[4][0] = 15;
        
        // Paraíso - Oreamuno
        tiemposMin[1][2] = 22;
        tiemposMin[2][1] = 22;
        
        // Paraíso - La Unión
        tiemposMin[1][3] = 30;
        tiemposMin[3][1] = 30;
        
        // Paraíso - El Guarco
        tiemposMin[1][4] = 20;
        tiemposMin[4][1] = 20;
        
        // Oreamuno - La Unión
        tiemposMin[2][3] = 35;
        tiemposMin[3][2] = 35;
        
        // Oreamuno - El Guarco
        tiemposMin[2][4] = 18;
        tiemposMin[4][2] = 18;
        
        // La Unión - El Guarco
        tiemposMin[3][4] = 28;
        tiemposMin[4][3] = 28;
        
        }
    
    // Funcion para mostrar las zonas disponibles
    public void mostrarZonas(){
        System.out.println("\n==== Zonas Disponibles. ====");
        for(int i = 0; i < zonasCount; i++){
            System.out.printf("%d. %s", (i + 1), zonas[i], " ");
        }
    }
    
    // Funcion para mostrar la matriz de distancias 
    public void mostrarDistancias() {
        System.out.println("\n=== MATRIZ DE DISTANCIAS (km) ===");
        mostrarMatriz(distanciasKm, "km");
    }
    
    // Funcion para mostrar la matriz de tiempos
    public void mostrarTiempos() {
        System.out.println("\n=== MATRIZ DE TIEMPOS (min) ===");
        mostrarMatriz(tiemposMin, "min");
    }
    
    // Funcion que muestra en forma de tabla las distancias y tiempos entre las zonas
    private void mostrarMatriz(int[][] matriz, String unidad) {
        System.out.print("       ");
        for (int i = 0; i < zonasCount; i++) {                      
            System.out.printf("%-12s", zonas[i], "\n");                   // Imprime el encabezado con el formato de printf
        }
        
        for (int i = 0; i < zonasCount; i++) {                      // Imprime en las filas los valores de distancias y tiempos
            System.out.printf("%-6s", zonas[i]);
            for (int j = 0; j < zonasCount; j++) {
                System.out.printf("%-12d", matriz[i][j], "\n");
            }
        }
    }
    
    // Funcion de Validacion
    public void consultarPar(int origen, int destino) {
        if (!validarPar(origen, destino)) return;
        
        int distancia = distanciasKm[origen][destino];
        int tiempo = tiemposMin[origen][destino];
        
        System.out.printf("\n%s - %s: %d km | %d min\n", 
            zonas[origen], zonas[destino], distancia, tiempo);
    }
    
    
    
    // Funcion que valida si los datos ingresados para origen y destino sean validos
    private boolean validarPar(int origen, int destino) {
        if (origen < 0 || origen >= zonasCount) {
            System.out.println("Error: Índice de origen inválido");
            return false;
        }
        if (destino < 0 || destino >= zonasCount) {
            System.out.println("Error: Índice de destino inválido");
            return false;
        }
        return true;
    }

    
        // Funcion que actualiza los datos de origen y distancia
        public void actualizarValores(int origen, int destino, int nuevaDistancia, int nuevoTiempo) {
        if (!validarPar(origen, destino)) return;
        
        // Validar que los valores sean mayores a 0
        if (nuevaDistancia < 0 || nuevoTiempo < 0) {
            System.out.println("Error: Los valores deben ser ≥ 0");
            return;
        }
        
        // Si origen y destino son iguales, entonces, distancia y tiempo deben ser igual a 0
        if (origen == destino) {
            nuevaDistancia = 0;
            nuevoTiempo = 0;
        }
        
        // Actualiza origen y distancia
        distanciasKm[origen][destino] = nuevaDistancia;
        tiemposMin[origen][destino] = nuevoTiempo;
        
        // Si es matriz simétrica, actualizar también el sentido contrario
        distanciasKm[destino][origen] = nuevaDistancia;
        tiemposMin[destino][origen] = nuevoTiempo;
        
        System.out.println("Valores actualizados correctamente");
    }
        
        
        public void menuZonas(){
            Scanner sc = new Scanner(System.in);
            int opcion;
            
            do{
            System.out.println("\n\n==== Menu de zonas ====");
            System.out.println("1) Mostrar las zonas disponibles.");
            System.out.println("2) Mostrar matriz de distancias.");
            System.out.println("3) Mostrar matriz de tiempos.");
            System.out.println("4) Consultar origen y destino.");
            System.out.println("5) Actualizar valores.");
            System.out.println("0) Volver al menu principal");
            
            opcion = sc.nextInt();
            
            switch(opcion){
            
                case 1:
                    mostrarZonas();
                    break;
                    
                case 2:
                    mostrarDistancias();
                    break;
                    
                case 3:
                    mostrarTiempos();
                    break;
                    
                case 4:
                    System.out.println("Ingrese el indice del origen: ");
                    int origen = sc.nextInt();
                    System.out.println("Ingrese el indice del destino: ");
                    int destino = sc.nextInt();
                    consultarPar(origen, destino);
                    break;
                    
                case 5:
                    System.out.println("Ingrese el indice del origen: ");
                    origen = sc.nextInt();
                    System.out.println("Ingrese el indice del destino: ");
                    destino = sc.nextInt();
                    System.out.println("Ingrese la distancia a actualizar (Km): ");
                    int distancia = sc.nextInt();
                    System.out.println("Ingrese el tiempo a actualizar (Min): ");
                    int tiempo = sc.nextInt();
                    
                    actualizarValores(origen, destino, distancia, tiempo);
                    break;
                }
            }while(opcion != 0);
        }
        
        }
    
    
    
    


    