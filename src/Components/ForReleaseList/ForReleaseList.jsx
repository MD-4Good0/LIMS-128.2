import React, { useState } from 'react';
import './ForReleaseList.css';
import Userfront from "@userfront/core";
import { useNavigate } from 'react-router-dom';

import blue_logo_icon from '../Assets/BlueLogo.png';

Userfront.init("jb7ywq8b");

const Register = () => {
    return (
        <div className="request-all-container">
            <div className='request-container'>
                <div className='request-title'>For Release List</div>
                <div className="request-1st-container">
                    <img src={blue_logo_icon} alt="Blue Logo Icon" className="blue-logo-icon" />

                    <h1 className='msg-noreqres1'>
                            There are no documents for
                    </h1>
                    <h1 className='msg-noreqres2'>
                            release as of the moment.
                    </h1>
                </div>
            </div>
        </div>
    );
}

export default Register;