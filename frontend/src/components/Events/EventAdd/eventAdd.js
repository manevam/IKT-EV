import React from 'react';
import { useNavigate } from "react-router-dom";

const EventAdd = (props) => {

    const navigate = useNavigate();
    const  [formData, updateFormData] = React.useState({
        "name": "",
        "venue": "",
        "date": "",
        "eventType": "",
        budget: 0,
        companyId: 1,
        coordinatorId: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
        console.log(formData);
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const venue = formData.venue;
        const date = formData.date;
        const eventType = formData.eventType;
        const budget = formData.budget;
        const companyId = formData.companyId;
        const coordinatorId = formData.coordinatorId;

        props.onAddEvent(name, venue, date, eventType, budget, companyId, coordinatorId);
        navigate("/events");

    }

    return (
        <div className="container mt-5">
            <form onSubmit={onFormSubmit} className="row">
                <div className="col-md-6">
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input type="text" name="name" className="form-control" onChange={handleChange} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="venue">Venue</label>
                        <input type="text" name="venue" className="form-control" onChange={handleChange} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="date">Date</label>
                        <input
                            type="date"
                            id="date"
                            name="date"
                            className="form-control"
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="eventType">Event Type</label>
                        <input type="text" name="eventType" className="form-control" onChange={handleChange} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="budget">Budget</label>
                        <input type="text" name="budget" className="form-control" onChange={handleChange} required />
                    </div>
                </div>

                <div className="col-md-6">
                    <div className="form-group">
                        <label htmlFor="companyId">Company</label>
                        <select name="companyId" className="form-control" multiple={false} onChange={handleChange}>
                            {props.companies.map((term) =>
                            <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="coordinatorId">Coordinator</label>
                        <select name="coordinatorId" className="form-control" onChange={handleChange}>
                            {props.users.map((term) =>
                            <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <button type="submit" className="btn btn-success">Add new Event</button>
                    </div>
                    <div className="form-group">
                        <a href="/events" className="btn btn-primary">Back to events</a>
                    </div>
                </div>
            </form>
        </div>
    );

}

export default EventAdd;