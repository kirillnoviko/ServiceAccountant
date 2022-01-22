package com.accountant.repository;

import com.accountant.domain.Accountant;

import java.util.ArrayList;
import java.util.List;

public class RepositoryAccountantImpl implements  RepositoryAccountant{
    @Override
    public List<Accountant> findAll() {

        Accountant accountant=new Accountant();
        Accountant accountant1=new Accountant();
        accountant.setId(8l);
        accountant.setTask("sgdfg");
        accountant1.setId(8l);
        accountant1.setTask("sgdfg");
        List<Accountant> accountants=new ArrayList<>();
        accountants.add(accountant);
        accountants.add(accountant1);
        return accountants;
    }

    @Override
    public Accountant findOne(Long id) {
        Accountant accountant=new Accountant();
        accountant.setId(8l);
        accountant.setTask("sgdfg");
        return accountant;
    }

    @Override
    public Accountant save(Accountant entity) {
        return null;
    }

    @Override
    public Accountant update(Accountant entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Accountant> findByDateAndNotTracker() {
        return null;
    }

    @Override
    public List<Accountant> findByDataAllDeveloper() {
        return null;
    }
}
