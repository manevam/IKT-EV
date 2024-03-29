import React from "react";
import { Link } from "react-router-dom";

const users = (props) => {
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
                            {props.users.map((term) => {
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
            </div>
        </div>
    );
}

export default users;