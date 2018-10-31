package me.jun.web.hateoas;


import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HateoasTestController {

    @GetMapping("/hateoas")
    public Resource<Heteoas> heteoasTest(){
        Heteoas heteoas = new Heteoas();
        heteoas.setPrefix("hey,");
        heteoas.setName("junmyoung");

        Resource<Heteoas> heteoasResource = new Resource<>(heteoas);
        heteoasResource.add(linkTo(methodOn(HateoasTestController.class).heteoasTest()).withSelfRel());

        return  heteoasResource;
    }

}
