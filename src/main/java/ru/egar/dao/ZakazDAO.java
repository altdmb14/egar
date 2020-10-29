package ru.egar.dao;

import ru.egar.model.Zakaz;

import java.util.List;

public interface ZakazDAO {
    Zakaz getById(int id);
    List<Zakaz> allZakaz();
}
