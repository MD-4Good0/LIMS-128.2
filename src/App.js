import Userfront from "@userfront/react";
import React from 'react';

import './App.css';
import { Routes, Route, Navigate} from "react-router-dom";
import PageLogin from './PageLogin';
import PageForget from './PageForget';
import PageRegister from './PageRegister';
import PageTFA from './PageTFA';
import PageForgotES from './PageEmailSent';
import PageForgotNIS from './PageNotInSystem';
import PageRegisterTY from './PageThankYou';
import PageHomeClient from './PageHomeClient';
import PageHomeRecRel from './PageHomeRecRel';
import PageHomeTesting from './PageHomeTesting';
import PageSubmitRequest from './PageSubmitRequest';
import PageSubmitRequestReview from './PageSubmitRequestReview';
import PageTrackMyRequest from './PageTrackMyRequest';
import PagePendingRequest from './PagePendingRequest';
import PageForReleaseList from './PageForReleaseList';
import PageShowControlNumber from './PageShowControlNumber';
import PageRequestAddInfo from './PageRequestAddInfo';
import PageRequestDetails from './PageRequestDetails';
import PageViewDatabase from "./PageViewDatabase";
import PageTestingList from "./PageTestingList";

Userfront.init("jb7ywq8b");

function Home() {
  if (!Userfront.accessToken()) {
    return <PageLogin />;
  } else if (Userfront.user.hasRole("client")) {
    return <PageHomeClient />;
  } else if (Userfront.user.hasRole("receive-release")) {
    return <PageHomeRecRel />;
  } else if (Userfront.user.hasRole("testing")) {
    return <PageHomeTesting />;
  }
  return <PageLogin />;
}

function App() {
  return (
    <Routes>
      <Route path="/register" element={<PageRegister/>}/>
      <Route path="/forget" element={<PageForget/>}/>
      <Route path="/register" element={<PageRegister/>}/>
      <Route path="/tfa" element={<PageTFA/>}/>
      <Route path="/email-sent" element={<PageForgotES/>}/>
      <Route path="/not-in-system" element={<PageForgotNIS/>}/>
      <Route path="/registered" element={<PageRegisterTY/>}/>
      
      <Route
        path="*"
        element={
          Userfront.accessToken() ? (
            <Home/>
          ) : (
            <Navigate to="/login" />
          )
        }
      />

      <Route path="/login" element={<PageLogin/>}/>

      <Route path="/home-client" element={<PageHomeClient/>}/>
        <Route path="/submit-a-request" element={<PageSubmitRequest/>}/>
          <Route path="/submit-review" element={<PageSubmitRequestReview/>}/>
        <Route path="/track-my-request" element={<PageTrackMyRequest/>}/>

      <Route path="/home-receive-release" element={<PageHomeRecRel/>}/>
        <Route path="/pending-requests" element={<PagePendingRequest/>}/>
          <Route path="/request-details" element={<PageRequestDetails/>}/>
          <Route path="/show-control-number" element={<PageShowControlNumber/>}/>
          <Route path="/request-add-info" element={<PageRequestAddInfo/>}/>
        <Route path="/for-release" element={<PageForReleaseList/>}/>
        <Route path="/testing-list" element={<PageTestingList/>}/>
        <Route path="/view-database" element={<PageViewDatabase/>}/>

      <Route path="/home-testing" element={<PageHomeTesting/>}/>
    </Routes>
  );
}

export default App;