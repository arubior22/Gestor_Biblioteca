import java.util.Scanner;


public class GestionUsuario {
    private Usuarios[] gestionUsuario;
    private int contador;
  

    /*
     * aqui vamos a crear
     * un constructor que tendra de tamaño 50
     */
    public GestionUsuario() {
        this.gestionUsuario = new Usuarios[50];
        this.contador = 0;
    }



    public void menu(Usuarios [] usuarios) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
       
        do {
            System.out.println("\nGESTION DE USUARIOS");
            System.out.println("-------------------");
            System.out.println("1.Añadir Usuario.");
            System.out.println("2.Mostrar Usuarios");
            System.out.println("3.Volver al Menú");
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

                    case 3:
                    return;

                case 0:
                    
                    System.out.println("Saliendo de Gestion de Usuarios....");
                    salir = true;
                    System.out.println();
                    break;

                default:
                    break;
            }
        } while (!salir);
        scanner.close();
    }

    private void addUsuario(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Introduce email: ");
        String email = scanner.nextLine();

        System.out.println("Introduce contraseña: ");
        String contraseña = scanner.nextLine();

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

        gestionUsuario[contador] = new Usuarios(email, contraseña, rol);
        contador++;
        System.out.println("Usuario añadido correctamente");

    }

    public void usuarioDefinido(Usuarios [] usuariosFijados){
        for(Usuarios usuarios : usuariosFijados ){
            gestionUsuario[contador++] = usuarios;
        }
    }


    public void mostrarUsuarios() {
        if (contador == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\nUSUARIOS REGISTRADOS:");
            for (int i = 0; i < contador; i++) {
                System.out.println(gestionUsuario[i]);
            }
        }

    }



}
