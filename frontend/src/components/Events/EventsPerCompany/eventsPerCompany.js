import eventService from "../../../services/eventService";
import {useEffect, useState} from "react";

const EventsPerCompany = () => {
    const [eventsPerCompany, setEventsPerCompany] = useState([]);

    useEffect(() => {
        // Fetch events per company when component mounts
        eventService.getEventsPerCompany()
            .then(response => setEventsPerCompany(response.data))
            .catch(error => console.error('Error fetching events per company:', error));
    }, []);

    return (
        <div className="container mb-5">
            <div className="row">
                <div className="col-12">
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Events</th>
                                <th scope="col">In [month]</th>
                                <th scope="col">In [year]</th>
                            </tr>
                            </thead>
                            <tbody>
                            {eventsPerCompany.map(event => (
                                <tr key={event.companyName}>
                                    <td>{event.companyName}</td>
                                    <td>{event.numberOfEvents}</td>
                                    <td>{event.eventMonth}</td>
                                    <td>{event.eventYear}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <a href="/event" className="btn btn-sm btn-primary">Back</a>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default EventsPerCompany;