package just.little.test.view.userbooks;

import just.little.test.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "userBookses", layout = MainView.class)
@ViewController("UserBooks.list")
@ViewDescriptor("user-books-list-view.xml")
@LookupComponent("userBooksesDataGrid")
@DialogMode(width = "64em")
public class UserBooksListView extends StandardListView<UserBooks> {
}