import React from "react";
import SubmitReview from './Components/SubmitReview/SubmitReview';
import BG from './Components/Background/BG';
import Footer from './Components/Footer/Footer';
import Header from './Components/Header/Header';

function PageSubmitRequestReview() {
    return(
        <div>
            <Header/>
            <SubmitReview/>
            <BG/>
            <Footer />
        </div>
    )
}

export default PageSubmitRequestReview