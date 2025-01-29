public class Usuarios {
    private String email;
    private String contraseña;
    private Rol rol;
    
    
    public Usuarios(String email, String contraseña, Rol rol){

        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
        
    }

    public String getEmail(){
        return email;
    }

    public String getContraseña(){
        return contraseña;
    }

    public Rol getRol(){
        return rol;
    }


    @Override
    public String toString(){
        return "Email: " + email + ", Contraseña: " + contraseña + ", Rol: " + rol;
    }
    
}
