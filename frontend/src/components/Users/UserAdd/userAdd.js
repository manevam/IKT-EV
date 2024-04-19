import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const UserAdd = (props) => {

    const navigate = useNavigate();

    const [formData, updateFormData] = useState({
        "personName": "",
        "personEmail": "",
        "phoneNumber": "",
        "companyName": props.companies.length > 0 ? props.companies[0].name : "" // Set default company if available
    })

    const [formErrors, setFormErrors] = useState({
        "personName": "",
        "personEmail": "",
        "phoneNumber": ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const validateForm = () => {
        let valid = true;
        const errors = {};

        // Check if personName is empty
        if (!formData.personName.trim()) {
            errors.personName = "Name is required";
            valid = false;
        }

        // Check if personEmail is empty or invalid format
        if (!formData.personEmail.trim() || !/\S+@\S+\.\S+/.test(formData.personEmail)) {
            errors.personEmail = "Invalid email address";
            valid = false;
        }

        // Check if phoneNumber is empty or invalid format
        if (!formData.phoneNumber.trim() || !/^07\d{7}$/.test(formData.phoneNumber)) {
            errors.phoneNumber = "Invalid phone number";
            valid = false;
        }

        setFormErrors(errors);
        return valid;
    };

    const OnFormSubmit = (e) => {
        e.preventDefault();
        if (validateForm()) {
            const { personName, personEmail, phoneNumber, companyName } = formData;
            props.onAddUser(personName, personEmail, phoneNumber, companyName);
            navigate("/users");
        }
    }


    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={OnFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="personName">Name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="personName"
                            name="personName"
                            value={formData.personName}
                            onChange={handleChange}
                        />
                        {formErrors.personName && <small className="text-danger">{formErrors.personName}</small>}
                    </div>

                    <div className="form-group">
                        <label htmlFor="personEmail">Email</label>
                        <input
                            type="text"
                            className="form-control"
                            id="personEmail"
                            name="personEmail"
                            value={formData.personEmail}
                            onChange={handleChange}
                        />
                        {formErrors.personEmail && <small className="text-danger">{formErrors.personEmail}</small>}
                    </div>

                    <div className="form-group">
                        <label htmlFor="phoneNumber">Phone Number</label>
                        <input
                            type="text"
                            className="form-control"
                            id="phoneNumber"
                            name="phoneNumber"
                            value={formData.phoneNumber}
                            onChange={handleChange}
                        />
                        {formErrors.phoneNumber && <small className="text-danger">{formErrors.phoneNumber}</small>}
                    </div>

                    <div className="form-group">
                        <label>Company</label>
                        <select
                            name="companyName"
                            className="form-control"
                            value={formData.companyName}
                            onChange={handleChange}
                        >
                            {props.companies.map((term) => (
                                <option key={term.name} value={term.name}>
                                    {term.name}
                                </option>
                            ))}
                        </select>
                    </div>

                    <button id="submit" type="submit" className="btn btn-success mt-3">
                        Add New Person
                    </button>
                </form>
            </div>
        </div>
    )
}

export default UserAdd;