package ru.egar.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.egar.Start;
import ru.egar.model.Zakaz;
import ru.egar.service.ZakazService;
import ru.xml.Specification;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("zakaz")
public class ZakazController {
    private ZakazService zakazService;

    @Autowired
    public void setZakazService(ZakazService zakazService) {
        this.zakazService = zakazService;
    }

    @GetMapping
    public List<Zakaz> list() {
        return zakazService.allZakaz();
    }

    @GetMapping("{id}")
    public Zakaz getOne(@PathVariable(name = "id") Long id) {
        return zakazService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Zakaz zakaz) {
        zakaz.setDatecreate(LocalDateTime.now());
        zakazService.add(zakaz);
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable("id") long id,
            @RequestBody Zakaz zakaz
    ) {
        Zakaz zakazFromDb = zakazService.getById(id);
        BeanUtils.copyProperties(zakaz, zakazFromDb, "id");
        zakazFromDb.setDatecreate(LocalDateTime.now());
        zakazService.edit(zakazFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        Zakaz zakaz = zakazService.getById(id);
        zakazService.delete(zakaz);
    }

    public static final String DEFAULT_DATE_UNMARSHALLING_FILE = "specification.xml";

    public static InputStream getInputStream(String file) {
        ClassLoader classLoader = Start.class.getClassLoader();
        return classLoader.getResourceAsStream(file);
    }

    public static Specification unmarshalDates(InputStream inputFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Specification.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Specification) jaxbUnmarshaller.unmarshal(inputFile);
    }

    @PostMapping("/refresh")
    public void refresh() {
       try {
           Specification specification = unmarshalDates(getInputStream(DEFAULT_DATE_UNMARSHALLING_FILE));
           System.out.println(specification);
            zakazService.addSpecification(specification);
       } catch (Exception e) {
           System.err.println("Error in the XML");
        }

    }
}