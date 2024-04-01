import React from "react";
import { useNavigate } from "react-router-dom";

const CompanyAdd = (props) => {

    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        "companyName": "",
        "companyEmail": ""
       
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const OnFormSubmit = (e) => {
        e.preventDefault();
        const companyName = formData.companyName;
        const companyEmail = formData.companyEmail;
       
        props.onAddCompany(companyName, companyEmail);
        navigate("/companies");
    }


    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={OnFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="companyName">Name</label>
                        <input type="text"
                            className="form-control"
                            id="companyName"
                            name="companyName"
                            required
                            onChange={handleChange}
                        />
                    </div>


                    <button id="submit" type="submit" className="btn btn-success mt-3">Add New Company</button>
                </form>
            </div>
        </div>
    )
}

export default CompanyAdd;