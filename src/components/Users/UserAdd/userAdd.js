import React from "react";
import { useNavigate } from "react-router-dom";

const UserAdd = (props) => {

    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        "personName": "",
        "personEmail": "",
        "phoneNumber": "",
        "companyName": 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const OnFormSubmit = (e) => {
        e.preventDefault();
        const personName = formData.personName;
        const personEmail = formData.personEmail;
        const phoneNumber = formData.phoneNumber;
        const companyName = formData.companyName;
        props.onAddUser(personName, personEmail, phoneNumber, companyName);
        navigate("/users");
    }


    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={OnFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="personName">Name</label>
                        <input type="text"
                            className="form-control"
                            id="personName"
                            name="personName"
                            required
                            onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="personEmail">Email</label>
                        <input type="text"
                            className="form-control"
                            id="personEmail"
                            name="personEmail"
                            required
                            onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="phoneNumber">Phone Number</label>
                        <input type="text"
                            className="form-control"
                            id="phoneNumber"
                            name="phoneNumber"
                            required
                            onChange={handleChange}
                        />
                    </div>

                    <button id="submit" type="submit" className="btn btn-success mt-3">Add New Person</button>
                </form>
            </div>
        </div>
    )
}

export default UserAdd;