package EP.ExamenParcial.service;


import java.util.List;

import EP.ExamenParcial.model.AlumnoModel;
import EP.ExamenParcial.shared.response.ResponseBase;
import lombok.NonNull;

public interface IAlumnoService {
    
    public ResponseBase<List<AlumnoModel>> findAll();
    public ResponseBase<AlumnoModel> findById(Integer id);
    public ResponseBase<AlumnoModel> create(AlumnoModel model);
    public ResponseBase<AlumnoModel> update(AlumnoModel model);
    public ResponseBase<NonNull> delete(Integer id);
}
