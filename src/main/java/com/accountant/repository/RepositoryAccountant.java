package com.accountant.repository;

import com.accountant.domain.Accountant;

import java.util.List;

public interface RepositoryAccountant extends CrudOperations<Accountant,Long>{

    List<Accountant> findByDateAndNotTracker();

    List<Accountant> findByDataAllDeveloper();
}
