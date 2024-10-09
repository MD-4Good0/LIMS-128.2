import React from "react";
import TestingList from './Components/TestingList/TestingList';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageTestingList() {
    return(
        <div>
            <Header/>
            <TestingList/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageTestingList