import React from "react";
import { Link } from "react-router-dom";

const companies = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                            <tr>
                                <th scope={"col"}>ID</th>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            {props.companies.map((term) => {
                                return (
                                    <tr>
                                        <td>{term.id}</td>
                                        <td>{term.name}</td>
                                        <td>{term.email}</td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link to={"/companies/add"} className={"btn btn-block btn-success"}>Add new company</Link>
                            <Link to={"/"} className={"btn btn-block btn-primary ms-3"}>Back</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default companies;