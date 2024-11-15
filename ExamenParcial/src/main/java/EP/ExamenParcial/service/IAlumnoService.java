package EP.ExamenParcial.service;

import java.util.List;
import java.util.Optional;

import EP.ExamenParcial.model.AlumnoModel;

public interface IAlumnoService {
    
    public List<AlumnoModel> findAll();
    public Optional<AlumnoModel> findById(Integer id);
    public AlumnoModel add(AlumnoModel model);
    public AlumnoModel update(AlumnoModel model);
    public Boolean delete(Integer id);
}
