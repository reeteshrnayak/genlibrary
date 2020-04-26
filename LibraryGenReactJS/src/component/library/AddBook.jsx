import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class AddBook extends Component{

    constructor(props){
        super(props);
        this.state ={
            name: '',
            author: '',
            year: '',
            lid: '',
            message: null
        }
        this.saveBook = this.saveBook.bind(this);
    }

    saveBook = (e) => {
        e.preventDefault();
        let book = {name: this.state.name, 
            author: this.state.author, 
            year: this.state.year, 
            lid: window.localStorage.getItem("libId")};
        ApiService.addBook(book)
            .then(res => {
                this.setState({message : 'Book added successfully.'});
                this.props.history.push('/books');
            });
    }

    onChange = (e) =>{
        this.setState({ [e.target.name]: e.target.value });
        console.log(this.state);

    }

    render() {
        return(
            <div>
                <h3 className="text-center">Add Book</h3>
                <form>
                <div className="form-group">
                    <label>Book Name:</label>
                    <input type="text" placeholder="name" name="name" 
                        className="form-control" value={this.state.name} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Author Name:</label>
                    <input placeholder="Author Name" name="author" 
                        className="form-control" value={this.state.author} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Publication Year:</label>
                    <input placeholder="Publication year" name="year" 
                        className="form-control" value={this.state.year} onChange={this.onChange}/>
                </div>
               
                <button className="btn btn-success" onClick={this.saveBook}>Save</button>
            </form>
    </div>
        );
    }
}

export default AddBook;