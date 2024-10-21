import React, { useState } from 'react';
import './Register.css';
import Userfront from "@userfront/core";
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import eyeOpen from '../Assets/EyeOpen.png';
import eyeClose from '../Assets/EyeClose.png';

Userfront.init("jb7ywq8b");

const Register = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [visible, setVisible] = useState(false);
    const [repeatPassword, setRepeatPassword] = useState("");
    const [repeatPasswordVisible, setRepeatPasswordVisible] = useState(false);
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [firstName, setFirstName] = useState("");
    const [middleInitial, setMiddleInitial] = useState("");
    const [lastName, setLastName] = useState("");
    const [companyName, setCompanyName] = useState("");
    const [ltoNumber, setLtoNumber] = useState("");
    const [contactNumber, setContactNumber] = useState("");
    const [clientClassification, setClientClassification] = useState("");
    const [otherClientClassification, setOtherClientClassification] = useState("");


    const navigateAfterLogin = () => {
        navigate("/");
    }

    const handleRegister = async () => {
        if (!email.trim() || !password.trim() || !firstName.trim() || !lastName.trim() || !companyName.trim() || !ltoNumber.trim() || !contactNumber.trim() || !clientClassification.trim()) {
            alert("Please fill in all required fields.");
            return;
        }
    
        try {
            const response = await Userfront.login({
                method: "password",
                email: email,
                password: password,
                firstName: firstName,
                lastName: lastName,
                companyName: companyName,
                ltoNumber: ltoNumber,
                contactNumber: contactNumber,
                clientClassification: clientClassification,
                otherClientClassification: otherClientClassification
            });
    
            console.log("Login Response:", response);
    
            if (response?.success === true) {
                navigateAfterLogin();
            }
        } catch (error) {
            alert("Incorrect username and password.");
        }
    };

    const handleForgetPassword = () => {
        navigate("/forget")
    };

    const handleBackToLogin = () => {
        navigate("/login")
    };

    return (
        <div className='register-all-container'>
            <div className='register-container'>
                <div className="registration">Registration</div>
                <div className="register-form">
                    <div className='register-all-left'>
                        <div className="inputs">
                            <div className='label-container-left'>
                                <div className='l-c-label'>Username</div>
                                <div className="username">
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        value={username}
                                        onChange={(e) => setUsername(e.target.value)}
                                    />
                                </div>
                            </div>
                            <div className="register-input-first-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>First Name</div>
                                    <div className='first-name'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={firstName}
                                            onChange={(e) => setFirstName(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>M.I.</div>
                                    <div className='mi'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={middleInitial}
                                            maxLength={1}
                                            onChange={(e) => setMiddleInitial(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>Last Name</div>
                                    <div className='last-name'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={lastName}
                                            onChange={(e) => setLastName(e.target.value)}
                                        />
                                    </div>
                                </div>     
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Company Name</div>
                                <div className="company-name">
                                    <input 
                                        className="font-link"
                                        type="text"
                                        value={companyName}
                                        onChange={(e) => setCompanyName(e.target.value)}
                                    />
                                </div>
                            </div>

                            <div className="register-input-third-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>LTO Number</div>
                                    <div className='lto-number'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={ltoNumber}
                                            maxLength={11}
                                            onChange={(e) => setLtoNumber(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                <div className='l-c-label'>Contact Number</div>
                                    <div className='contact-number'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={contactNumber}
                                            maxLength={13}
                                            onChange={(e) => setContactNumber(e.target.value)}
                                        />
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Email</div>
                                <div className="email">
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                    />
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Password</div>
                                <div className="password">
                                    <input 
                                        className="font-link"
                                        type={visible ? "text" : "password"}
                                        value={password} 
                                        id="password"
                                        onChange={(e) => setPassword(e.target.value)}
                                    />

                                    <div className="eyecon-register" onClick={() => setVisible(!visible)}>
                                        <button>
                                            {visible ? <img src={eyeOpen} alt="Show Password" /> 
                                                    : <img src={eyeClose} alt="Hide Password" />}
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Repeat Password</div>
                                <div className="retype-password">
                                    <input
                                        className="font-link"
                                        type={repeatPasswordVisible ? "text" : "password"}
                                        value={repeatPassword}
                                        id="repeat-password"
                                        onChange={(e) => setRepeatPassword(e.target.value)}
                                    />

                                <div className="eyecon-register" onClick={() => setRepeatPasswordVisible(!repeatPasswordVisible)}>
                                    <button>
                                        {repeatPasswordVisible ? <img src={eyeOpen} alt="Show Password" /> : <img src={eyeClose} alt="Hide Password" />}
                                    </button>
                                </div>
                                </div>
                            </div>

                        </div>
                    </div>    

                    <div className="register-all-right">
                        <div className='label-container-right'>
                            <div className='l-c-label'>Client Classification</div>
                                <div className="cli-class">
                                    <div className="cli-class-both">
                                        <div className="cli-class-left">
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Importer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Exporter
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Slaughterhouse
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Poultry Dressing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Dealer
                                            </label>
                                        </div>

                                        <div className="cli-class-right">
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Processing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Cutting Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Consumer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Plant Officer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Cold Storage Warehouse
                                            </label>
                                        </div>
                                    </div>

                                    <div className="cli-class-others">
                                        <label class="cli-class-container">
                                            <input type="radio" name="cli-class"/>
                                            <span class="checkmark"></span>
                                            Others:
                                            <input 
                                                type="text"
                                                value={otherClientClassification}
                                                onChange={(e) => setOtherClientClassification(e.target.value)}
                                            />
                                        </label>
                                    </div>
                                </div>
                        </div>
                        <div className="register-button" onClick={handleRegister}>
                            <button className="text-button">Register</button>
                        </div>

                        <div className="register-last-row-text">
                            <button className="center button-text" onClick={handleBackToLogin}>Back To Log In</button>
                            <button className="center button-text" onClick={handleForgetPassword}>Forget Password?</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;

/*
import React, { useState } from 'react';
import './Register.css';
//import Userfront from "@userfront/core";
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import eyeOpen from '../Assets/EyeOpen.png';
import eyeClose from '../Assets/EyeClose.png';
import { set } from 'date-fns';

//Userfront.init("jb7ywq8b");

const Register = () => {

    const navigate = useNavigate();
    const [visible, setVisible] = useState(false);  
    const [repeatPasswordVisible, setRepeatPasswordVisible] = useState(false);

    const [formData, setFormData] = useState({
        firstName: '',
        middleName: '',
        lastName: '',
        email: '',
        companyName: '',
        ltoNumber: '',
        contactNumber: '',
        password: '',
        repeatPassword: '',
        clientClassification: ''
    });

    const handleClientRegistration = async () => {
        const clientData = {
            user: {
                firstName: formData.firstName,
                middleName: formData.middleName,
                lastName: formData.lastName,
                contactNumber: formData.contactNumber,
                email: formData.email,
                password: formData.password,
                userType: 'client',
            },
            client: {
                ltoNumber: formData.ltoNumber,
                clientClassification: formData.clientClassification,
                companyName: formData.companyName 
            },
        };
        
        try {
            const response = await fetch('http://localhost:8080/clients', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(clientData),
            });
            const data = await response.json();
            console.log('Client registration is successful:', data);
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        let signUpSuccess = false;
    
        /*
        // Form validation
        if (
            !formData.firstName ||
            !formData.lastName ||
            !formData.contactNumber ||
            !formData.email ||
            !formData.password ||
            !formData.confirmpass ||
            !formData.ltoNumber
        ) {
            alert('Please fill in all required fields.');
            return;
        }
    
        if (formData.password !== formData.repeatPassword) {
            alert('Passwords do not match.');
            return;
        }
    
        await handleClientRegistration();
        signUpSuccess = true;
    
        if (signUpSuccess) {
            sessionStorage.setItem('userEmail', formData.email);
            navigate('/tfaverify');
        }
    };

    const handleForgetPassword = () => {
        navigate("/forget")
    };

    const handleBackToLogin = () => {
        navigate("/login")
    };
    
    return (
        <div className='register-all-container'>
            <div className='register-container'>
                <div className="registration">Registration</div>
                <form onSubmit={handleSubmit} className="client-record-registration">
                <div className="register-form">
                    <div className='register-all-left'>
                        <div className="inputs">
                            <div className="register-input-first-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>First Name</div>
                                    <div className='first-name'>
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="firstName" 
                                        id="firstName" 
                                    />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>M.I.</div>
                                    <div className='mi'>
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="middleName" 
                                        id="middleName" 
                                    />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>Last Name</div>
                                    <div className='last-name'>
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="lastName" 
                                        id="lastName" 
                                    />
                                    </div>
                                </div>     
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Company Name</div>
                                <div className="company-name">
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="companyName" 
                                        id="companyName" 
                                    />
                                </div>
                            </div>

                            <div className="register-input-third-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>LTO Number</div>
                                    <div className='lto-number'>
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="ltoNumber" 
                                        id="ltoNumber" 
                                    />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                <div className='l-c-label'>Contact Number</div>
                                    <div className='contact-number'>
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        name="contactNumber" 
                                        id="contactNumber" 
                                        maxLength={13}
                                    />
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Email</div>
                                <div className="email">
                                <input 
                                        className="font-link"
                                        type="text" 
                                        name="companyName" 
                                        id="companyName" 
                                    />
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Password</div>
                                <div className="password">
                                    <input 
                                        className="font-link"
                                        type={visible ? "text" : "password"}
                                        name="password" 
                                        id="password"
                                    />

                                    <div className="eyecon-register" onClick={() => setVisible(!visible)}>
                                        <button>
                                            {visible ? <img src={eyeOpen} alt="Show Password" /> 
                                                    : <img src={eyeClose} alt="Hide Password" />}
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Repeat Password</div>
                                <div className="retype-password">
                                    <input
                                        className="font-link"
                                        type={repeatPasswordVisible ? "text" : "password"}
                                        name="repeatPassword"
                                        id="repeat-password"
                                    />

                                <div className="eyecon-register" onClick={() => setRepeatPasswordVisible(!repeatPasswordVisible)}>
                                    <button>
                                        {repeatPasswordVisible ? <img src={eyeOpen} alt="Show Password" /> : <img src={eyeClose} alt="Hide Password" />}
                                    </button>
                                </div>
                                </div>
                            </div>

                        </div>
                    </div>    

                    <div className="register-all-right">
                        <div className='label-container-right'>
                            <div className='l-c-label'>Client Classification</div>
                                <div className="cli-class">
                                    <div className="cli-class-both">
                                        <div className="cli-class-left">
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Importer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Exporter
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Slaughterhouse
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Poultry Dressing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Meat Dealer
                                            </label>
                                        </div>

                                        <div className="cli-class-right">
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Meat Processing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Meat Cutting Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Consumer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Plant Officer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" id="clientClassification" name="clientClassification" onChange={(e) => setFormData({ ...formData, clientClassification: e.target.name })}/>
                                                <span class="checkmark"></span>
                                                Cold Storage Warehouse
                                            </label>
                                        </div>
                                    </div>

                                    <div className="cli-class-others">
                                        <label class="cli-class-container">
                                            <input type="radio" name="cli-class"/>
                                            <span class="checkmark"></span>
                                            Others:
                                            <input 
                                                type="text"
                                                name="clientClassification"
                                                onChange={(e) => set(formData.clientClassification)}
                                            />
                                        </label>
                                    </div>
                        </div>
                        <div className="register-button" onClick={handleSubmit} align="center">
                                <button className="text-button">Register</button>
                            </div>

                            <div className="register-last-row-text">
                                <button className="center button-text" onClick={handleBackToLogin}>Back To Log In</button>
                                <button className="center button-text" onClick={handleForgetPassword}>Forget Password?</button>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    );

const Register = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [visible, setVisible] = useState(false);
    const [repeatPassword, setRepeatPassword] = useState("");
    const [repeatPasswordVisible, setRepeatPasswordVisible] = useState(false);
    const navigate = useNavigate();
    const [firstName, setFirstName] = useState("");

    const [middleInitial, setMiddleInitial] = useState("");
    const [lastName, setLastName] = useState("");
    const [companyName, setCompanyName] = useState("");
    const [ltoNumber, setLtoNumber] = useState("");
    const [contactNumber, setContactNumber] = useState("");
    const [clientClassification, setClientClassification] = useState("");
    const [otherClientClassification, setOtherClientClassification] = useState("");

    const navigateAfterLogin = () => {
        navigate("/");
    }

    const handleRegister = async () => {
        if (!email.trim() || !password.trim() || !firstName.trim() || !lastName.trim() || !companyName.trim() || !ltoNumber.trim() || !contactNumber.trim() || !clientClassification.trim()) {
            alert("Please fill in all required fields.");
            return;
        }
    
        try {
            const response = await Userfront.login({
                method: "password",
                email: email,
                password: password,
                firstName: firstName,
                lastName: lastName,
                companyName: companyName,
                ltoNumber: ltoNumber,
                contactNumber: contactNumber,
                clientClassification: clientClassification,
                otherClientClassification: otherClientClassification
            });
    
            console.log("Login Response:", response);
    
            if (response?.success === true) {
                navigateAfterLogin();
            }
        } catch (error) {
            alert("Incorrect username and password.");
        }
    };

    const handleForgetPassword = () => {
        navigate("/forget")
    };

    const handleBackToLogin = () => {
        navigate("/login")
    };

    return (
        <div className='register-all-container'>
            <div className='register-container'>
                <div className="registration">Registration</div>
                <div className="register-form">
                    <div className='register-all-left'>
                        <div className="inputs">
                            <div className="register-input-first-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>First Name</div>
                                    <div className='first-name'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={firstName}
                                            onChange={(e) => setFirstName(e.target.value)}
                                        /> 
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>M.I.</div>
                                    <div className='mi'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={middleInitial}
                                            maxLength={1}
                                            onChange={(e) => setMiddleInitial(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                    <div className='l-c-label'>Last Name</div>
                                    <div className='last-name'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={lastName}
                                            onChange={(e) => setLastName(e.target.value)}
                                        />
                                    </div>
                                </div>     
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Company Name</div>
                                <div className="company-name">
                                    <input 
                                        className="font-link"
                                        type="text"
                                        value={companyName}
                                        onChange={(e) => setCompanyName(e.target.value)}
                                    />
                                </div>
                            </div>

                            <div className="register-input-third-row">
                                <div className='label-container-left'>
                                    <div className='l-c-label'>LTO Number</div>
                                    <div className='lto-number'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={ltoNumber}
                                            maxLength={11}
                                            onChange={(e) => setLtoNumber(e.target.value)}
                                        />
                                    </div>
                                </div>

                                <div className='label-container-left'>
                                <div className='l-c-label'>Contact Number</div>
                                    <div className='contact-number'>
                                        <input 
                                            className="font-link"
                                            type="text"
                                            value={contactNumber}
                                            maxLength={13}
                                            onChange={(e) => setContactNumber(e.target.value)}
                                        />
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Email</div>
                                <div className="email">
                                    <input 
                                        className="font-link"
                                        type="text" 
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                    />
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Password</div>
                                <div className="password">
                                    <input 
                                        className="font-link"
                                        type={visible ? "text" : "password"}
                                        value={password} 
                                        id="password"
                                        onChange={(e) => setPassword(e.target.value)}
                                    />

                                    <div className="eyecon-register" onClick={() => setVisible(!visible)}>
                                        <button>
                                            {visible ? <img src={eyeOpen} alt="Show Password" /> 
                                                    : <img src={eyeClose} alt="Hide Password" />}
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <div className='label-container-left'>
                                <div className='l-c-label'>Repeat Password</div>
                                <div className="retype-password">
                                    <input
                                        className="font-link"
                                        type={repeatPasswordVisible ? "text" : "password"}
                                        value={repeatPassword}
                                        id="repeat-password"
                                        onChange={(e) => setRepeatPassword(e.target.value)}
                                    />

                                <div className="eyecon-register" onClick={() => setRepeatPasswordVisible(!repeatPasswordVisible)}>
                                    <button>
                                        {repeatPasswordVisible ? <img src={eyeOpen} alt="Show Password" /> : <img src={eyeClose} alt="Hide Password" />}
                                    </button>
                                </div>
                                </div>
                            </div>

                        </div>
                    </div>    

                    <div className="register-all-right">
                        <div className='label-container-right'>
                            <div className='l-c-label'>Client Classification</div>
                                <div className="cli-class">
                                    <div className="cli-class-both">
                                        <div className="cli-class-left">
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Importer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Exporter
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Slaughterhouse
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Poultry Dressing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Dealer
                                            </label>
                                        </div>

                                        <div className="cli-class-right">
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Processing Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Meat Cutting Plant
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Consumer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Plant Officer
                                            </label>
                                            <label class="cli-class-container">
                                                <input type="radio" name="cli-class" value={clientClassification} onChange={(e) => setClientClassification(e.target.value)}/>
                                                <span class="checkmark"></span>
                                                Cold Storage Warehouse
                                            </label>
                                        </div>
                                    </div>

                                    <div className="cli-class-others">
                                        <label class="cli-class-container">
                                            <input type="radio" name="cli-class"/>
                                            <span class="checkmark"></span>
                                            Others:
                                            <input 
                                                type="text"
                                                value={otherClientClassification}
                                                onChange={(e) => setOtherClientClassification(e.target.value)}
                                            />
                                        </label>
                                    </div>
                                </div>
                        </div>
                        <div className="register-button" onClick={handleRegister}>
                            <button className="text-button">Register</button>
                        </div>

                        <div className="register-last-row-text">
                            <button className="center button-text" onClick={handleBackToLogin}>Back To Log In</button>
                            <button className="center button-text" onClick={handleForgetPassword}>Forget Password?</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
    

}*/

//export default Register;