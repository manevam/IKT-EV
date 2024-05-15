import axios from '../api/axios';

const CompanyService = {
    getCompanies: () => {
        return axios.get("/public/companies");
    },
    addCompany: (companyName, companyEmail) => {
        return axios.post("/mgmt/companies/create", {
            "name": companyName,
            "email": companyEmail
        });
    },
    getCompany: (companyId) => {
        return axios.get(`/mgmt/companies/${companyId}`);
    },

}

export default CompanyService;