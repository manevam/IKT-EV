import React, { useEffect, useState } from "react";
import eventService from "../../../services/eventService";

const GetAllCoordinators = () => {
    const [coordinators, setCoordinators] = useState([]);

    useEffect(() => {
        const fetchCoordinators = async () => {
            try {
                const response = await eventService.getAllCoordinators();
                setCoordinators(response.data);
            } catch (error) {
                console.error('Error fetching coordinators:', error);
            }
        };

        fetchCoordinators();
    }, []);

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-12">
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Role</th>
                                <th scope="col">Event name</th>
                                <th scope="col">Company name</th>
                            </tr>
                            </thead>
                            <tbody>
                            {coordinators.map(coordinator => (
                                <tr key={coordinator.coordinatorId}>
                                    <td>{coordinator.coordinatorName}</td>
                                    <td>Coordinator</td>
                                    <td>{coordinator.eventName}</td>
                                    <td>{coordinator.companyName}</td>
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

export default GetAllCoordinators;
