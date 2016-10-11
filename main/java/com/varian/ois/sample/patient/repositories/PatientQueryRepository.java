package com.varian.ois.sample.patient.repositories;

import com.varian.ois.sample.patient.model.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by gbt1220 on 9/28/2016.
 */
public interface PatientQueryRepository extends PagingAndSortingRepository<PatientEntity, String> {
}
