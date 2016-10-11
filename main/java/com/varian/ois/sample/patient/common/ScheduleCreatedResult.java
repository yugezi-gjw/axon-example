package com.varian.ois.sample.patient.common;

import com.varian.ois.sample.common.AbstractOperationResult;
import com.varian.ois.sample.common.OperationResultType;

/**
 * Created by gbt1220 on 10/11/2016.
 */
public class ScheduleCreatedResult extends AbstractOperationResult {
    public ScheduleCreatedResult() {
        super(OperationResultType.SUCCESS, "The patient add new schedule successfully.");
    }
}
