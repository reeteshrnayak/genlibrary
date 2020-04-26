import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListBook from "./component/library/ListBook";
import AddBook from "./component/library/AddBook";
import EditBook from "./component/library/EditBook";
import ListLibrary from "./component/library/ListLibrary";

function App() {
  return (
      <div className="container">
          <Router>
              <div className="col-md-6">
                  <h2 className="text-left" style={style}>Welcome To Library</h2>
                  <Switch>
                      <Route path="/" exact component={ListLibrary} />
                      <Route path="/books" component={ListBook} />
                      <Route path="/add-book" component={AddBook} />
                      <Route path="/edit-book" component={EditBook} />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

const style = {
    color: 'blue',
    margin: '10px',
    width:'800px'
}

export default App;
