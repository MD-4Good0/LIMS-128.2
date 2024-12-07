import React from "react";
import ForgetPasswordEmail from './Components/1_BeforeLogin/Forget-Password-Email';
import BG from './Components/0_Head_Foot_BG/BG';
import Footer from './Components/0_Head_Foot_BG/Footer';

function PageForgetEmail() {
    return(
        <div>
            <ForgetPasswordEmail/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageForgetEmail