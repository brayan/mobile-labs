package br.com.sailboat.experiments.custom_view;

import br.com.sailboat.canoe.base.BasePresenter;

public class CustomViewPresenter extends BasePresenter<CustomViewPresenter.View> {

    public CustomViewPresenter(View view) {
        super(view);
    }

    public interface View extends BasePresenter.View {

    }

}
