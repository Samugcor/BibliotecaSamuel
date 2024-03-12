import java.util.ArrayList;

public class Usuario {
    private String nombre; 
    private String apellido;
    private String telefono;
    private String email;
    private String contraseña;
    private ArrayList<Libro> librosAlquilados = new ArrayList<>();
    private ArrayList<Libro> librosReservados = new ArrayList<>();

    public Usuario(String nombre, String apellido, String telefono, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        
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

    public String getContraseña() {
        return contraseña;
    }

    public ArrayList<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }

    public void añadirLibrosAlquilados(Libro libro) {
        this.librosAlquilados.add(libro);
    }

    public void añadirLibrosReservados(Libro libro) {
        this.librosReservados.add(libro);
    }

    public void devolverLibrosAlquilados(int indiceLibro){
        
        this.librosAlquilados.remove(indiceLibro);

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", apellido: " + apellido + "\nTelefono: " + telefono + ", email: " + email
                + "\nLibros alquilados: " + librosAlquilados + "\nLibros reservados: " + librosReservados;
    }
    
}
