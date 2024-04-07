import React, { useEffect, useState } from "react";
import eventService from "../../../services/eventService";

const Attendance = ({ eventId }) => {
    const [attendanceList, setAttendanceList] = useState([]);

    useEffect(() => {
        const fetchAttendance = async () => {
            try {
                const response = await eventService.getAttendanceForEvent(eventId);
                setAttendanceList(response.data);
            } catch (error) {
                console.error('Error fetching attendance:', error);
            }
        };

        fetchAttendance();
    }, [eventId]);

    return (
        <div className="container mt-4">
            <div className="row">
                <div className="col-12">
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Role</th>
                            </tr>
                            </thead>
                            <tbody>
                            {attendanceList.map(person => (
                                <tr key={person.personName}>
                                    <td>{person.personName}</td>
                                    <td>{person.roleType}</td>
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

export default Attendance;
