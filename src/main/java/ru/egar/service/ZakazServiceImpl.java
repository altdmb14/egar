package ru.egar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.dao.ZakazDAO;
import ru.egar.model.Zakaz;
import ru.xml.Specification;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZakazServiceImpl implements ZakazService{
    private ZakazDAO zakazDAO;

    @Autowired
    public void setZakazDAO(ZakazDAO zakazDAO) {
        this.zakazDAO = zakazDAO;
    }

    @Override
    @Transactional
    public Zakaz getById(Long id) {
        return zakazDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Zakaz> allZakaz() {
        return zakazDAO.allZakaz();
    }
    @Override
    @Transactional
    public void add(Zakaz zakaz) {
        zakaz.setDatecreate(LocalDateTime.now());
        zakazDAO.add(zakaz);
    }

    @Override
    @Transactional
    public void delete(Zakaz zakaz) {
        zakazDAO.delete(zakaz);
    }

    @Override
    @Transactional
    public void edit(Zakaz zakaz) {
        zakazDAO.edit(zakaz);
    }

    @Override
    @Transactional
    public void addSpecification(Specification specification) {
        zakazDAO.addSpecification(specification);
    }
}
