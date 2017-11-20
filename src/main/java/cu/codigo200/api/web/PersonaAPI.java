package cu.codigo200.api.web;

import cu.codigo200.api.controller.PersonaLista;
import cu.codigo200.api.model.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoandypv on 19/11/17.
 */

@RestController
@Api(value="personasapi", description="Operaciones sobre la clase Persona")
public class PersonaAPI {

    @Autowired
    PersonaLista personaLista;

    @ApiOperation(value = "Añadir una persona", response = Persona.class)
    @RequestMapping(value = "/adicionarPersona", method = RequestMethod.POST)
    public Persona crearPersona(@RequestBody Persona persona) {
        try {
            return this.personaLista.adicionarPersona(persona);
        } catch (Exception e) {
            return null;
        }
    }

    @ApiOperation(value = "Ver una lista de personas por edad", response = Persona[].class)

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personas obtenidas correctamente"),
            @ApiResponse(code = 401, message = "No estas autorizado para ver obtener personas"),
            @ApiResponse(code = 403, message = "Está tratando de acceder a una persona no permitida"),
            @ApiResponse(code = 404, message = "La persona de esa edad no fue encontrada")
    })
    @RequestMapping(value = "/buscarPersona", method = RequestMethod.GET)
    public List<Persona> buscarPersonaPorEdad(@RequestParam Integer edad){
        return this.personaLista.buscarPersonasPorEdad(edad.intValue());
    }

}
