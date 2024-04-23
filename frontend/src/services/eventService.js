import axios from '../api/axios';

const eventService = {
    getAllEvents: () => {
        return axios.get("/event/all")
    },
    createEvent: (name, venue, date, eventType, budget, companyId, coordinatorId) => {
        return axios.post("/event/create", {
            "name":name,
            "venue":venue,
            "date":date,
            "eventType":eventType,
            "budget":budget,
            "companyId":companyId,
            "coordinatorId":coordinatorId
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