import React, { useRef } from "react";
import "../assets/css/Register.css";
import { Link, useNavigate } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Register() {
  const firstName = useRef();
  const lastName = useRef();
  const email = useRef();
  const password = useRef();
  const confirmPassword = useRef();
  const navigate = useNavigate();

  function validateEmail(email) {
    // Email format validation regex
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

  function handleSubmit() {
    if (
      firstName.current.value === "" ||
      lastName.current.value === "" ||
      email.current.value === "" ||
      password.current.value === "" ||
      confirmPassword.current.value === ""
    ) {
      toast.error("Please fill in all fields.");
    } else if (!validateEmail(email.current.value)) {
      toast.error("Please enter a valid email address.");
    } else if (password.current.value.length < 6 || password.current.value.length > 15) {
      toast.error("Password must be between 6 and 15 characters long.");
    } else if (password.current.value !== confirmPassword.current.value) {
      toast.error("Passwords do not match.");
    } else {
      toast.success("Registration successful.");
      navigate("/home");
    }
  }

  return (
    <div id="register_container">
      <div id="register_box">
        <h1 id="register_title">Register</h1>
        <form id="register_form">
          <input
            type="text"
            ref={firstName}
            placeholder="Enter your first name"
            id="register_first_name"
          />
          <input
            type="text"
            ref={lastName}
            placeholder="Enter your last name"
            id="register_last_name"
          />
          <input
            type="email"
            ref={email}
            placeholder="Enter your email"
            id="register_email"
          />
          <input
            type="password"
            ref={password}
            placeholder="Enter your password"
            id="register_password"
          />
          <input
            type="password"
            ref={confirmPassword}
            placeholder="Confirm password"
            id="confirm_password"
          />
          <button id="register_btn" type="button" onClick={handleSubmit}>
            Register
          </button>
        </form>
        <ToastContainer />
        <center>
          <p>
            Already have an account? <Link to="/">Login</Link>
          </p>
        </center>
      </div>
    </div>
  );
}

export default Register;
