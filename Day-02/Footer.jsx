import React from 'react';
import FacebookIcon from '@mui/icons-material/Facebook';
import TwitterIcon from '@mui/icons-material/Twitter';
import InstagramIcon from '@mui/icons-material/Instagram';
import WhatsAppIcon from '@mui/icons-material/WhatsApp';
import { useNavigate } from 'react-router-dom';
import '../assets/css/Footer.css';

function Footer() {
  const navigate = useNavigate();
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-content">
          <div className="footer-section">
            <h3 onClick={() => navigate('/privacy')}>Privacy Policy</h3>
          </div>
          <div className="footer-section">
            <h3 onClick={() => navigate('/terms')}>Terms & Conditions</h3>
          </div>
          <div className="footer-section">
            <h3 onClick={() => navigate('/contact')}>Contact Info</h3>
          </div>
          <div className="footer-section">
            <h3 onClick={() => navigate('/faq')}>FAQs</h3>
          </div>
          <div className="footer-section">
            <h3>Social Media</h3>
            <div className="social-icons">
              <span onClick={() => window.open('https://www.facebook.com/', '_blank')}>
                <FacebookIcon />&nbsp;&nbsp;&nbsp;
              </span>
              <span onClick={() => window.open('https://www.whatsapp.com/', '_blank')}>
                <WhatsAppIcon />&nbsp;&nbsp;&nbsp;
              </span>
              <span onClick={() => window.open('https://twitter.com/i/flow/single_sign_on', '_blank')}>
                <TwitterIcon />&nbsp;&nbsp;&nbsp;
              </span>
              <span onClick={() => window.open('https://www.instagram.com/', '_blank')}>
                <InstagramIcon />&nbsp;&nbsp;&nbsp;
              </span>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
