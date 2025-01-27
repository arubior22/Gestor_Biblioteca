import java.util.Scanner;

public class BibliotecaMain {
    public static Scanner sc = new Scanner(System.in);
    private static Usuarios[] usuarios = new Usuarios[3];
    private static Gestion_libros gestion_libros = new Gestion_libros();
    private static GestionUsuario gestionUsuario ;
    public static Usuarios usuarioActual;

    public static void main(String[] args) {

     
        /*
         * declaramos una variable inicioUsuarios, ya q al inicio tenemos q probar q entre con Usuarios(clase)
         */
        usuarioActual();
        inicioLibros();
        gestionUsuario = new GestionUsuario(new BibliotecaMain());
        gestionUsuario.usuarioDefinido(usuarios);
        //gestionUsuario.mostrarUsuarios();
      

        /*creamos el metodo pantallalogin, que devuelve un objeto de tipo Usuarios(clase)*/
        Usuarios usuarioActual = pantallalogin();
        if (usuarioActual != null) {
         
            mostrarMenu(usuarioActual);
            
        }
        /*lo asigna a la variable inicioUsuarios. */
         else {
            System.out.println("Usuario no encontrado");
        }

    }

    private static void usuarioActual() {
        usuarios[0] = new Usuarios("admin@biblioteca.com", "admin123", Rol.ADMIN);
        usuarios[1] = new Usuarios("usuario1@biblioteca.com", "pass1", Rol.USUARIO);
        usuarios[2] = new Usuarios("rebe@gmail.com", "admin", Rol.ADMIN);
    }

    private static void inicioLibros() {
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela",true);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", true);
        System.out.println("Libros de inicio agregados.");
        System.out.println();
    }



    private static Usuarios pantallalogin() {
      
        System.out.println("Bienvenid@ a Libreria Manolo");
        System.out.println("Ingrese tu email");
        String email = sc.nextLine();

        System.out.println("Introduce contraseña");
        String contraseña = sc.nextLine();
        /*declaro una variable usuarios2 de tipo Usuarios q viene de la clase Usuarios, 
        usuarios es el array q contiene todos los obejtos o atributos de la clase Usuarios
          */
        for (Usuarios usuarios2 : usuarios) {
            /*equalsIgnoreCase ,compara 2 cadenas, y se usa con String
             * se usa para verificar si ambas cadenas son =
             * ignorando las mayusculas y minusculas
             */
            if (usuarios2 != null && usuarios2.getEmail().equalsIgnoreCase(email)
                    && usuarios2.getContraseña().equalsIgnoreCase(contraseña)) {
                return usuarios2;

            }

        

        }
        return null;
    }

    public static void mostrarMenu(Usuarios usuarioActual ){
        int opcion = 0;
        boolean salir = false;

        do {
            System.out.println("\nBienvenido al Menu de Libreria Manolo " + usuarioActual.getEmail());
            if (usuarioActual.getRol() == Rol.ADMIN) {
                System.out.println("1.Agregar libro");
                System.out.println("2.Eliminar libro");
                System.out.println("3.Buscar libro");
                System.out.println("4.Mostar todos los libro");
                System.out.println("5.Gestionar Usuarios");
                System.out.println("0.Salir");
            } else if (usuarioActual.getRol()== Rol.USUARIO) {
                System.out.println("1.Buscar libro");
                System.out.println("2.Mostar todos los libro");
                System.out.println("0.Salir");
            }

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        agregarLibro();
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    }else{
                        buscarLibros();
                        /*aqui llamo al metodo buscar libro */
                    }
                    break;

                    case 2:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        eliminarLibros();
                        /*llamo al metodo eliminar libro eliminarLibro() */
                    }else{
                        gestion_libros.mostrarLibros();
                        /*aqui llamo a gestion_libros.mostrarlibros() */
                    }
                    break;

                    case 3:
                    buscarLibros();
                    /*aqui llamamos a buscarLibro() */
                    break;

                    case 4:
                   
                        gestion_libros.mostrarLibros();
                        /*llamo a gestion_libros.mostrarLibros() */
                    
                    break;

                    case 5:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        gestionUsuario.menu(usuarioActual);
                    
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    }
                    break;

                    case 0:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
            
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!salir);

  

    }

    private static void agregarLibro(){
        System.out.print("Introduce el titulo del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();

        System.out.println("Ingrese categoria del libro: ");
        String categoria = sc.nextLine();

        gestion_libros.agregarLibro(titulo, autor, categoria, true);

    }


    private static void eliminarLibros(){
        System.out.print("Ingrese el titulo del libro a eliminar: ");
        String titulo = sc.nextLine();
        gestion_libros.eliminarLibros(titulo);
    }

    private static void buscarLibros(){
        System.out.println("Ingrese el titulo,autor o categoria del libros a buscar: ");
        String busqueda = sc.nextLine();
        gestion_libros.buscarLibros(busqueda);
    }



 

}
