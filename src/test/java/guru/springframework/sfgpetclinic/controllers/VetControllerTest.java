package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.faucspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class VetControllerTest {

    @Test
    void listVets() {
        Model modelMocked = new ModelMapImpl();
        SpecialtyService specialtyService = new SpecialityMapService();
        VetService vetService = new VetMapService(specialtyService);
        VetController vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Joe", "Buck", null);
        Vet vet2 = new Vet(2L, "Jane", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
        vetController.listVets(modelMocked);
        assertThat(vetController.listVets(modelMocked))
                .isEqualTo("vets/index");

        Set modelAttribute = (Set) ((ModelMapImpl) modelMocked).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }

}

