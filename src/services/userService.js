import axios from '../api/axios';

const UserService = {
    getUsers: () => {
        return axios.get("/users/all");
    },
    addUser: (personName, personEmail, phoneNumber, companyName) => {
        return axios.post("/users/create", {
            "personName": personName,
            "personEmail": personEmail,
            "phoneNumber": phoneNumber,
            "companyName": companyName
        });
    },
    getUser: (userID) => {
        return axios.get(`/users/${userID}`);
    },
    registerForEvent: (userID, roleId, eventId) => {
        return axios.post(`/users/${userID}/register`, {
            "roleId": roleId,
            "eventId": eventId
        });
    }
}

export default UserService;