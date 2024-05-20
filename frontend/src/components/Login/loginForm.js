import React, {useState} from 'react';

const LoginForm = ({onLogin}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError(null);
        try {
            const token = btoa(`${username}:${password}`);
            await onLogin(token);
            localStorage.setItem('token', token);
            window.location.href = "/";
        } catch (error) {
            setError('Login failed');
        }
        setLoading(false);
    };

    return (
            <div className="row mt-5 d-flex justify-content-center">
                <div className="col-md-5">
                    <form onSubmit={handleSubmit}>

                        <div className="form-group mt-5 mb-3">
                            <label htmlFor="username">Username</label>
                            <input
                                type="text"
                                className="form-control"
                                id="username"
                                name="username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />
                        </div>


                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input
                                type="password"
                                className="form-control"
                                id="password"
                                name="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}/>
                        </div>
                        {error && <p>{error}</p>}
                        <button type="submit" disabled={loading}
                                className="btn btn-success mt-3">{loading ? 'Logging in...' : 'Login'}</button>
                    </form>
                </div>
            </div>
    );
};

export default LoginForm;

