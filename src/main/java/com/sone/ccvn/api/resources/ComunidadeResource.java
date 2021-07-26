package com.sone.ccvn.api.resources;

import com.sone.ccvn.api.services.mapper.ComunidadeMapper;
import com.sone.ccvn.api.services.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.services.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.services.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.services.ComunidadeService;
import com.sone.ccvn.api.services.ReportService;
import com.sone.ccvn.api.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "http://192.168.15.8:4200" })
@RestController
@RequestMapping("/api/v1/community")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComunidadeResource {

    private final ComunidadeService service;

    private final ReportService reportService;

    private final ComunidadeMapper comunidadeMapper;

    @GetMapping
    public List<ComunidadeDTO> listAll() {
        List<ComunidadeDTO> all = service.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadeDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        ComunidadeDTO obj = service.findById(id);
        List<EnderecoDTO> enderecos = obj.getEnderecos();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComunidadeDTO create(@RequestBody ComunidadeDTO obj) {
        ComunidadeDTO comunidadeDTO = service.create(obj);
        return comunidadeDTO;
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updated(@PathVariable Long id, @RequestBody @Valid ComunidadeDTO obj) throws ObjectNotFoundException {
        return service.updateById(id, obj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ObjectNotFoundException {
        service.delete(id);
    }

    @GetMapping("/report/{format}")
    public ResponseEntity<byte[]> generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return reportService.exportReport(format);
    }

//    @GetMapping("/report/{format}")
//    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//        return reportService.exportReport(format);
//    }
}
