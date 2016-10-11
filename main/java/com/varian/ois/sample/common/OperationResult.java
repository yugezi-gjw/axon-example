package com.varian.ois.sample.common;

import java.io.Serializable;

/**
 * Created by gbt1220 on 10/9/2016.
 */
public interface OperationResult extends Serializable {
    boolean isSuccess();

    boolean isWarning();

    boolean isError();

    String getText();
}
