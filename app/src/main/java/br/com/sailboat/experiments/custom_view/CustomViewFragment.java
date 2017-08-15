package br.com.sailboat.experiments.custom_view;

import br.com.sailboat.canoe.base.BaseFragment;
import br.com.sailboat.experiments.R;

public class CustomViewFragment extends BaseFragment<CustomViewPresenter> implements CustomViewPresenter.View {


    @Override
    protected int getLayoutId() {
        return R.layout.frg_custom_view;
    }

    @Override
    protected CustomViewPresenter newPresenterInstance() {
        return new CustomViewPresenter(this);
    }

    @Override
    protected void initViews() {
        // TODO
    }

}
