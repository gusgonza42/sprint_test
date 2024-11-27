package ilerna.test.controller;

import ilerna.test.model.Montain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/montains")
public class MontainController {
    ArrayList<Montain> montains = new ArrayList<>();

    private void initMontains() {
        montains.add(new Montain(1, "Montseny", "Vallès Oriental", "Serralada", 1706, "Si"));
        montains.add(new Montain(2, "Montserrat", "Bages", "Massís", 1236, "Si"));
        montains.add(new Montain(3, "Pedraforca", "Berguedà", "Massís", 2506, "Si"));
        montains.add(new Montain(4, "Puigmal", "Cerdanya", "Massís", 2913, "Si"));
        montains.add(new Montain(5, "Canigó", "Conflent", "Massís", 2784, "Si"));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Montain>> getMontain() {
        initMontains();

        for (Montain montain : montains) {
            System.out.println(montain);
        }

        return ResponseEntity.ok(montains);
    }

    @PostMapping
    public ResponseEntity<Montain> createMontain(@RequestBody Montain montain) {
        Montain newMontain = new Montain(montain.getId(), montain.getNom(), montain.getComarca(), montain.getUnitatDeRelleu(), montain.getAltura(), montain.getDestacat());
        System.out.println("New montain created: " + newMontain);
        //montain.add(newMontain);
        return ResponseEntity.status(201).body(newMontain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Montain> updateMontain(@PathVariable int id, @RequestBody Montain montain) {
        Montain updatedMontain = new Montain(id, montain.getNom(), montain.getComarca(), montain.getUnitatDeRelleu(), montain.getAltura(), montain.getDestacat());
        System.out.println("Montain updated: " + updatedMontain);

        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Montain> deleteMontain(@PathVariable int id) {
        for (Montain montain : montains) {
            if (montain.getId() == id) {
                montains.remove(montain);
                System.out.println("Montain deleted: " + montain);
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
}