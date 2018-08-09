package com.example.biddemo.demobid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class NameController {

    private NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping(value = "/api")
    public ResponseEntity<?> saveName (@RequestBody NameDTO nameDTO){
        nameService.save(nameDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/{id}")
    public ResponseEntity<?> deleteName (@PathVariable(value = "id") Long id){
        nameService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/api/{id}")
    public ResponseEntity<?> getOneName (@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(nameService.getOne(id),HttpStatus.OK);
    }

    @PutMapping(value = "/api/{id}")
    public ResponseEntity<?> getOneName (@PathVariable(value = "id") Long id,@RequestBody NameDTO nameDTO){
        nameService.update(nameDTO,id);
        return new ResponseEntity<>(nameService.getOne(id),HttpStatus.OK);
    }

    @GetMapping(value = "/api")
    public ResponseEntity<?> getAllName (){
        return new ResponseEntity<>(nameService.getAll(),HttpStatus.OK);
    }

}
