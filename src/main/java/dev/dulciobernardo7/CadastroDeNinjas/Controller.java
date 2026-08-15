package dev.dulciobernardo7.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping(  "/boavindas")
    public String boaVindas(){
        return "Seja bem vindo na minha aplicao backend de cadastro de pessoas";
    }

}
