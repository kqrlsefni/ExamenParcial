package EP.ExamenParcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EP.ExamenParcial.model.AlumnoModel;
import EP.ExamenParcial.service.AlumnoService;
import EP.ExamenParcial.shared.endpoints.Endpoints;
import EP.ExamenParcial.shared.response.ResponseBase;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Endpoints.API_ALUMNO)
@Slf4j
public class AlumnoController {
    
    @Autowired
    AlumnoService alumnoService;

    @GetMapping(Endpoints.FIND_ALL)
    public ResponseEntity<ResponseBase<List<AlumnoModel>>> findAll() {
        ResponseBase<List<AlumnoModel>> res = alumnoService.findAll();
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(res.getStatus()));
    }

    @GetMapping(Endpoints.FIND_BY_ID)
    public ResponseEntity<ResponseBase<AlumnoModel>> findById(@PathVariable Integer id) {
        ResponseBase<AlumnoModel> res = alumnoService.findById(id);
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(res.getStatus()));
    }

    @PostMapping(Endpoints.CREATE)
    public ResponseEntity<ResponseBase<AlumnoModel>> create(@RequestBody AlumnoModel model) {
        ResponseBase<AlumnoModel> res = alumnoService.create(model);
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(res.getStatus()));
    }

    @PutMapping(Endpoints.UPDATE)
    public ResponseEntity<ResponseBase<AlumnoModel>> update(@RequestBody AlumnoModel model) {
        ResponseBase<AlumnoModel> res = alumnoService.update(model);
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(res.getStatus()));
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<ResponseBase<NonNull>> delete(@PathVariable Integer id) {
        ResponseBase<NonNull> res = alumnoService.delete(id);
        return new ResponseEntity<>(res,HttpStatusCode.valueOf(res.getStatus()));
    }
}
