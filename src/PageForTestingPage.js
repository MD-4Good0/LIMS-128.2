import React from "react";
import ForTestingPage from './Components/ForTestingPage/ForTestingPage';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageForTestingPage() {
    return(
        <div>
            <Header/>
            <ForTestingPage/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageForTestingPage