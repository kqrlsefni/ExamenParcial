package EP.ExamenParcial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EP.ExamenParcial.model.AlumnoModel;
import EP.ExamenParcial.service.AlumnoService;

@RestController
@RequestMapping("api/alumno")
public class AlumnoController {
    
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("findAll")
    public List<AlumnoModel> findAll() {
       return alumnoService.findAll();
    }

    @GetMapping("findById")
    public Optional<AlumnoModel> findById(@RequestParam Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping("add")
    public AlumnoModel add(@RequestBody AlumnoModel model) {
        return alumnoService.add(model);
    }

    @PutMapping("update")
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        return alumnoService.update(model);
    }

    @DeleteMapping("delete")
    public Boolean delete(@RequestParam Integer id) {
        alumnoService.delete(id);
        return true;
    }
}
