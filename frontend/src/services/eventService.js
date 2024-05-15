import axios from '../api/axios';

const eventService = {
    getAllEvents: () => {
        return axios.get("/public/events")
    },
    createEvent: (name, venue, date, eventType, budget, companyId, coordinatorId) => {
        return axios.post("/mgmt/event/create", {
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
        return axios.get("/mgmt/event/company")
    },
    getAllCoordinators: ()=> {
        return axios.get("/mgmt/event/coordinators")
    },
    getAttendanceForEvent: (id) => {
        return axios.get(`/mgmt/event/attendance/${id}`)
    }
}

export default eventService;