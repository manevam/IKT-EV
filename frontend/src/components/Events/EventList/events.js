import React from 'react';

const Events = ({isAuthenticated, events}) => {
    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-12">
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">ID:</th>
                                <th scope="col">Name</th>
                                <th scope="col">Venue</th>
                                <th scope="col">Date</th>
                                <th scope="col">Event Type</th>
                                <th scope="col">Budget</th>
                                <th scope="col">Organising Company</th>
                                <th scope="col">Coordinator</th>
                                {isAuthenticated && (
                                    <th scope="col">Actions</th>
                                )}
                            </tr>
                            </thead>
                            <tbody>
                            {events.map((term) => {
                                return (
                                    <tr key={term.id}>
                                        <td>{term.id}</td>
                                        <td>{term.name}</td>
                                        <td>{term.venue}</td>
                                        <td>{term.date}</td>
                                        <td>{term.eventType}</td>
                                        <td>{term.budget}</td>
                                        <td>{term.company.name}</td>
                                        <td>{term.coordinator.name}</td>
                                        {isAuthenticated && (
                                            <td>
                                                <a href={`/event/attendance/${term.id}`}
                                                   className="btn btn-sm btn-success">
                                                    View Attendance List
                                                </a>
                                            </td>
                                        )}
                                    </tr>
                                );
                            })}
                            </tbody>
                        </table>
                    </div>
                    {isAuthenticated && (
                        <div className="d-flex justify-content-between mt-3">
                            <a href="/event" className="btn btn-sm btn-success">
                                Add new event
                            </a>
                            <a href="/event/coordinators" className="btn btn-sm btn-primary">
                                List Coordinators of Events
                            </a>
                            <a href="/event/company" className="btn btn-sm btn-primary">
                                Events Per Company
                            </a>
                        </div>
                    )}
                    <div>
                        <a href="/" className="btn btn-sm btn-primary">Back</a>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Events;
