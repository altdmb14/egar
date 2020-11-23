package ru.egar.service;

import ru.egar.model.Zakaz;
import ru.xml.Specification;

import java.util.List;

public interface ZakazService {
    Zakaz getById(Long id);
    List<Zakaz> allZakaz();
    void add(Zakaz zakaz);
    void delete(Zakaz zakaz);
    void edit(Zakaz zakaz);
    void addSpecification(Specification specification);
}
