package com.smartdroidesign.wiseasscalculator;

// Specify how different components are going to talk to each other
public interface CalculatorContract {



    // Our View handles these methods (DisplayFragment)
    interface PublishToView {
        void showResult(String result);

        void showToast(String message);

    }

    // Passes click events from our View (DisplayFragment), to the presenter
    interface ForwardDisplayInteractionToPresenter {
        void onDeleteShortClick();

        void onDeleteLongClick();
    }

    // Passes click events from our View (InputFragment), to the presenter
    interface ForwardInputInteractionToPresenter {
        void onNumberClick(int number);

        void onDecimalClick();
        void onEvaluateClick();
        void onOperatorClick(String operator);
    }


}
