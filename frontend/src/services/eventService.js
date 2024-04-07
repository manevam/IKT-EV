import axios from '../api/axios';

const eventService = {
    getAllEvents: () => {
        return axios.get("/event/all")
    },
    createEvent: (event) => {
        return axios.post("/event/create", {
            "event": event
        })
    },
    getEventsPerCompany: () => {
        return axios.get("/event/company")
    },
    getAllCoordinators: ()=> {
        return axios.get("/event/coordinators")
    },
    getAttendanceForEvent: (id) => {
        return axios.get(`/event/attendance/${id}`)
    }
}

export default eventService;