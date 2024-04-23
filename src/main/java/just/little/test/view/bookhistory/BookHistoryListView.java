package just.little.test.view.bookhistory;

import just.little.test.entity.BookHistory;

import just.little.test.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bookHistories", layout = MainView.class)
@ViewController("BookHistory.list")
@ViewDescriptor("book-history-list-view.xml")
@LookupComponent("bookHistoriesDataGrid")
@DialogMode(width = "64em")
public class BookHistoryListView extends StandardListView<BookHistory> {
}