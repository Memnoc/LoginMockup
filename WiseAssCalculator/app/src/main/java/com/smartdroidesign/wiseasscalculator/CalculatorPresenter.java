package com.smartdroidesign.wiseasscalculator;

public class CalculatorPresenter implements CalculatorContract.ForwardInputInteractionToPresenter, CalculatorContract.ForwardDisplayInteractionToPresenter{

    private CalculatorContract.PublishToView publishResult;

    public CalculatorPresenter (CalculatorContract.PublishToView publishResult) {
        this.publishResult = publishResult;

    }
    @Override
    public void onDeleteShortClick() {

    }

    @Override
    public void onDeleteLongClick() {

    }

    @Override
    public void onNumberClick(int number) {

    }

    @Override
    public void onDecimalClick() {

    }

    @Override
    public void onEvaluateClick() {

    }

    @Override
    public void onOperatorClick(String operator) {

    }
}
