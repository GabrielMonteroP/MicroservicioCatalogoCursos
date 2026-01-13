package cl.xino.catalogoCursos.services;

import cl.xino.catalogoCursos.models.entities.Curso;
import cl.xino.catalogoCursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso guardarCurso(Curso curso) {
        // Aquí podrías validar que el precio no sea negativo, etc.
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
    
    public List<Curso> buscarPorCategoria(String categoria) {
        return cursoRepository.findByCategoria(categoria);
    }
}