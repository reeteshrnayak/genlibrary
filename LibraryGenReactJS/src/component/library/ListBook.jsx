import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class ListBook extends Component {

    constructor(props) {
        super(props)
        this.state = {
            books: [],
            message: null
        }
        this.deleteBook = this.deleteBook.bind(this);
        this.editBook = this.editBook.bind(this);
        this.addBook = this.addBook.bind(this);
        this.reloadBookList = this.reloadBookList.bind(this);
    }

    componentDidMount() {
        this.reloadBookList();
    }

    reloadBookList() {
        ApiService.fetchBooksByLibId(window.localStorage.getItem("libId"))
            .then((res) => {
                this.setState({books: res.data.result})
            });
    }

    deleteBook(bookId) {
        ApiService.deleteBook(bookId)
           .then(res => {
               this.setState({message : 'Book is deleted successfully.'});
               this.setState({books: this.state.books.filter(book => book.id !== bookId)});
           })
    }

    editBook(id) {
        window.localStorage.setItem("bookId", id);
        this.props.history.push('/edit-book');
    }

    addBook() {
        window.localStorage.removeItem("bookId");
        this.props.history.push('/add-book');
    }

    showHome() {
        this.props.history.push('/');
    }

    render() {
        return (
            <div style={{width:'800px'}}>
                
                <h3 className="text-center">Book List</h3>
                <button className="btn btn-success" style={{width:'100px'}} onClick={() => this.addBook()}> Add Book </button>
                        <button className="btn btn-success" onClick={() => this.showHome()} style={{marginLeft: '20px'}}> Home </button>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th className="hidden">Id</th>
                            <th>Book Name</th>
                            <th>Author Name</th>
                            <th>Publication Year</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.books.map( book =>
                                    <tr key={book.id}>
                                        <td style={{width:'300px'}}>{book.name}</td>
                                        <td>{book.author}</td>
                                        <td>{book.year}</td>
                                       
                                        <td style={{width:'175px'}}>
                                            
                                            <button className="btn btn-success" onClick={() => this.editBook(book.id)}> Edit </button>
                                            <button className="btn btn-danger" onClick={() => this.deleteBook(book.id)} style={{marginLeft: '20px'}}> Delete </button>

                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        );
    }

}

export default ListBook;