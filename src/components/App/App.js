import './App.css';
import React, { Component } from "react";
import Users from '../Users/UserList/users';
import UserAdd from '../Users/UserAdd/userAdd';
import UserService from '../../services/userService';
import CompanyService from '../../services/companiesService';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from '../Header/header';
import Companies from '../Companies/CompanyList/companies';
import CompanyAdd from '../Companies/CompanyAdd/companyAdd';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      users: [],
      companies: []
    };
  }

  render() {
    return (
      <Router>
        <Header />
        <main>
          <div className="container">
            <Routes>
              <Route path={"/users/add"} element={<UserAdd userAdd={this.state.users} onAddUser={this.addUser} companies={this.state.companies} />} />
              <Route path={"/users"} element={<Users users={this.state.users} />} />
              <Route path={"/companies/add"} element={<CompanyAdd companyAdd={this.state.companies} onAddCompany={this.addCompany} />} />
              <Route path={"/companies"} element={<Companies companies={this.state.companies} />} />
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
    this.loadCompanies();
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

  loadCompanies = () => {
    CompanyService.getCompanies()
      .then((data) => {
        this.setState({
          companies: data.data
        })
      });
  }

  addCompany = (companyName, companyEmail) => {
    CompanyService.addCompany(companyName, companyEmail)
      .then(() => {
        this.loadCompanies();
      })
  }
}

export default App;
