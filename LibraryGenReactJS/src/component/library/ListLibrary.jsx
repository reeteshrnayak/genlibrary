import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class ListLibrary extends Component {

    constructor(props) {
        super(props)
        this.state = {
            libs: [],
            message: null
        }
        this.showBooks = this.showBooks.bind(this);
        this.reloadLibList = this.reloadLibList.bind(this);
    }

    componentDidMount() {
        this.reloadLibList();
    }

    reloadLibList() {
        ApiService.fetchLibs()
            .then((res) => {
                this.setState({libs: res.data.result})
            });
    }

    showBooks(id) {
       	window.localStorage.setItem("libId", id);
        this.props.history.push('/books');
    }

    render() {
        return (
            <div style={{width:'800px'}}>
                <h2 className="text-center">Library List</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th className="hidden">Id</th>
                            <th>Library Name</th>
                            <th>Type</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.libs.map(lib =>
                                    <tr key={lib.id}>
                                        <td style={{width:'300px'}}>{lib.name}</td>
                                        <td>{lib.type}</td>
                                        <td style={{width:'175px'}}>
                                            <button className="btn btn-success" onClick={() => this.showBooks(lib.id)}> View</button>
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

export default ListLibrary;

