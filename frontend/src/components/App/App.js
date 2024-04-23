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
import CreateEvent from "../Events/EventAdd/CreateEvent";
import Events from "../Events/EventList/events";
import eventService from "../../services/eventService";
import getAllCoordinators from "../Events/getAllCoordinators/getAllCoordinators";
import data from "bootstrap/js/src/dom/data";
import GetAllCoordinators from "../Events/getAllCoordinators/getAllCoordinators";
import EventsPerCompany from "../Events/EventsPerCompany/eventsPerCompany";
import Attendance from "../Events/EventAttendance/attendance";
import EventAdd from "../Events/EventAdd/eventAdd";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      users: [],
      companies: [],
      events: [],
      coordinators: []
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
              <Route path={"/event"} element={<Events events={this.state.events} />} />
              <Route path={"/event/create"} element={<EventAdd companies={this.state.companies} users={this.state.users} onAddEvent={this.addEvent} />} />
              <Route path={"/event/coordinators"} element={<GetAllCoordinators coordinators={this.state.coordinators} />} />
              <Route path={"/event/company"} element={<EventsPerCompany eventsPerCompany={this.state.eventsPerCompany} />} />
              <Route path={"/event/attendance/:id"} element={<Attendance />} />
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
    this.loadEvents();
    this.loadCoordinators()
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

  loadEvents = () => {
    eventService.getAllEvents()
        .then((data)=>{
          this.setState({
            events: data.data
          })
        });
  }

  loadCoordinators = () => {
    eventService.getAllCoordinators()
        .then((data) => {
          this.setState({
            coordinators: data.data
          })
        });
  }

  addEvent = (event) => {
    eventService.createEvent(event)
        .then(()=>{
          this.loadEvents();
        })
  }

  addCompany = (companyName, companyEmail) => {
    CompanyService.addCompany(companyName, companyEmail)
      .then(() => {
        this.loadCompanies();
      })
  }
}

export default App;
