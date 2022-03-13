package com.gabriel.web.service;

import com.gabriel.web.OperationType;
import com.gabriel.web.config.DataConfig;
import com.gabriel.web.exceptions.UnsupportedTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BaseService {

    private static List<String> COLUMN_NAMES;

    @PersistenceContext
    private EntityManager entityManager;

    private DataConfig dataConfig;

    @Autowired
    public BaseService(DataConfig dataConfig) {
        COLUMN_NAMES = dataConfig.getColumns();
    }

    public List<String> getColumnsNames() {
        //task didn't mentioned any other new columns, so I just hard coded it instead of implementing taking it dynamically
        return COLUMN_NAMES;
    }

    public List findColumns(String name, OperationType type) {
        List<String> names = COLUMN_NAMES;
        List res;
        if (!names.contains(name)) {
            throw new UnsupportedTypeException("Unsupported " + name + " name.");
        }

        switch (type) {
            case DUPLICATES:
                res = entityManager.createNativeQuery("select * from tabela_testowa A where (select count(*) from tabela_testowa B where A." + name + " = B." + name + ")>1").getResultList();
                break;
            case UNIQUE:
                res = entityManager.createNativeQuery("select distinct * from tabela_testowa A where (select count(*) from tabela_testowa B where A." + name + " = B." + name + ")<2").getResultList();
                break;
            default:
                throw new UnsupportedTypeException("Unsupported " + type + " type");
        }

        return res;
    }
}
