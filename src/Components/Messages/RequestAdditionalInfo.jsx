import React, { useState } from 'react';
import './XMessages.css';
import Userfront from "@userfront/core";
import { useNavigate } from 'react-router-dom'; // Import useNavigate

Userfront.init("jb7ywq8b");

const RequestAddInfo = () => {
    const navigate = useNavigate();

    const handleBack = () => {
        navigate("/PageHomeRecRel")
    };

    return (
        
        <div className='messages-all-container'>
            <div className='messages-container'>
                <div className="messages-text">
                    <p className="left-text">Request</p>
                    <p className="left-text">Additional</p>
                    <p className="left-text">Information</p>

                </div>

                <div className="messages-button">
                    <button className="messages-button-text" onClick={handleBack}>
                        Done
                    </button>
                </div>
            </div>
        </div>
    );
}

export default RequestAddInfo;