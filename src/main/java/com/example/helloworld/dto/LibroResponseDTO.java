package com.example.helloworld.dto;

// DTO para devolver la información pública de los libros.
public class LibroResponseDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anioPublicacion;

    // Constructor con los datos del libro.
    public LibroResponseDTO(Long id, String titulo, String autor,
                            String isbn, Integer anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    // Métodos getters para acceder a los datos.
    public Long getId() {
        return id;
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

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }
}