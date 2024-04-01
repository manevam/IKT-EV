import React from "react";
import { Link } from "react-router-dom";

const header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-fixed" style={{ backgroundColor: "#e3f2fd" }}>
                <div className="container">
                    <a className="navbar-brand" href="/">Event Management</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav ms-auto">
                            <li className="nav-item active">
                                <Link className="nav-link" to={"/users"}>Users</Link>
                            </li>
                            <li className="nav-item active">
                                <Link className="nav-link" to={"/companies"}>Companies</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    )
}

export default header;