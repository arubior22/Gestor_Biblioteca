import java.util.Scanner;

public class BibliotecaMain {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Usuarios[] usuarios = new Usuarios[3];
        Gestion_libros gestion_libros = new Gestion_libros();
        Usuarios usuarioActual;

        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);
        gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", false);
        gestion_libros.agregarLibro("1984", "Orwell", "Distopía", false);


    
        /*
         * declaramos una variable usuarioActual, ya q al inicio tenemos q probar q
         * entre con usuarios(clase)
         */
        usuarioActual(usuarios);

        /*
         * creamos el metodo pantallalogin, que devuelve un objeto de tipo
         * usuarios(clase)
         */
        usuarioActual = pantallalogin(usuarios);
        if (usuarioActual != null) {

            mostrarMenu(usuarioActual, gestion_libros, usuarios);

        }
        /* lo asigna a la variable inicioUsuarios. */
        else {
            System.out.println("Usuario no encontrado");
        }

    }

    private static void usuarioActual(Usuarios[] usuarios) {
        usuarios[0] = new Usuarios("admin@biblioteca.com", "admin123", Rol.ADMIN);
        usuarios[1] = new Usuarios("usuario1@biblioteca.com", "pass1", Rol.USUARIO);
        usuarios[2] = new Usuarios("rebe@gmail.com", "admin", Rol.ADMIN);
    }

    private static Usuarios pantallalogin(Usuarios[] usuarios) {

        System.out.println("Bienvenid@ a Libreria Manolo");
        System.out.println("Ingrese tu email");
        String email = sc.nextLine();

        System.out.println("Introduce contraseña");
        String contraseña = sc.nextLine();
        /*
         * declaro una variable usuarios2 de tipo Usuarios q viene de la clase Usuarios,
         * usuarios es el array q contiene todos los obejtos o atributos de la clase
         * Usuarios
         */
        for (Usuarios usuarios2 : usuarios) {
            /*
             * equalsIgnoreCase ,compara 2 cadenas, y se usa con String
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

    public static void mostrarMenu(Usuarios usuarioActual, Gestion_libros gestion_libros, Usuarios[] usuarios) {
        int opcion = 0;
        boolean salir = false;

        do {
            System.out.println("\nBienvenido al Menu de Libreria Manolo " + usuarioActual.getEmail());
            if (usuarioActual.getRol() == Rol.ADMIN) {
                System.out.println("1.Agregar libro");
                System.out.println("2.Eliminar libro");
                System.out.println("3.Buscar libro");
                System.out.println("4.Mostar todos los libros");
                System.out.println("5.Gestionar Usuarios");
                System.out.println("0.Salir");
            } else if (usuarioActual.getRol() == Rol.USUARIO) {
                System.out.println("1.Buscar libro");
                System.out.println("2.Mostar todos los libro");
                System.out.println("0.Salir");
            }

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            //sc.nextLine(); 
            switch (opcion) {
                case 1:
                    if (usuarioActual.getRol() == Rol.ADMIN) {

                        System.out.print("Introduce el titulo del libro: ");
                        String titulo = sc.nextLine();

                        System.out.print("Ingrese el autor del libro: ");
                        String autor = sc.nextLine();

                        System.out.println("Ingrese categoria del libro: ");
                        String categoria = sc.nextLine();

                        gestion_libros.agregarLibro(titulo, autor, categoria, true);
                        // agregarLibro();
                        /* llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    } else {
                        System.out.println("Ingrese el titulo,autor o categoria del libros a buscar: ");
                        String busqueda = sc.nextLine();
                        gestion_libros.buscarLibros(busqueda);
                        
                        
                        /* aqui llamo al metodo buscar libro */
                    }
                    break;

                case 2:
                    if (usuarioActual.getRol() == Rol.ADMIN) {
                        System.out.print("Ingrese el titulo del libro a eliminar: ");
                        String titulo = sc.nextLine();
                        gestion_libros.eliminarLibros(titulo);
                        // eliminarLibros();
                        /* llamo al metodo eliminar libro eliminarLibro() */
                    } else {

                        System.out.println("No tienes permisos para eliminar libros.");
                        gestion_libros.mostrarLibros();
                        /* aqui llamo a gestion_libros.mostrarlibros() */
                    }
                    break;

                case 3:
                System.out.println("Ingrese el titulo, autor o categoria del libro a buscar: ");
                String busqueda = sc.nextLine();
                // Llamas al método 'buscarLibros' de la instancia 'gestion_libros' pasando el texto de búsqueda
                gestion_libros.buscarLibros(busqueda);

                 
                   // buscarLibros();
                    /* aqui llamamos a buscarLibro() */
                    break;

                case 4:

                    gestion_libros.mostrarLibros();
                    /* llamo a gestion_libros.mostrarLibros() */

                    break;

                case 5:
                    if (usuarioActual.getRol() == Rol.ADMIN) {
                        GestionUsuario gestionUsuario = new GestionUsuario();
                        gestionUsuario.menu(usuarios);

                        /* llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
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

 

}
