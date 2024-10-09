import React from 'react';
import './ViewDatabase.css';
import Userfront from "@userfront/core";

import blue_error_icon from '../Assets/BlueError.png';

Userfront.init("jb7ywq8b");

const ViewDatabase = () => {
    return (
        <div className="request-all-container">
            <div className='request-container'>
                <div className='request-title'>Database</div>
                <div className="request-1st-container">
                    <img src={blue_error_icon} alt="Blue Error Icon" className="blue-error-icon" />

                    <h1 className='msg-noreqres1'>
                            Error: Failed to fetch database
                    </h1>
                </div>
            </div>
        </div>
    );
}

export default ViewDatabase;