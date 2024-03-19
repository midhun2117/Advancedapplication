import React from 'react';
import '../assets/css/Adminstudent.css';
import Adminheader from './Adminheader';

function Adminstudent() {
  return (
    <div><Adminheader/>
    <div className="table-container">
      <table className="custom-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Level</th>
            <th>Mode of Training</th>
          </tr>
        </thead>
        <tbody>
        <tr>
          <td>John Doe</td>
          <td>john@example.com</td>
          <td>Intermediate</td>
          <td>Online</td>
        </tr>
        <tr>
          <td>John </td>
          <td>doe@example.com</td>
          <td>Intermediate</td>
          <td>Offline</td>
        </tr>
        <tr>
          <td>aanand</td>
          <td>aanand@example.com</td>
          <td>Beginner</td>
          <td>Online</td>
        </tr>
        <tr>
          <td>krish</td>
          <td>krish@example.com</td>
          <td>Intermediate</td>
          <td>Offline</td>
        </tr>
        <tr>
        <td>Jane Smith</td>
        <td>jane@example.com</td>
            <td>Beginner</td>
            <td>Offline</td>
          </tr>
          
        </tbody>
      </table>
    </div></div>
  );
}

export default Adminstudent;
