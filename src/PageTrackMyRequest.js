import React from "react";
import TrackMyRequest from './Components/TrackMyRequest/TrackMyRequest';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageRegister() {
    return(
        <div>
            <Header/>
            <TrackMyRequest/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageRegister