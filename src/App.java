import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Declarar e inicializar libros
        Libro libro1 = new Libro("Alas De Hierro", "Rebecca Yarros", "978-8408284550");
        Libro libro2 = new Libro("Hábitos atómicos: Cambios pequeños, resultados extraordinarios", "James Clear",
                "978-8418118036");
        Libro libro3 = new Libro("BLACKWATER I. La riada", "Michael Mcdowell", "978-8419654892");
        Libro libro4 = new Libro("En agosto nos vemos", "Gabriel García Márquez", "978-8439743071");
        Libro libro5 = new Libro("Alas de sangre", "Rebecca Yarros", "978-8408279990");
        Libro libro6 = new Libro("La sociedad de la nieve", "Pablo Vierci", "978-8418584732");
        Libro libro7 = new Libro("Dune", "Frank Herbert", "978-8466353779");

        // Declarar e inicializar usuarios
        Usuario usuario1 = new Usuario("Pedro", "Gutierrez", "636246298", "PedroGT@gmail.com", "pedro");
        Usuario usuario2 = new Usuario("Uxia", "Barreiro", "623985476", "uxia_barreiro@gmail.com", "aaa");

        // Libros disponibles en la biblioteca
        ArrayList<Libro> librosBiblioteca = new ArrayList<>(Arrays.asList(libro1, libro2, libro3, libro4, libro5, libro6, libro7));
        ArrayList<Usuario> usuarios = new ArrayList<>(Arrays.asList(usuario1, usuario2));

        Scanner scanner = new Scanner(System.in);

        int opcion;
        String emailIntroducido;
        String contraseñaIntroducida;
        int usuarioActivo = -1;
        String isbnIntroducido;
        int indx = 0;
        int opcionReserva;

        while (true) {
            System.out.println( "1.Crear nuevo usuario\n2. Acceder a un usuario\n3. Ver libros disponibles\n4. Ver libros pendientes de devolver\n5. Alquilar un libro\n6. Devolver un libro\n7.Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            /*
             * acceder a un usuario, ver libros disponibles, ver libros pendientes de
             * devolver(por el usuario), pedir un libro y devolver un libro.
             */
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca los siguientes datos: ");

                    System.out.print("Nombre: ");
                    String nombreNU = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoNU = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefonoNU = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailNU = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseñaNU = scanner.nextLine();

                    usuarios.add(new Usuario(nombreNU, apellidoNU, telefonoNU, emailNU, contraseñaNU));
                    System.out.println("Se ha introducido el siguiente usuario: " + usuarios.get(usuarios.size()-1));
                    break;

                case 2:

                    System.out.println("\nIntroduzca el correo electrónico y contraseña para acceder al usuario: ");
                    emailIntroducido = scanner.nextLine();
                    contraseñaIntroducida = scanner.nextLine();

                    for (Usuario usuario : usuarios) {
                        if (usuario.getEmail().equals(emailIntroducido) & usuario.getContraseña().equals(contraseñaIntroducida)) {
                            usuarioActivo = usuarios.indexOf(usuario);
                            System.out.println("\nUsuario activo: " + usuario.toString() + "\n");
                            break;
                        }
                    }
                    if (usuarioActivo == -1) {
                        System.out.println("\nNo se encontró un usuario con esos datos\n");
                    }

                    break;

                case 3:
                    indx = 0;
                    System.out.println("\nLibros de la biblioteca: ");
                    for (Libro libro : librosBiblioteca) {
                        indx++;
                        System.out.println("\nDatos libro " + indx + ":\n" + libro.toString());
                    }
                    break;

                case 4:
                    indx = 0;
                    if (usuarioActivo == -1) {
                        System.out.println("Es necesario iniciar un usuario para realizar esta acción");
                    } else {
                        System.out.println("\nLibros pendientes de devolucion: ");

                        if (usuarios.get(usuarioActivo).getLibrosAlquilados().isEmpty() == true) {
                            System.out.println("El usuario no tiene libros que devolver\n");
                        } else {
                            for (Libro libro : usuarios.get(usuarioActivo).getLibrosAlquilados()) {
                                indx++;
                                System.out.println("\nDatos libro " + indx + ":\n" + libro.toString());
                            }
                        }

                    }
                    break;

                case 5:
                    if (usuarioActivo == -1) {
                        System.out.println("Es necesario iniciar un usuario para realizar esta acción");
                    } else {
                        System.out.println("\nIntroduce el ISBN del libro a alquilar: ");
                        isbnIntroducido = scanner.nextLine();

                        for (Libro libro : librosBiblioteca) {
                            if (libro.getIsbn().equals(isbnIntroducido)) {
                                if (libro.getDisponible()==false) {
                                    System.out.println("\nEl libro " + libro.getTitulo() + "no esta disponible, desea erservarlo?\n1.Si\2.No");
                                    opcionReserva=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcionReserva) {
                                        case 1:
                                            usuarios.get(usuarioActivo).añadirLibrosReservados(libro);
                                            System.out.println("Se ha reservado correctamente");
                                            break;
                                        case 2:
                                            System.out.println("Lamentamos que el libro no este disponible");
                                            break;
                                        default:
                                            break;
                                    }
                                    
                                }
                                else{
                                    System.out.println("\nHa alquilado el libro " + libro.getTitulo());

                                    usuarios.get(usuarioActivo).añadirLibrosAlquilados(libro);
                                    libro.setDisponible(false);
                                }
                                

                            }
                        }
                        
                    }
                    break;

                case 6:
                    if (usuarioActivo == -1) {
                        System.out.println("Es necesario iniciar un usuario para realizar esta acción");
                    } else {
                        System.out.println("Introduce el ISBN del libro a devolver: ");
                        isbnIntroducido = scanner.nextLine();

                        for (Libro libro : usuarios.get(usuarioActivo).getLibrosAlquilados()) {
                            if (libro.getIsbn() == isbnIntroducido) {
                                indx = usuarios.get(usuarioActivo).getLibrosAlquilados().indexOf(libro);
                            }
                        }
                        usuarios.get(usuarioActivo).devolverLibrosAlquilados(indx);
                    }

                case 7:
                    System.exit(0);
                    break;

                default:
                    break;
            }

        }

    }
}
