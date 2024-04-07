import axios from '../api/axios';

const CompanyService = {
    getCompanies: () => {
        return axios.get("/companies/all");
    },
    addCompany: (companyName, companyEmail) => {
        return axios.post("/companies/create", {
            "name": companyName,
            "email": companyEmail
        });
    },
    getCompany: (companyId) => {
        return axios.get(`/companies/${companyId}`);
    },

}

export default CompanyService;