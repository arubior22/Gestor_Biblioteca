public class Libros {

    private String titulo;
    private String autor;
    private String categoria;
    /** Indica si el libro ha sido prestado*/
    private boolean prestado;
    
    /**
     * Constructor parametrizado para los Libros
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param categoria Categoría a la cual pertenece el libro
     */
    public Libros (String titulo, String autor, String categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria; 
        /* Añadido nuevo */
        this.prestado = false;
                
    }

    /**
     * Para obtener el título del libro
     * @return título del libro
     */
    public String getTitulo() {
        return this.titulo;
    }
    /**
     *  Establece el título del libro
     * @param titulo nuevo título del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
 
    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean getPrestado(){
        return this.prestado;
    }
    public void setPrestado(boolean prestado){
        this.prestado = prestado;
    }
    
    @Override
    public String toString(){
        return "Título: " + titulo + ", Autor: " + autor + ", Categoría: " + categoria + ", Prestado: " + (prestado ? "Si" : "No");
    }
    
}
