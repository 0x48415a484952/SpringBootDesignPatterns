package ir.sleepycat.springdesignpatterns.controller;

import ir.sleepycat.springdesignpatterns.designpatterns.builder.Contact;
import ir.sleepycat.springdesignpatterns.designpatterns.builder.ContactBuilder;
import ir.sleepycat.springdesignpatterns.designpatterns.repository.PresidentEntity;
import ir.sleepycat.springdesignpatterns.designpatterns.repository.PresidentRepository;
import ir.sleepycat.springdesignpatterns.dto.PetDto;
import ir.sleepycat.springdesignpatterns.enumeration.Animal;
import ir.sleepycat.springdesignpatterns.exceptions.EntityNotFoundException;
import ir.sleepycat.springdesignpatterns.designpatterns.factory.Pet;
import ir.sleepycat.springdesignpatterns.designpatterns.factory.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.Optional;

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
        if (animal == null) throw new EntityNotFoundException();
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
    public ResponseEntity<Contact> getContacts() {
        Contact contact = new ContactBuilder()
                .setFirstName("Hazhir")
                .setLastName("Ahmadzadeh")
                .setPhoneNumber("0912 411 90 19")
                .setAge(27)
                .build();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @Autowired
    PresidentRepository presidentRepository;

    //it's better to return a DTO instead of entity
    @GetMapping("presidents/{id}")
    public ResponseEntity<PresidentEntity> getPresidentById(@PathVariable Long id) {
        Optional<PresidentEntity> presidentEntity = this.presidentRepository.findById(id);
        if (presidentEntity.isPresent()) {
            return new ResponseEntity<>(presidentEntity.get(), HttpStatus.OK);
        }
        throw new EntityNotFoundException();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("presidentContact/{id}")
    public ResponseEntity<Contact> getPresidentContactById(@PathVariable Long id) {
        PresidentEntity entity = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}",
                PresidentEntity.class,
                id).getBody();
        assert entity != null;
        return (new ResponseEntity<Contact>(new ContactBuilder()
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName()).build(), HttpStatus.OK)
        );
    }
}
