import { useRef } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "../assets/css/Login.css";
import { Link, useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();
  const email = useRef();
  const password = useRef();

  function handlesubmit() {
    const emailValue = email.current.value;
    const passwordValue = password.current.value;

    if (emailValue === "" || passwordValue === "") {
      notifyError("Please enter email and password");
    } else if (!validateEmail(emailValue)) {
      notifyError("Please enter a valid email address");
    } else if (passwordValue.length < 5 || passwordValue.length > 15) {
      notifyError("Password must be between 6 and 15 characters long");
    } else {
      notifySuccess("Login successful!");
      navigate("/home");
    }
  }

  const validateEmail = (email) => {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  };

  const notifyError = (message) => toast.error(message);

  const notifySuccess = (message) => toast.success(message);

  return (
    <div id="log_body">
      <div id="login_container">
        <div id="login_box">
          <h1 id="login_title">Login</h1>
          <form id="login_form">
            <input
              type="email"
              ref={email}
              placeholder="Enter your email"
              id="email"
            />
            <input
              type="password"
              ref={password}
              placeholder="Enter your password"
              id="password"
            />
            <button id="login_btn" type="button" onClick={handlesubmit}>
              Login
            </button>
          </form>
          <center>
            <p>
              Don't have an account? <Link to="/register">Register</Link>
            </p>
          </center>
          <ToastContainer />
        </div>
      </div>
    </div>
  );
}

export default Login;
