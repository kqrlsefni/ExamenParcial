package EP.ExamenParcial.service;

import java.util.List;

import EP.ExamenParcial.model.AlumnoModel;

public interface IAlumnoService {
    
    public List<AlumnoModel> findAll();
    public AlumnoModel findById();
    public AlumnoModel add(AlumnoModel model);
    public AlumnoModel update(AlumnoModel model);
    public Boolean delete(Integer id);
}
