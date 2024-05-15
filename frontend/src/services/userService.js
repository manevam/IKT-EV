import axios from '../api/axios';

const UserService = {
    getUsers: () => {
        return axios.get("/mgmt/users/all");
    },
    addUser: (personName, personEmail, phoneNumber, companyName, role) => {
        return axios.post("/mgmt/users/create", {
            "personName": personName,
            "personEmail": personEmail,
            "phoneNumber": phoneNumber,
            "companyName": companyName,
            "role": role
        });
    },
    getUser: (userID) => {
        return axios.get(`/mgmt/users/${userID}`);
    },
    registerForEvent: (userID, eventId, role) => {
        return axios.post(`/mgmt/users/${userID}/register`, {
            "eventId": eventId,
            "role": role
        });
    }
}

export default UserService;