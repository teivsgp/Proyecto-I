import java.util.ArrayList;         // Importamos ArrayList para poder almacernar objetos dentro de un array
import java.util.Scanner;

public class RegistroUsuarios {
    
    private ArrayList<Usuario> ListaUsuarios;      //crea una lista llamada ListaUsuarios que almacena los Usuarios
    
    public RegistroUsuarios(){
        ListaUsuarios = new ArrayList<>();         // Constructor de la clase, se incia vacia
    }
    
    public void RegistrarUsuario(){                    // Funcion para poder registar los usuarios nuevos
        Scanner scanner = new Scanner(System.in);      // Crea un nuevo objeto y lee los datos con el scanner
        
        System.out.println("\nIngrese el ID del usuario que desea registar: ");          
        String ID = scanner.nextLine();
        
        System.out.println("Ingrese el nombre del usuario que desea registar: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el modo como va a viajar(1. A pie 2. En Bicicleta 3. En bus): ");
        int modoViaje = scanner.nextInt();
        if(modoViaje > 3){
          System.out.println("Modo de viaje invalido");
        }
        
        System.out.println("¿Requiere de accesibilidad (true/false)? ");
        boolean accesibilidad = scanner.hasNextBoolean();
        
        Usuario nuevoUsuario = new Usuario(ID, nombre, modoViaje, accesibilidad);
        ListaUsuarios.add(nuevoUsuario);
        
        System.out.println("Usuarios registrado exitosamente: " + nombre + "\n");
    }
    
    public void MostrarUsuarios(){                          // Funcion que muestra los usuarios que ya han sido registrados
        System.out.println("\nLista de usuarios registrados:");
        for(Usuario i : ListaUsuarios){                     // Se utiliza un for each para recorrer la lista de los usuarios y poder mostrarla
            System.out.println("ID: " + i.ID + ", Nombre: " + i.nombre + ", Modo de viaje: " + i.modoViaje + ", Accesibilidad: " + i.accesibilidad + "\n");
        }
    }
    
}
