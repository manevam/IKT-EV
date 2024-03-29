import './App.css';
import React, { Component } from "react";
import Users from '../Users/UserList/users';
import UserAdd from '../Users/UserAdd/userAdd';
import UserService from '../../services/userService';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from '../Header/header';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      users: []
    };
  }

  render() {
    return (
      <Router>
        <Header />
        <main>
          <div className="container">
            <Routes>
              <Route path={"/users/add"} element={<UserAdd userAdd={this.state.users} onAddUser={this.addUser} />} />
              <Route path={"/users"} element={<Users users={this.state.users} />} />
            </Routes>
          </div>
        </main>
      </Router>
    );
  }

  componentDidMount() {
    this.fetchData()
  }

  fetchData = () => {
    this.loadUsers();
  }

  loadUsers = () => {
    UserService.getUsers()
      .then((data) => {
        this.setState({
          users: data.data
        })
      });
  }

  addUser = (personName, personEmail, phoneNumber, companyName) => {
    UserService.addUser(personName, personEmail, phoneNumber, companyName)
      .then(() => {
        this.loadUsers();
      })
  }

}

export default App;
