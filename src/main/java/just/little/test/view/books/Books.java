package just.little.test.view.books;


import just.little.test.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "Books", layout = MainView.class)
@ViewController("Books")
@ViewDescriptor("Books.xml")
public class Books extends StandardView {

}