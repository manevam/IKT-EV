import React, {useState} from "react";
import {useParams, Link} from 'react-router-dom';

const UserRegisterForEvent = ({onRegister, events}) => {

    const {userID} = useParams();
    const [selectedEvent, setSelectedEvent] = useState('1');
    const [selectedRole, setSelectedRole] = useState('USER');
    const [message, setMessage] = useState('');
    const [formData, setFormData] = useState({
        personName: '',
        personEmail: '',
        phoneNumber: ''
    });

    const handleChange = (e) => {
        const {name, value} = e.target;
        if (name === 'event') {
            setSelectedEvent(value);
        } else if (name === 'role') {
            setSelectedRole(value);
        } else {
            setFormData({
                ...formData,
                [name]: value.trim()
            });
        }
    };

    const OnFormSubmit = (e) => {
        e.preventDefault();

        onRegister(userID, selectedEvent, selectedRole)
            .then(() => {
                setMessage('User registered for event successfully.');
                setFormData({
                    personName: '',
                    personEmail: '',
                    phoneNumber: ''
                });
                setSelectedEvent('');
                setSelectedRole('');
            })
            .catch((error) => {
                setMessage(`Error: ${error.message}`);
            });
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={OnFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="personName">Name</label>
                        <input type="text"
                               className="form-control"
                               id="personName"
                               name="personName"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="personEmail">Email</label>
                        <input type="text"
                               className="form-control"
                               id="personEmail"
                               name="personEmail"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="phoneNumber">Phone Number</label>
                        <input type="text"
                               className="form-control"
                               id="phoneNumber"
                               name="phoneNumber"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="event">Events</label>
                        <select name="event" className="form-control" onChange={handleChange}>
                            {events.map((event) => (
                                <option key={event.id} value={event.id}>
                                    {event.name} by {event.company.name}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="role">Role</label>
                        <select name="role" className="form-control" onChange={handleChange} value={selectedRole}>
                            <option value="USER">User</option>
                            <option value="ADMIN">Admin</option>
                        </select>
                    </div>

                    <button id="submit" type="submit" className="btn btn-success mt-3">Register to Event</button>
                    <Link to={"/users"} className={"btn btn-block btn-primary ms-3 mt-3"}>Back to users</Link>
                </form>
            </div>
            {message && <p>{message}</p>}
        </div>
    );
};

export default UserRegisterForEvent;