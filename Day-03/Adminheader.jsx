import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSignOutAlt, faUser } from "@fortawesome/free-solid-svg-icons";
import "../assets/css/Adminheader.css";
import Eventcards from "./Eventcards";

function Home({ registeredEmail, isLoggedIn }) {
    const navigate = useNavigate();
  return (
    <div>
      <header>
        <div>
          <img src={"https://academy.chess7.com/wp-content/uploads/2023/08/Chess7-Academy-logo-1.png"} alt="Chess Academy Logo" className="logo" />
        </div>
        <nav>
          <ul>
            <li>
              <Link to="/adminhome">Home</Link>
            </li>
            <li>
              <Link to="/adminstudent">Student Details</Link>
            </li>
            <li>
              <Link to="/enroll">Course Details</Link>
            </li>
            
          </ul>
        </nav>
        <div className="logout-icon">
        <div onClick={() => navigate('/')}>
          {isLoggedIn ? (
            <FontAwesomeIcon icon={faUser} />
            
            ) : registeredEmail ? (
                <p>{registeredEmail}</p>
                ) : (
                    <FontAwesomeIcon icon={faSignOutAlt} />
                    )}
                    </div>
        </div>
      </header>
      
    </div>
  );
}

export default Home;
