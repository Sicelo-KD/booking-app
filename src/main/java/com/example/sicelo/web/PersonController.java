package com.example.sicelo.web;

import com.example.sicelo.domain.Utilities;
import com.example.sicelo.persistence.model.Person;

import com.example.sicelo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
//@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;
    //@RequestMapping(path="/book", method = RequestMethod.GET)

    @GetMapping("/person/add")
    public String showAddPersonForm(Person user) {
        return "book_now";
    }


    @PostMapping("/person/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(Model model, @RequestBody Person person, @RequestParam("image")MultipartFile file) throws IOException {


        String fileName = StringUtils.cleanPath(Objects.requireNonNull(
                file.getOriginalFilename()));

        personService.create(person);

        String uploadDir = "database/uploads" + person.getId();
        person.setUrlPhoto(uploadDir);
        Utilities.saveFile(uploadDir, fileName, file);
        model.addAttribute("person", person);

        return "profile";
    }
        //    @RequestMapping("/{idNumber}")
//    public String findPersonByIdNumber(@PathVariable String idNumber) {
//        personService.findPersonByIdNumber(idNumber);
//        return "";
//@GetMapping("person/{id}")
//    public String findOne(@PathVariable long id){
//        //personService.findById(id).
//        //        orElseThrow(PersonNotFoundException::new);
//        return "";
//    }


//    }

//    }

    //@DeleteMapping("/person/{id}")
    //public void deleteOne(@PathVariable long id){
        //personService.findById(id).orElseThrow(PersonNotFoundException::new);
        //personService.deleteById(id);
    //}

//    //@PutMapping("/person/{id}")
//    public String updatePerson(@RequestBody Person person, @PathVariable long id){
//        if(person.getId() != id) {
//            throw new PersonNotFoundException("No such Person Exists");
//        }
//        //personService.findById(id).orElseThrow(PersonNotFoundException::new);
//        //return personService.save(person);
//        return "";
//    }

//    @RequestMapping(value = "/person", method = RequestMethod.GET)
//    public String addStudent(Model model) {
//        model.addAttribute("person", new Person());
//        return "create_profile";
//    }
}