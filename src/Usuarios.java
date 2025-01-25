public class Usuarios {
    private String nombre;
    private String email;
    private Rol rol;


    public Usuarios(String nombre, String email, Rol rol){

        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public Rol getRol(){
        return rol;
    }


    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Email: " + email + ", Rol: " + rol;
    }
    
}
