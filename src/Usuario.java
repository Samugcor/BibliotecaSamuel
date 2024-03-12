import java.util.ArrayList;

public class Usuario {
    private String nombre; 
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList<Libro> librosAlquilados = new ArrayList<>();

    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }

    public void añadirLibrosAlquilados(Libro libro) {
        this.librosAlquilados.add(libro);
    }

    public void devolverLibrosAlquilados(int indiceLibro){
        
        this.librosAlquilados.remove(indiceLibro);

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", apellido: " + apellido + "\nTelefono: " + telefono + ", email: " + email
                + "\nLibros alquilados: " + librosAlquilados;
    }
   
    
    
}
