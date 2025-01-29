import java.util.Scanner;

public class BibliotecaMain {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Usuarios[] usuarios = new Usuarios[3];
        Gestion_libros gestion_libros = new Gestion_libros();  
        Usuarios usuarioActual;  
        /*
         * declaramos una variable inicioUsuarios, ya q al inicio tenemos q probar q entre con Usuarios(clase)
         */
        usuarioActual(usuarios);
        /*inicioLibros(gestion_libros);*/
            
        
        gestion_libros.librosRegistrados(new Libros("Cien anios de soledad", "Gabriel García Márquez", "Realismo mágico"));
        gestion_libros.librosRegistrados(new Libros("Dune", "Frank Herbert", "Ciencia ficción"));
        gestion_libros.librosRegistrados(new Libros("El hobbit", "J.R.R. Tolkien", "Fantasía épica"));
        gestion_libros.librosRegistrados(new Libros("El código Da Vinci", "Dan Brown", "Misterio y thriller"));
        gestion_libros.librosRegistrados(new Libros("Orgullo y prejuicio", "Jane Austen", "Romance clásico"));
        gestion_libros.librosRegistrados(new Libros("El hombre en busca de sentido", "Viktor E. Frankl", "Psicología y filosofía"));
        gestion_libros.librosRegistrados(new Libros("Sapiens: De animales a dioses", "Yuval Noah Harari", "Historia y antropología"));
        gestion_libros.librosRegistrados(new Libros("1984", "George Orwell", "Distopía y ciencia ficción"));
        gestion_libros.librosRegistrados(new Libros("La Odisea", "Homero", "Clásico y mitología"));
        gestion_libros.librosRegistrados(new Libros("El Principito", "Antoine de Saint-Exupéry", "Fábula y literatura infantil"));
        gestion_libros.librosRegistrados(new Libros("Matar a un ruiseñor", "Harper Lee", "Ficción y crítica social"));
        gestion_libros.librosRegistrados(new Libros("Crónica de una muerte anunciada", "Gabriel García Márquez", "Realismo mágico"));
        gestion_libros.librosRegistrados(new Libros("Los pilares de la Tierra", "Ken Follett", "Novela histórica"));
        gestion_libros.librosRegistrados(new Libros("Cumbres Borrascosas", "Emily Brontë", "Romance gótico"));
        gestion_libros.librosRegistrados(new Libros("El arte de la guerra", "Sun Tzu", "Estrategia y filosofía"));
        gestion_libros.librosRegistrados(new Libros("Don Quijote de la Mancha", "Miguel de Cervantes", "Clásico de la literatura española"));
        gestion_libros.librosRegistrados(new Libros("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía y aventura"));

        /*creamos el metodo pantallalogin, que devuelve un objeto de tipo Usuarios(clase)*/
        usuarioActual = pantallalogin(usuarios);
        if (usuarioActual != null) {
         
            mostrarMenu(usuarioActual,gestion_libros,usuarios);
            
        }
        /*lo asigna a la variable inicioUsuarios. */
         else {
            System.out.println("Usuario no encontrado");
        }
    }

    private static void usuarioActual(Usuarios [] usuarios) {
        usuarios[0] = new Usuarios("admin@biblioteca.com", "admin123", Rol.ADMIN);
        usuarios[1] = new Usuarios("usuario1@biblioteca.com", "pass1", Rol.USUARIO);
        usuarios[2] = new Usuarios("rebe@gmail.com", "admin", Rol.ADMIN);
    }
        
    private static Usuarios pantallalogin(Usuarios [] usuarios) {
      
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
    public static void mostrarMenu(Usuarios usuarioActual,Gestion_libros gestion_libros,Usuarios [] usuarios){
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
                System.out.println("6.Gestion prestamos."); 
                System.out.println("0.Salir");
            } else if (usuarioActual.getRol()== Rol.USUARIO) {
                System.out.println("1.Buscar libro");
                System.out.println("2.Mostar todos los libro");
                System.out.println("3.Gestion prestamos.");
                System.out.println("0.Salir");
            }

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        System.out.print("Introduce el titulo del libro: ");
                        String titulo = sc.nextLine();

                        System.out.print("Ingrese el autor del libro: ");
                        String autor = sc.nextLine();

                        System.out.println("Ingrese categoria del libro: ");
                        String categoria = sc.nextLine();
                        gestion_libros.agregarLibro(titulo, autor, categoria);  //El true no hace falta mirarlo Rebeca?
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    }else{
                        /*System.out.println("No tienes permisos para agregar libros.");*/
                        System.out.println("Ingresa el título, autor o categoría del libro a buscar: ");
                        String campos = sc.nextLine();
                        gestion_libros.buscarLibros(campos); 
                        /*aqui llamo al metodo buscar libro */
                    }
                    break;

                    case 2:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        System.out.print("Ingrese el título del libro a eliminar: ");
                        String titulo = sc.nextLine();
                        gestion_libros.eliminarLibros(titulo);
                        /*llamo al metodo eliminar libro eliminarLibro() */
                    }else{
                        /*System.out.println("No tienes permisos para eliminar libros.");*/
                        gestion_libros.mostrarLibros();
                        /*aqui llamo a gestion_libros.mostrarlibros() */
                    }
                    break;

                    case 3:
                    System.out.println("Ingresa el título, autor o categoría del libro a buscar: ");
                    String campos = sc.nextLine();
                    gestion_libros.buscarLibros(campos);
                    
                    break;
                    /*aqui llamamos a buscarLibro() */
                    
                    case 4:
                   
                        gestion_libros.mostrarLibros();
                        /*llamo a gestion_libros.mostrarLibros() */
                    
                    break;

                    case 5:
                    if (usuarioActual.getRol()== Rol.ADMIN) {
                        GestionUsuario gestionUsuario = new GestionUsuario();
                        gestionUsuario.menu(usuarios);
                    
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    } else {
                        /*Gestion_prestamos.menu(usuarios);*/

                    }
                    break;
                    case 6:
                        if (usuarioActual.getRol() == Rol.ADMIN) {
                            
                           /*  Gestion_prestamos.menu(); */
                            
                    }
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
