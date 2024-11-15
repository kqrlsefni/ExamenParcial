package EP.ExamenParcial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EP.ExamenParcial.model.AlumnoModel;
import EP.ExamenParcial.repository.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    IAlumnoRepository alumnoRepository;

    @Override
    public List<AlumnoModel> findAll() {
       return (List<AlumnoModel>) alumnoRepository.findAll();
    }

    @Override
    public Optional<AlumnoModel> findById(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public AlumnoModel add(AlumnoModel model) {
        return alumnoRepository.save(model);
    }

    @Override
    public AlumnoModel update(AlumnoModel model) {
        return alumnoRepository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        alumnoRepository.deleteById(id);
        return true;
    }
    
}
