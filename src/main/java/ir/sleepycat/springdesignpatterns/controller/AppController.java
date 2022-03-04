package ir.sleepycat.springdesignpatterns.controller;

import ir.sleepycat.springdesignpatterns.designpatterns.builder.Contact;
import ir.sleepycat.springdesignpatterns.designpatterns.builder.ContactBuilder;
import ir.sleepycat.springdesignpatterns.dto.PetDto;
import ir.sleepycat.springdesignpatterns.enumeration.Animal;
import ir.sleepycat.springdesignpatterns.exceptions.AnimalNotFoundException;
import ir.sleepycat.springdesignpatterns.designpatterns.factory.Pet;
import ir.sleepycat.springdesignpatterns.designpatterns.factory.PetFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/")
public class AppController {

    private final PetFactory petFactory;

    AppController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @PostMapping("pet/{type}/{name}")
    public ResponseEntity<PetDto> createPet(@PathVariable String type, @PathVariable String name) {
        Animal animal = Animal.fromString(type);
        if (animal == null) throw new AnimalNotFoundException();
        Pet pet = this.petFactory.createPet(Animal.valueOf(type.toUpperCase(Locale.ROOT)));
        pet.setName(name);
        PetDto petDto = PetDto.builder().name(pet.getName())
                .type(pet.getAnimal().getType())
                .group(pet.getAnimal().getGroup())
                .type(pet.getAnimal().getType())
                .sound(pet.getAnimal().getSound()).build();
        return new ResponseEntity<>(petDto, HttpStatus.OK);
    }

    @GetMapping("contact")
    public ResponseEntity<Contact> createPet() {
        Contact contact = new ContactBuilder()
                .setFirstName("Hazhir")
                .setLastName("Ahmadzadeh")
                .setPhoneNumber("0912 411 90 19")
                .setAge(27)
                .build();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
