/**
 * @author Ana Rubio 
 */



import java.util.Scanner;
public class Gestion_prestamos {

    //Nuevo añadido 28/1/25 los 3 puntos de abajo
    private static final int MAX_LIBROS = 5;  // Número máximo de libros
    private static Libros[] libros = new Libros[MAX_LIBROS]; // Arreglo de libros
    private static int totalLibrosPrestados = 0;
    
    public void menu(Usuarios[] usuarios, Usuarios usuarioActual) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;
    
    do {
        System.out.println("\nBienvenido al Menu de Libreria Manolo " + usuarioActual.getEmail());
        if (usuarioActual.getRol() == Rol.ADMIN) {
        System.out.println("\nGESTION DE PRESTAMOS");
        System.out.println("-------------------");
        System.out.println("1.Prestar Libros.");
        System.out.println("2.Devolver Libros.");
        System.out.println("3.MostrarLibrosPrestados");
        System.out.println("4.Volver al Menú");
        System.out.println("0.Salir");
            
        } else if (usuarioActual.getRol()== Rol.USUARIO) {
        System.out.println("\nGESTION DE PRESTAMOS");
        System.out.println("-------------------");
        System.out.println("1.Prestar Libros.");
        System.out.println("2.Devolver Libros.");
        System.out.println("0.Salir");    
        }
        System.out.print("Selecciona una opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                System.out.print("Ingresa el título del libro a prestar: ");
                String tituloPrestar = sc.nextLine();
                prestarLibro(tituloPrestar);
                break;

            case 2:
                System.out.print("Ingresa el título del libro a devolver: ");
                String tituloDevolver = sc.nextLine();
                devolverLibro(tituloDevolver);
                break;

            case 3:           
                if (usuarioActual.getRol() == Rol.ADMIN) {
                    mostrarLibrosPrestados("admin");
                } else {
                    System.out.println("No tienes acceso.");
                }         
            break;
            case 4:
                return;
            case 0:
                System.out.println("Saliendo del sistema...");
                salir = true;
                break;

            default:
            System.out.println("Opción inválida, intenta nuevamente.");
        }
    } while (!salir);
    sc.close();
}
     // Método para prestar un libro (cualquiera puede hacerlo)
    public void prestarLibro(String titulo) {
        if (totalLibrosPrestados < MAX_LIBROS) {
            for (int i = 0; i < MAX_LIBROS; i++) {
                if (libros[i] != null && libros[i].getTitulo().equals(titulo) && !libros[i].getPrestado()) {
                    libros[i].setPrestado(true);
                    totalLibrosPrestados++;
                    System.out.println("Libro '" + libros[i].getTitulo() + "' prestado con éxito.");
                    return;
                }
            }
            System.out.println("El libro con titulo " + titulo + " no está disponible para préstamo.");
        } else {
            System.out.println("No hay suficientes libros disponibles para préstamo.");
        }
    }

    // Método para devolver un libro (cualquiera puede hacerlo)
    public static void devolverLibro(String titulo) {
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (libros[i] != null && libros[i].getTitulo().equals(titulo) && libros[i].getPrestado()) {
                libros[i].setPrestado(false);
                totalLibrosPrestados--;
                System.out.println("Libro '" + libros[i].getTitulo() + "' devuelto con éxito.");
                return;
            }
        }
        System.out.println("El libro con ID " + titulo + " no está prestado.");
    }

    // Método para mostrar los libros prestados (solo admin puede verlos)
    public static void mostrarLibrosPrestados(String rol) {
        if ("admin".equals(rol)) {
            System.out.println("Libros actualmente prestados:");
            boolean encontrado = false;
            for (int i = 0; i < MAX_LIBROS; i++) {
                if (libros[i] != null && libros[i].getPrestado()) {
                    System.out.println("Titulo: " + libros[i].getTitulo() + " - Título: " + libros[i].getTitulo());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No hay libros prestados en este momento.");
            }
        } else {
            System.out.println("Acceso denegado: Solo los administradores pueden ver los libros prestados.");
        }
    }

    
    
}
    