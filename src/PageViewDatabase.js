import React from "react";
import ViewDatabase from './Components/ViewDatabase/ViewDatabase';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageViewDatabase() {
    return(
        <div>
            <Header/>
            <ViewDatabase/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageViewDatabase