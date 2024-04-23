package just.little.test.view.bookhistory;

import just.little.test.entity.BookHistory;

import just.little.test.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bookHistories/:id", layout = MainView.class)
@ViewController("BookHistory.detail")
@ViewDescriptor("book-history-detail-view.xml")
@EditedEntityContainer("bookHistoryDc")
public class BookHistoryDetailView extends StandardDetailView<BookHistory> {
}