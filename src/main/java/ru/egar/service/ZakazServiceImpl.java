package ru.egar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.dao.ZakazDAO;
import ru.egar.model.Zakaz;

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
    public Zakaz getById(int id) {
        return zakazDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Zakaz> allZakaz() {
        return zakazDAO.allZakaz();
    }
}
