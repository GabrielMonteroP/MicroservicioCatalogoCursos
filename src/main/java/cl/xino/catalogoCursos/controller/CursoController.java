package cl.xino.catalogoCursos.controller;



import cl.xino.catalogoCursos.models.entities.Curso;
import cl.xino.catalogoCursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // GET: Listar todos
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.obtenerTodos();
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Crear curso
    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.guardarCurso(curso);
    }

    // DELETE: Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}