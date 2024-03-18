import React from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSignOutAlt, faUser } from "@fortawesome/free-solid-svg-icons";
import "../assets/css/Home.css";
import Footer from "./Footer";

function Home({ registeredEmail, isLoggedIn }) {
  return (
    <div>
      <header>
        <div>
          <img src={"https://academy.chess7.com/wp-content/uploads/2023/08/Chess7-Academy-logo-1.png"} alt="Chess Academy Logo" className="logo" />
        </div>
        <nav>
          <ul>
            <li>
              <Link to="/home">Home</Link>
            </li>
            <li>
              <Link to="/admission">Admission</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
            <li>
              <Link to="/contact">Contact</Link>
            </li>
          </ul>
        </nav>
        <div className="logout-icon">
          {isLoggedIn ? (
            <FontAwesomeIcon icon={faUser} />
          ) : registeredEmail ? (
            <p>{registeredEmail}</p>
          ) : (
            <FontAwesomeIcon icon={faSignOutAlt} />
          )}
        </div>
      </header>
      <Footer/>
    </div>
  );
}

export default Home;
