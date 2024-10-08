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
import PageTrackMyRequest from './PageTrackMyRequest';
import PagePendingRequest from './PagePendingRequest';
import PageForReleaseList from './PageForReleaseList';
import PageShowControlNumber from './PageShowControlNumber';
import PageRequestAddInfo from './PageRequestAddInfo';

Userfront.init("jb7ywq8b");

function Home() {
  if (!Userfront.accessToken()) {
    return <PageLogin />;
  } else if (Userfront.user.hasRole("viewer")) {
    return;
  } else if (Userfront.user.hasRole("author")) {
    return;
  } else if (Userfront.user.hasRole("subscriber")) {
    return;
  } else if (Userfront.user.hasRole("admin")) {
    return;
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
      <Route path="/showcontrolnumber" element={<PageShowControlNumber/>}/>
      <Route path="/requestaddinfo" element={<PageRequestAddInfo/>}/>

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
      <Route path="/homeclient" element={<PageHomeClient/>}/>
      <Route path="/submit" element={<PageSubmitRequest/>}/>
      <Route path="/trackmyrequest" element={<PageTrackMyRequest/>}/>
      <Route path="/pendingrequest" element={<PagePendingRequest/>}/>
      <Route path="/forreleaselist" element={<PageForReleaseList/>}/>


      <Route path="/homerecrel" element={<PageHomeRecRel/>}/>

      <Route path="/hometesting" element={<PageHomeTesting/>}/>
    </Routes>
  );
}

export default App;