package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Controllers;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n03.S05T01N03CaballeroJoan.Model.Service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    private FlorService florService;

    @PostMapping("/clientAdd")
    public ResponseEntity<FlorDTO> florAdd(@RequestBody FlorDTO florDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(florService.createFlor(florDTO));
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/clientUpdate/{id}")
    public ResponseEntity<FlorDTO> florUpdate(@PathVariable Integer id, @RequestBody FlorDTO florDTO){
        try{
            return ResponseEntity.ok(florService.updateFlor(id, florDTO));
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clientDelete/{id}")
    public ResponseEntity<Void> florDelete(@PathVariable Integer id){
        try{
            florService.deleteFlor(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/clientGetOne/{id}")
    public ResponseEntity<FlorDTO> florGetOne(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(florService.getOneFlor(id));
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientGetAll")
    public ResponseEntity<List<FlorDTO>> florGetAll(){
        try{
            return ResponseEntity.ok(florService.getAllFlors());
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
