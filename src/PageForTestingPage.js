import React from "react";
import ForTestingPage from './Components/3_Testing/ForTestingPage';
import BG from './Components/0_Head_Foot_BG/BG';
import Footer from './Components/0_Head_Foot_BG/Footer';

function PageForTestingPage() {
    return(
        <div>
            <ForTestingPage/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageForTestingPage