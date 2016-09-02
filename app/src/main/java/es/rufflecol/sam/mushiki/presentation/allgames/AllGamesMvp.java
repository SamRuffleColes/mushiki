package es.rufflecol.sam.mushiki.presentation.allgames;

import es.rufflecol.sam.mushiki.presentation.common.BasePresenter;

public interface AllGamesMvp {

    interface Presenter extends BasePresenter<View> {
        void methodOne();
    }

    interface View {
        void methodTwo();
    }

}
