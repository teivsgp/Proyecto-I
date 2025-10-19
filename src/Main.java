import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        
        Scanner scanner = new Scanner(System.in); 
        int opcionMenu = 0;
        boolean menu = true;
        RegistroUsuarios registro = new RegistroUsuarios();
        ZonasyMatrices gestion = new ZonasyMatrices();
        
        
        while(menu){
            System.out.println("========== Menu de usuarios ============");
            System.out.println("1) Registrar usuarios");
            System.out.println("2) Mostrar usuarios registrados");
            System.out.println("3) Gestion de zonas");
            System.out.println("0) Salir");
            
            opcionMenu = scanner.nextInt();
            
            switch(opcionMenu){
            
                case 1:
                    registro.RegistrarUsuario();        // Se registran los usuarios
                    break;
                    
                case 2: 
                    registro.MostrarUsuarios();         // Muestra los usuarios registrados
                    break;
                case 3:
                    gestion.menuZonas();                // Para poder ver las zonas disponibles, matrices de distancia, matrices de distancias y el valor entre zonas(origen y destino)
                    break;
//              case 4:
//                    PlanificarRutas();                // Toma un usuario y el origen y destino 
//                    break;
//                    
//              case 5:
//                    ListarRutas();                    // Muestra las rutas guardadas, en caso de que no hayan, se muestra un mensaje
//                    break;  
//                   
//              case 6:
//                    OrdernarRutas();                  // Permite reordenar las rutas guardadas segun el costo o el tiempo; la opcion 4(ListarRutas) debe mostrar el nuevo orden de rutas
//                    break;
//                    
//              case 7:
//                    FiltrarRutasModo();               //Muestra las rutas segun el modo escogido(pie, bici o bus), no modifica nada, solo muestra las rutas
//                    break;
//                    
//              case 8:
//                    Parametros();                     // Permite modificar parametros(Tarifa Por KM de Bus y factor de CO2g(g/Km)) 
//                    break;
//                    
//              case 8:
//                    ReportesRapidos();                // Imprime indicadores agregados: cantidad de rutas, promedio de km, promedio de minutos, costo total, CO2 total y conteo de modo(pie, bici, bus)
//
//                    break;
//                    
//              case 10:
//                    EditarRuta();                     // Modifica obJEto ruta con setters, tambien debe crear un nuevo ojeto con mismos parametros(origen, destino, modo, Km) y lo reemplaza en el array
//                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    menu = false;
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
       
}

    

    
    

