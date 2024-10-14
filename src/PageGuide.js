import React from "react";
import Guide from './Components/Guide/Guide';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageGuide() {
    return(
        <div>
            <Header/>
            <Guide/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageGuide