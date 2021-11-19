package cl.utalca.idvrv.doxia.Doxia.controllers;


import cl.utalca.idvrv.doxia.Doxia.models.User;
import cl.utalca.idvrv.doxia.Doxia.models.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/miserviciorest")
public class TestController
{

    @Autowired
    UserRepository repo;

    @GetMapping(value = "/test/{userId}")
    public String testMethod(@PathVariable int userId)
    {
        Optional<User> ouser = repo.findById(userId);
        if( ouser.isPresent() )
        {
            return ouser.get().getUsername();
        }

        return "Usuario no existe";
    }

    @GetMapping(value = "test/listado", produces = MediaType.APPLICATION_JSON_VALUE)
    public String mostrarListado()
    {
        List<User> users = repo.findAll();

        Gson gson = new Gson();
        String json = gson.toJson(users);

        return json;
    }


}
