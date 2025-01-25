import java.util.Scanner;


public class GestionUsuario {
    private Usuarios[] gestionUsuarios;
    private int contador;

    /*
     * aqui vamos a crear
     * un constructor que tendra de tamaño 50
     */
    public GestionUsuario() {
        this.gestionUsuarios = new Usuarios[50];
        this.contador = 0;

        /* creare ya el admin por defecto para q sea el admin1 */
        Usuarios admin = new Usuarios("Administrador1", "admin.biblioteca.es", Rol.ADMIN);
        gestionUsuarios[contador] = admin;
        contador++;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\nGESTION DE USUARIOS");
            System.out.println("-------------------");
            System.out.println("1.Añadir Usuario.");
            System.out.println("2.Mostrar Usuarios");
            System.out.println("0.Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    addUsuario(scanner);
                    break;

                case 2:
                    mostrarUsuarios();
                    break;

                case 0:
                    System.out.println("Saliendo de Gestion de Usuarios....");
                    System.out.println();
                    break;

                default:
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }

    private void addUsuario(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Introduce nombre de usuario: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce email para el usuario: ");
        String email = scanner.nextLine();

        System.out.println("Introduce rol (ADMIN/USUARIO): ");
        String tipoRol = scanner.nextLine().toUpperCase();

        Rol rol;

        try {
            rol = Rol.valueOf(tipoRol);
            /*
             * la clase IllegalArgumentException:Se usa cuando un metodo
             * recibe un valor q NO ES CORRECTO o que NO DEBERIA ACEPTAR
             */
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no válido. Se asignara Usuario.");
            rol = Rol.USUARIO;
        }

        gestionUsuarios[contador] = new Usuarios(nombre, email, rol);
        contador++;
        System.out.println("Usuario añadido correctamente");

    }

    private void mostrarUsuarios() {
        if (contador == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\nUSUARIOS REGISTRADOS:");
            for (int i = 0; i < contador; i++) {
                System.out.println(gestionUsuarios[i]);
            }
        }

    }

}
