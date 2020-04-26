import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class EditBook extends Component {

    constructor(props){
        super(props);
        this.state ={
            id: '',
            name: '',
            author: '',
            year: '',
            lid: ''
        }
        this.saveBook = this.saveBook.bind(this);
        this.loadBook = this.loadBook.bind(this);
    }

    componentDidMount() {
        this.loadBook();
    }

    loadBook() {
        ApiService.fetchBookById(window.localStorage.getItem("bookId"))
            .then((res) => {
                let book = res.data.result;
                this.setState({
                id: book.id,
                name: book.name,
                author: book.author,
                year: book.year,
                lid: book.lid
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveBook = (e) => {
        e.preventDefault();
        let book = {id: this.state.id, name: this.state.name, author: this.state.author, 
            year: this.state.year, lid: this.state.lid};
        ApiService.editBook(book)
            .then(res => {
                this.setState({message : 'Book added successfully.'});
                this.props.history.push('/books');
        });
    }

    render() {
        return (
            <div>
                <h3 className="text-center">Edit Book Details</h3>
                <form>

                    <div className="form-group">
                        <label>Id:</label>
                        <input type="text" placeholder="id" name="id" className="form-control" readonly="true" defaultValue={this.state.id}/>
                    </div>

                    <div className="form-group">
                        <label>Name:</label>
                        <input type="text" placeholder="name" name="name" className="form-control" value={this.state.name} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Author:</label>
                        <input placeholder="author" name="author" className="form-control" value={this.state.author} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Publication Year:</label>
                        <input placeholder="Publication Year" name="year" className="form-control" value={this.state.year} onChange={this.onChange}/>
                    </div>
                    <button className="btn btn-success" onClick={this.saveBook}>Save</button>
                </form>
            </div>
        );
    }
}

export default EditBook;