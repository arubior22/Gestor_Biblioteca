public class Gestion_libros {

    private static final int Max_Libros = 50;
    private Libros[] libros = new Libros[Max_Libros];
    private int contadorLibros = 0;

    /*
     * Para agregar los libros:
     */
    public void agregarLibro(String titulo, String autor, String categoria , boolean mostrarMensaje){
        if (contadorLibros < Max_Libros){
            libros[contadorLibros++] = new Libros(titulo, autor, categoria);
            if (mostrarMensaje) {
                System.out.println("Libro agregado correctamente.");  
            }
           
        } else {
            System.out.println("No se pueden agregar más libros. Cupo lleno.");
        }
    }
    /**
     * Para eliminar los libros:
     */
    public void eliminarLibros(String titulo){
        boolean encontrado = false;
        for (int i = 0; i < contadorLibros; i++){
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)){
                libros[i] = libros[--contadorLibros]; //Reemplaza con el último libro
                libros[contadorLibros] = null; // Elimina la referencia
                System.out.println("Libro eliminado correctamente.");
            }
        }
        if (!encontrado){
            System.out.println("Libro no encontrado.");
        }
    }
    /**
     * Para buscar los libros:
     */
    public void buscarLibros(String campos){
        boolean encontrado = false;
        System.out.println("Resultados de la búsqueda: ");
        for(int i =0; i < contadorLibros; i++){
            if (libros[i].getTitulo().toLowerCase().contains(campos.toLowerCase()) ||
            libros[i].getAutor().toLowerCase().contains(campos.toLowerCase()) ||
            libros[i].getCategoria().toLowerCase().contains(campos.toLowerCase())) {
            System.out.println(libros[i]);
            encontrado = true;
        }
        }
        if (!encontrado) {
            System.out.println("El libro introducido no coincide con ningun campo.");
        }
    }
    /**
     * Para mostrar los libros
     */
    public void mostrarLibros(){
        if (contadorLibros == 0){
            System.out.println("No hay libros disponibles.");
        } else {
            System.out.println("Lista de libros disponibles: ");
            for (int i = 0 ; i < contadorLibros ; i++) {
                System.out.println(libros[i]);
            }
        }
    }

}
