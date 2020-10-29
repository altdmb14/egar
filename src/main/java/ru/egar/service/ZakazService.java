package ru.egar.service;

import ru.egar.model.Zakaz;

import java.util.List;

public interface ZakazService {
    Zakaz getById(int id);
    List<Zakaz> allZakaz();
}
