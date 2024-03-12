public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private Boolean disponible;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\tTitulo: " + titulo + "\n\tAutor: " + autor + "\n\tISBN: " + isbn + "\n\tDisponible: " + disponible;
    }

    
    
}
