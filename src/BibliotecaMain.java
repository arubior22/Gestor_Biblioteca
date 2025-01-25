import java.util.Scanner;

public class BibliotecaMain {

    private static Usuarios[] usuarios = new Usuarios[2];
    private static Gestion_libros gestion_libros = new Gestion_libros();
    private static GestionUsuario gestionUsuario = new GestionUsuario();

    public static void main(String[] args) {

     

        inicioUsuarios();
        //inicioLibros();

        Usuarios inicioUsuarios = pantallalogin();

        if (inicioUsuarios != null) {
            mostarMenu(inicioUsuarios);
        } else {
            System.out.println("Usuario no encontrado");
        }

    }

    private static void inicioUsuarios() {
        usuarios[0] = new Usuarios("admin@biblioteca.com", "admin123", Rol.ADMIN);
        usuarios[1] = new Usuarios("usuario1@biblioteca.com", "pass1", Rol.USUARIO);
    }

    // private void inicializaLibros() {
    //     gestion_libros.agregarLibro("El Quijote", "Cervantes", "Novela", usuarios[0]);
    //     gestion_libros.agregarLibro("1984", "Orwell", "Distopía", usuarios[0]);
    // }

    private static Usuarios pantallalogin() {
        Scanner sc = new Scanner(System.in);
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

            sc.close();

        }
        return null;
    }

    private static void mostarMenu(Usuarios inicioUsuarios ){
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nBienvenido al Menu de Libreria Manolo " + inicioUsuarios.getEmail());
            if (inicioUsuarios.getRol() == Rol.ADMIN) {
                System.out.println("1.Agregar libro");
                System.out.println("2.Eliminar libro");
                System.out.println("3.Buscar libro");
                System.out.println("4.Mostar todos los libro");
                System.out.println("5.Gestionar Usuarios");
                System.out.println("0.Salir");
            } else if (inicioUsuarios.getRol()== Rol.USUARIO) {
                System.out.println("1.Buscar libro");
                System.out.println("2.Mostar todos los libro");
                System.out.println("0.Salir");
            }

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (inicioUsuarios.getRol()== Rol.ADMIN) {
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    }else{
                        /*aqui llamo al metodo buscar libro */
                    }
                    break;

                    case 2:
                    if (inicioUsuarios.getRol()== Rol.ADMIN) {
                        /*llamo al metodo eliminar libro eliminarLibro() */
                    }else{
                        /*aqui llamo a gestion_libros.mostrarlibros() */
                    }
                    break;

                    case 3:
                    /*aqui llamamos a buscarLibro() */
                    break;

                    case 4:
                    if (inicioUsuarios.getRol()== Rol.ADMIN) {
                        /*llamo a gestion_libros.mostrarLibros() */
                    }
                    break;

                    case 5:
                    if (inicioUsuarios.getRol()== Rol.ADMIN) {
                        gestionUsuario.menu();
                        /*llamo al metodo agregar libro agregarLibro(inicioUsuarios) */
                    }
                    break;

                    case 0:
                    System.out.println("Saliendo...");
                    break;
            
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion !=0);

        sc.close();

    }

 

}
