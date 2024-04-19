package just.little.test.view.book;

import just.little.test.entity.Book;

import just.little.test.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "books", layout = MainView.class)
@ViewController("Book.list")
@ViewDescriptor("book-list-view.xml")
@LookupComponent("booksDataGrid")
@DialogMode(width = "64em")
public class BookListView extends StandardListView<Book> {
    private void addBook() {
        String query = "INSERT INTO book (title, author, available, isbn, genre, publication_date) VALUES (?, ?, ?, ?, ?, ?)";

    }
}