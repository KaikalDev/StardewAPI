package kaique.luan.dev.stardewapi.controller;

import kaique.luan.dev.stardewapi.domain.models.Culinary;
import kaique.luan.dev.stardewapi.domain.models.DTO.CulinaryDTO;
import kaique.luan.dev.stardewapi.service.intefaces.ICulinaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/culinary")
public class CulinaryController {

    private final ICulinaryService culinaryService;

    public CulinaryController(ICulinaryService culinaryService) {
        this.culinaryService = culinaryService;
    }

    @PostMapping
    public ResponseEntity<Culinary> post(@RequestBody CulinaryDTO dto) {
        var culinaryCreated = culinaryService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{itemId}")
                .buildAndExpand(culinaryCreated.getItem().getItemId())
                .toUri();
        return ResponseEntity.created(location).body(culinaryCreated);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Culinary> findByItemId(@PathVariable Long itemId) {
        var culinary = culinaryService.getCulinaryByItemId(itemId);
        return ResponseEntity.ok(culinary);
    }

    @GetMapping
    public ResponseEntity<List<Culinary>> getAll() {
        var culinarys = culinaryService.getAllCulinarys();
        return ResponseEntity.ok(culinarys);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Culinary> update(@PathVariable Long id, @RequestBody Culinary culinaryToUpdate) {
        culinaryToUpdate.setId(id);
        var updated = culinaryService.updateCulinary(culinaryToUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Culinary toDelete = new Culinary();
        toDelete.setId(id);
        culinaryService.deleteCulinary(toDelete);
        return ResponseEntity.noContent().build();
    }

}
