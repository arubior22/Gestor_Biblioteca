public class Libros {

    private String titulo;
    private String autor;
    private String categoria;
    
    /**
     * Constructor parametrizado para los Libros
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param categoria Categoría a la cual pertenece el libro
     */
    public Libros (String titulo, String autor, String categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.categoria= categoria;              
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
    @Override
    public String toString(){
        return "Título: " + titulo + ", Autor: " + autor + ", Categoría: " + categoria;
    }
    
}
