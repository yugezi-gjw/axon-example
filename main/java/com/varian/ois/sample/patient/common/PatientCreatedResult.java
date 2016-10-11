package com.varian.ois.sample.patient.common;

import com.varian.ois.sample.common.AbstractOperationResult;
import com.varian.ois.sample.common.OperationResultType;

/**
 * Created by gbt1220 on 10/9/2016.
 */
public class PatientCreatedResult extends AbstractOperationResult {

    public PatientCreatedResult() {
        super(OperationResultType.SUCCESS, "The new patient was created successfully.");
    }
}
