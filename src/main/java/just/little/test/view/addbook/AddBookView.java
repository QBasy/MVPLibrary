package just.little.test.view.addbook;

import com.google.common.base.Strings;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.app.main.StandardMainView;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

/*
 * To use the view as a main view don't forget to set
 * new value (see @ViewController) to 'jmix.ui.main-view-id' property.
 * Also, the route of this view (see @Route) must differ from the route of default MainView.
 */
@Route("AddBook")
@ViewController("AddBookView")
@ViewDescriptor("Add-Book-View.xml")
public class AddBookView extends StandardMainView {

    @Override
    protected void updateTitle() {
        super.updateTitle();

        String viewTitle = getTitleFromOpenedView();
        UiComponentUtils.findComponent(getContent(), "viewHeaderBox")
                .ifPresent(component -> component.setVisible(!Strings.isNullOrEmpty(viewTitle)));
    }
}