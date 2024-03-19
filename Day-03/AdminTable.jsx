import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import '../assets/css/CourseTable.css';
import Home from './Home';
import Footer from './Footer';


import courseData from './courseData.json'; 

function AdminTable() {
  return (
    <div>
      <Home />
      <div className="table-container">
        <table className="course-table">
          <thead>
            <tr>
              <th>Course Name</th>
              <th>Timing</th>
              <th>Duration</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {courseData.map((course, index) => (
              <tr key={index}>
                <td>{course.courseName}</td>
                <td>{course.timing}</td>
                <td>{course.duration}</td>
                <td>
                  <FontAwesomeIcon icon={faEdit} className="edit-icon" />
                  {" "}
                  <FontAwesomeIcon icon={faTrash} className="delete-icon" />
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Footer />
    </div>
  );
}

export default AdminTable;
