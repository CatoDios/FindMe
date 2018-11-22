package carlos.com.findme.presentation.principal.BottomBar.Semana;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.SemanaResponse;
import carlos.com.findme.data.models.Semana_card;

public class SemanaContract  {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void getMenuSemana(SemanaResponse body);

        void clickItemCategorias(Semana_card comidaEntity);

        void error();
    }
    interface Presenter extends BasePresenter{

        void getMenu();
    }
}
