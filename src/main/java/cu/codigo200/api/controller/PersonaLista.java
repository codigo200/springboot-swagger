package cu.codigo200.api.controller;

import cu.codigo200.api.model.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yoandypv on 19/11/17.
 */

@Component
public class PersonaLista {

    private List<Persona> listaPersonas;

    public PersonaLista() {
        listaPersonas = new ArrayList<>();
    }

    public Persona adicionarPersona(Persona persona) throws Exception {
        int size = listaPersonas.size();
        this.listaPersonas.add(persona);

        if (size + 1 == this.listaPersonas.size())
            return persona;
        else
            throw new Exception("La persona no fue añadida");

    }

    public List<Persona> buscarPersonasPorEdad(int edad)
    {
        // Usemos una lamba :-)

         return this.listaPersonas.stream()
                .filter(persona -> edad == persona.getEdad())
                .collect(Collectors.toList());
    }
}
