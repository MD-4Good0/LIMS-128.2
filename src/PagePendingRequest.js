import React from "react";
import PendingRequest from './Components/PendingRequest/PendingRequest';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageRegister() {
    return(
        <div>
            <Header/>
            <PendingRequest/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageRegister