package br.com.sailboat.experiments.custom_view;

import br.com.sailboat.canoe.base.BaseActivitySingleFragment;

public class CustomViewActivity extends BaseActivitySingleFragment<CustomViewFragment> {

    @Override
    protected CustomViewFragment newFragmentInstance() {
        return new CustomViewFragment();
    }

}
