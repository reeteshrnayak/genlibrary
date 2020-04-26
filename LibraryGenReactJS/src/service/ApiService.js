import axios from 'axios';

const BOOK_API_BASE_URL = 'http://localhost:8080/books';

const LIB_API_BASE_URL = 'http://localhost:8080/libs';

class ApiService {

    fetchLibs() {
        return axios.get(LIB_API_BASE_URL);
    }

    fetchBooksByLibId(libId) {
        return axios.get(BOOK_API_BASE_URL + '/lib/' + libId);
    }

    fetchBookById(bookId) {
        return axios.get(BOOK_API_BASE_URL + '/' + bookId);
    }

    deleteBook(bookId) {
        return axios.delete(BOOK_API_BASE_URL + '/' + bookId);
    }

    addBook(book) {
        return axios.post(""+BOOK_API_BASE_URL, book);
    }

    editBook(book) {
        return axios.put(BOOK_API_BASE_URL + '/' + book.id, book);
    }

}

export default new ApiService();