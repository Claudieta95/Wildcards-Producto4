package com.example.helloworld.controller;

import com.example.helloworld.dto.LibroResponseDTO;
import com.example.helloworld.model.Libro;
import com.example.helloworld.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST para la consulta pública de libros.
@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroRepository libroRepository;

    // Inyección del repositorio de libros.
    public LibroRestController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Endpoint público para consultar todos los libros.
    @GetMapping
    public List<LibroResponseDTO> listarLibros() {
        return libroRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    // Endpoint público para consultar un libro por su ID.
    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> obtenerLibro(
            @PathVariable Long id) {

        return libroRepository.findById(id)
                .map(this::convertirDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Conversión de la entidad Libro a su DTO de respuesta.
    private LibroResponseDTO convertirDTO(Libro libro) {
        return new LibroResponseDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getAnioPublicacion()
        );
    }
}