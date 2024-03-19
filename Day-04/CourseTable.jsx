import React from 'react';
import '../assets/css/CourseTable.css'; 
import Home from './Home';
import Footer from './Footer';

function CourseTable() {
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
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Chess Basics</td>
              <td>Monday, Wednesday, Friday 6:00 PM - 7:00 PM</td>
              <td>12 weeks</td>
            </tr>
            <tr>
              <td>Advanced Strategies</td>
              <td>Tuesday, Thursday 5:00 PM - 7:00 PM</td>
              <td>8 weeks</td>
            </tr>
            
          
            <tr>
              <td>Mastering Pawn Structures</td>
              <td>Wednesday 6:00 PM - 8:00 PM</td>
              <td>10 weeks</td>
            </tr>
            <tr>
              <td>Attack and Defense</td>
              <td>Monday 7:00 PM - 9:00 PM</td>
              <td>8 weeks</td>
            </tr>
          </tbody>
        </table>
      </div>
      <Footer />
    </div>
  );
}

export default CourseTable;
