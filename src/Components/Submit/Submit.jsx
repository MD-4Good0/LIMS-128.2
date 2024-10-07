import React, {useState} from 'react';
import './Submit.css';
import Userfront from "@userfront/core";

import blue_logo_icon from '../Assets/BlueLine.png';
import dropdown_icon from '../Assets/DropDown.png';

Userfront.init("jb7ywq8b");

const Register = () => {
    const [purposeTesting, setPurposeTesting] = useState("");
    const [otherPurposeTesting, setOtherPurposeTesting] = useState("");
    const [dropdown_purpose, setDropdownPurpose] = useState(false);
    const [dropdown_test, setDropdownTest] = useState(false);

    return (
        <div className="submit-all-container">
            <div className='submit-container'>
                <div className='submit-title'>Submit a Request</div>
                <div className="submit-1st-container">
                    <div className='submit-1st-container-column'>
                        <div className='submit-1st-container-column-row'>
                            <div className='submit-1st-container-column-row-column-1'>
                                Representative Name:
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='submit-1st-container-column-row-column-2'>
                                Contact Number:
                                <input type="text" value="0999 999 9999"/>
                            </div>
                            <div className='submit-1st-container-column-row-column-3'>
                                Email Address:
                                <input type="text" value="sample_email123@example.com.ph"/>
                            </div>
                            <div className='submit-1st-container-column-row-column-4'>
                                Company Name:
                                <input type="text" value="University of the Philippines Manila"/>
                            </div>
                        </div>
                    </div>
                    <p className='note'>
                            * these information are prefilled with your logged-in details
                    </p>
                </div>
                <div className="submit-row">
                    <div className='sample-information'>
                        <div className='sample-title'>Sample Information</div>
                        <img src={blue_logo_icon} alt="blue line"/>
                        <div className='sample-rows'>
                            <div className='sample-row'>
                                <div>Sample Type/Description:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Lot/Batch Number:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Sample Source:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Production Date:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Expiry Date:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Sampling Date:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                            <div className='sample-row'>
                                <div>Sampler Name:</div>
                                <input type="text" value="A*******r J*****n A M*******d"/>
                            </div>
                        </div>
                    </div>
                    <div className='submit-column'>
                        <details className='purposeoftesting'>
                            <summary className='purpose-title' onClick={() => setDropdownPurpose(!dropdown_purpose)}>
                                Purpose of Testing
                                <img 
                                    src={dropdown_icon} 
                                    alt='dropdown icon'
                                    className={dropdown_purpose ? 'rotate-up' : 'rotate-down'}
                                />
                            </summary>
                            <div className="show">
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Monitoring
                                </label>
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Local Trade
                                </label>
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Imported
                                </label>
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Export
                                </label>
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Complaint
                                </label>
                                <label class="purposeoftesting_choices">
                                    <input type="radio" name="cli-class" value={purposeTesting} onChange={(e) => setPurposeTesting(e.target.value)}/>
                                    <span class="checkmark"></span>
                                    Others
                                    <input 
                                        type="text"
                                        value={otherPurposeTesting}
                                        onChange={(e) => setOtherPurposeTesting(e.target.value)}
                                    />
                                </label>
                            </div>
                        </details>

                        <details className='testselection'>
                            <summary className='test-title' onClick={() => setDropdownTest(!dropdown_test)}>
                                Test Selection
                                <img 
                                    src={dropdown_icon} 
                                    alt='dropdown icon'
                                    className={dropdown_test ? 'rotate-up' : 'rotate-down'}
                                />
                            </summary>
                        </details>
                        <div className='submit-button'>
                            <button className="submit-text-button">Log In</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;