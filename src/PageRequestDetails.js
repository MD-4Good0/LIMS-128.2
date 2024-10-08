import React from "react";
import RequestDetails from './Components/RequestDetails/RequestDetails';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageRequestDetails() {
    return(
        <div>
            <Header/>
            <RequestDetails/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageRequestDetails