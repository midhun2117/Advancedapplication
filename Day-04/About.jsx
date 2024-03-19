
import React from 'react';
import '../assets/css/About.css';
import Home from './Home';
import Footer from './Footer';

function About() {
  return (
    <div><Home/>
    <div className="about-us-container">
      <h1 className="about-us-title">About Chess Academy</h1>
      <div className="about-us-content">
        <p>
          Chess Academy is dedicated to providing top-notch chess education to enthusiasts of all
          ages and skill levels. Founded in [Year], our academy has grown to become a leading
          institution in the world of chess.
        </p>
        <h2>Our Mission</h2>
        <p>
          Our mission is to foster a love for chess and cultivate the next generation of chess
          masters. We aim to provide accessible and comprehensive chess training programs that
          empower individuals to reach their full potential in the game.
        </p>
        <h2>Our Vision</h2>
        <p>
          Chess Academy envisions a world where chess is not only recognized as a game of strategy
          and intellect but also as a tool for personal growth and development. We strive to
          promote the values of critical thinking, problem-solving, and sportsmanship through the
          game of chess.
        </p>
        <h2>Why Choose Chess Academy?</h2>
        <p>
          At Chess Academy, we offer a unique blend of experienced instructors, innovative
          teaching methods, and cutting-edge technology to deliver unparalleled chess education.
          Whether you're a beginner or a seasoned player, we have programs tailored to meet your
          needs and help you excel in the game.
        </p>
        <h2>Our Team</h2>
        <p>
          Our team consists of highly skilled and passionate chess professionals who are dedicated
          to helping our students succeed. With years of experience in both playing and teaching
          chess, our instructors bring a wealth of knowledge and expertise to the table.
        </p>
        <h2>Get in Touch</h2>
        <p>
          Interested in joining Chess Academy or learning more about our programs? Contact us today
          to speak with one of our representatives and take the first step towards mastering the
          game of chess!
        </p>
      </div>
    </div>
    <Footer/></div>
  );
}

export default About;
