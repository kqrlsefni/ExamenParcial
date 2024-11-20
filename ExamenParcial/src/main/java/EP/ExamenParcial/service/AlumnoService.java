package EP.ExamenParcial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EP.ExamenParcial.exceptions.AlumnoException;
import EP.ExamenParcial.model.AlumnoModel;
import EP.ExamenParcial.repository.IAlumnoRepository;
import EP.ExamenParcial.shared.messages.Constants;
import EP.ExamenParcial.shared.response.ResponseBase;
import lombok.NonNull;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    IAlumnoRepository alumnoRepository;

    @Override
    public ResponseBase<List<AlumnoModel>> findAll() {
        List<AlumnoModel> alumnos = (List<AlumnoModel>) alumnoRepository.findAll();
        if(alumnos.isEmpty()){
            throw new AlumnoException(Constants.EMPTY_DATA,Constants.CODE_NOT_FOUND);
        }
        return new ResponseBase<>(Constants.ITEMS_FOUND,Constants.CODE_OK,alumnos);
    }

    @Override
    public ResponseBase<AlumnoModel> findById(Integer id) {
        Optional<AlumnoModel> alumno = alumnoRepository.findById(id);
        if(alumno.isEmpty()){
                throw new AlumnoException(Constants.ERROR_DATA_ID,Constants.CODE_NOT_FOUND);
            } 
       return new ResponseBase<>(Constants.ITEM_FOUND,Constants.CODE_OK,alumno.get());
        
    }

    @Override
    public ResponseBase<AlumnoModel> create(AlumnoModel model) {
            if(Objects.isNull(model.nombre) || model.nota == null){
                throw new AlumnoException(Constants.ERROR_INVALID_DATA,Constants.CODE_BAD_REQUEST);
            }
            if(model.nombre.isBlank() || model.nombre.length()>Constants.MAX_NOMBRE_LENGTH){
                throw new AlumnoException(Constants.ERROR_DATA_NOMBRE,Constants.CODE_BAD_REQUEST);
            }
            if(model.nota<Constants.MIN_NOTA || model.nota>Constants.MAX_NOTA){
                throw new AlumnoException(Constants.ERROR_DATA_NOTA,Constants.CODE_BAD_REQUEST);
            }

            AlumnoModel saved = alumnoRepository.save(model);
            return new ResponseBase<>(Constants.ITEM_CREATED,Constants.CODE_CREATED,saved);    
        
    }

    @Override
    public ResponseBase<AlumnoModel> update(AlumnoModel model) {
            if(alumnoRepository.findById(model.id).isEmpty()){
                throw new AlumnoException(Constants.ERROR_DATA_ID,Constants.CODE_NOT_FOUND);
            }
            if(model.id == null || Objects.isNull(model.nombre) || model.nota == null){
                throw new AlumnoException(Constants.ERROR_INVALID_DATA,Constants.CODE_BAD_REQUEST);
            }
            if(model.nombre.isBlank() || model.nombre.length()>Constants.MAX_NOMBRE_LENGTH){
                throw new AlumnoException(Constants.ERROR_DATA_NOMBRE,Constants.CODE_BAD_REQUEST);
            }
            if(model.nota<Constants.MIN_NOTA || model.nota>Constants.MAX_NOTA){
                throw new AlumnoException(Constants.ERROR_DATA_NOTA,Constants.CODE_BAD_REQUEST);
            }

            AlumnoModel updated = alumnoRepository.save(model);
            return new ResponseBase<>(Constants.ITEM_UPDATED,Constants.CODE_OK,updated);
    }

    @Override
    public ResponseBase<NonNull> delete(Integer id) {
        if(alumnoRepository.findById(id).isEmpty()){
            throw new AlumnoException(Constants.ERROR_DATA_ID,Constants.CODE_NOT_FOUND);
        }
        alumnoRepository.deleteById(id);
        return new ResponseBase<>(Constants.ITEM_DELETED,Constants.CODE_OK,null);
        
    }
    
}
