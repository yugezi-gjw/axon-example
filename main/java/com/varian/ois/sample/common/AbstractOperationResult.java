package com.varian.ois.sample.common;

/**
 * Created by gbt1220 on 10/9/2016.
 */
public abstract class AbstractOperationResult implements OperationResult {

    private boolean success;

    private boolean warning;

    private boolean error;

    private String text;

    protected AbstractOperationResult() {
        super();
        success = false;
        warning = false;
        error = false;
        text = null;
    }

    protected AbstractOperationResult(OperationResultType operationResultType, String text) {
        this.success = operationResultType.equals(OperationResultType.SUCCESS);
        this.warning = operationResultType.equals(OperationResultType.WARNING);
        this.error = operationResultType.equals(OperationResultType.ERROR);
        this.text = text;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean isWarning() {
        return warning;
    }

    @Override
    public boolean isError() {
        return error;
    }

    @Override
    public String getText() {
        return text;
    }
}
