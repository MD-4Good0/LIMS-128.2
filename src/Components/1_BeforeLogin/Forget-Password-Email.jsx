import React, { useState, useEffect } from 'react';
import './TFA.css';
// import Userfront from "@userfront/core";
import { useNavigate, useParams } from 'react-router-dom';

// Userfront.init("jb7ywq8b");

const ForgetPasswordEmail = () => {
    const navigate = useNavigate(); // Initialize useNavigate hook
    //const [storedEmail, setStoredEmail] = useState(sessionStorage.getItem('userEmail') || '');
    //const [storedUsername, setStoredUsername] = useState('');
    const [verificationCode, setVerificationCode] = useState('');
    const [error, setError] = useState(null);
    const { username } = useParams();

    // Clear sessionStorage item on component mount
    useEffect(() => {
        sessionStorage.removeItem('userEmail');
    }, []);

    /*
    const handleEmailChange = (event) => {
        setStoredEmail(event.target.value);
    };
    */

    /*
    const handleUsernameChange = (event) => {
        setStoredUsername(event.target.value);
    };
    */

    const handleVerificationCodeChange = (event) => {
        setVerificationCode(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
    
        try {
            const response = await fetch(`${process.env.REACT_APP_API_URL}check-user?identifier=${verificationCode}`, {
                method: 'GET',
            });
    
            if (response.ok) {
                const data = await response.json(); // Parse JSON if the backend returns JSON
                console.log('User exists:', data.message);
                alert('Verification code sent to your email.');
            } else {
                const errorText = await response.text();
                console.error('Error response:', errorText);
                alert('No user exists with this email.');
            }
        } catch (error) {
            console.error('Error identifying user:', error);
            alert('Error identifying user. Please try again.');
        }
    };

    return (
        <div className='tfa-all-container'>
            <div className='tfa-all-left'>
            <form className="verification" onSubmit={handleSubmit}>
                <div className='tfa-container'>
                    <div className='t-c-container'>
                        <p className="t-c-c-title">
                            Forget your
                        </p>
                        <p className="t-c-c-title">
                            Password?
                        </p>
                        <p className="t-c-c-text">
                        Enter your email to reset your account's password.
                        </p>
                        
                    </div>
                    <div className="tfa-email">
                        {/*<div className="tfa-input">
                            <input 
                                className="font-link"
                                type="text" 
                                value={storedUsername}
                                placeholder="Username"
                                onChange={handleUsernameChange}
                            />
                        </div>   
                        */}                                    
                        <div className="tfa-input">
                            <input 
                                className="font-link"
                                type="text" 
                                value={verificationCode}
                                placeholder="Email"
                                onChange={handleVerificationCodeChange}
                            />
                        </div>
                    </div>

                    <div className="login-button">
                        <button className="text-button" value="Verify Account">Send Verification Code</button>
                    </div>
                </div>
                </form>
            </div>
            {/*
            <div className='all-right'>
                <p className="all-right-first-row">
                    Welcome to the
                </p>
                <div className="all-right-second-row">
                    <p className="N">N</p>
                    <p className="M">M</p>
                    <p className="I">I</p>
                    <p className="S">S</p>
                    <p className="spacing">.</p>
                    <p className="laboratory">Laboratory</p>
                    <p className="services">Services</p>
                </div>
                <div className="all-right-third-row">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Vivamus metus arcu, molestie ac tempor at, fringilla eget ligula. 
                        Vestibulum scelerisque viverra tempor. Sed efficitur risus id cursus viverra. 
                        Proin ullamcorper nulla sed nisi ultricies molestie. Ut posuere pulvinar ornare. 
                        Nunc sit amet est sit amet justo mollis fermentum. Fusce sollicitudin eleifend gravida. 
                        Donec non mattis nunc. Mauris sollicitudin viverra elit, eu pretium diam blandit id. 
                        Aenean dolor ipsum, gravida a neque varius, pulvinar pharetra metus. 
                        Donec auctor arcu at malesuada hendrerit. Nunc luctus, magna sed efficitur ornare, 
                        mauris tellus sagittis lacus, sed fermentum tortor leo et tellus. Aliquam erat volutpat. 
                        Ut sapien sem, viverra vel sapien ut, lobortis sollicitudin lacus.
                    </p>
                </div>
            </div>
            */}
        </div>
    );
}

export default ForgetPasswordEmail;