import React from "react";
import ForReleaseList from './Components/ForReleaseList/ForReleaseList';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageRegister() {
    return(
        <div>
            <Header/>
            <ForReleaseList/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageRegister