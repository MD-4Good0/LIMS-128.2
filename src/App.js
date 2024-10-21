import Userfront from "@userfront/react";
import React, { useState, useEffect } from "react";
import "./App.css";
import { Routes, Route, Navigate } from "react-router-dom";
import Header from "./Components/0_Head_Foot_BG/Header"; // Make sure to import the Header component
import PageLogin from "./PageLogin";
import PageForget from "./PageForget";
import PageRegister from "./PageRegister";
import PageTFA from "./PageTFA";
import PageForgotES from "./PageEmailSent";
import PageForgotNIS from "./PageNotInSystem";
import PageRegisterTY from "./PageThankYou";
import PageHomeClient from "./PageHomeClient";
import PageHomeRecRel from "./PageHomeRecRel";
import PageHomeTesting from "./PageHomeTesting";
import PageSubmitRequest from "./PageSubmitRequest";
import PageSubmitRequestReview from "./PageSubmitRequestReview";
import PageTrackMyRequest from "./PageTrackMyRequest";
import PagePendingRequest from "./PagePendingRequest";
import PageForReleaseList from "./PageForReleaseList";
import PageShowControlNumber from "./PageShowControlNumber";
import PageRequestAddInfo from "./PageRequestAddInfo";
import PageRequestDetails from "./PageRequestDetails";
import PageViewDatabaseT from "./PageViewDatabaseT";
import PageViewDatabaseRR from "./PageViewDatabaseRR";
import PageForTesting from "./PageForTesting";
import PageGuide from "./PageGuide";
import PageTestResults from "./PageTestResults";
import PageTFAVerify from "./PageTFA-Verify-Reg";

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

// Role-based Route Protection
function ProtectedRoute({ role, children }) {
  const user = Userfront.user;
  if (!Userfront.accessToken() || !user.hasRole(role)) {
    return <Navigate to="/login" />;
  }
  return children;
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!Userfront.accessToken());

  useEffect(() => {
    // Update login status whenever the component mounts or updates
    setIsLoggedIn(!!Userfront.accessToken());
  }, []);

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <>
      <Header onLogout={handleLogout} />
      <Routes>
        {!isLoggedIn && (
          <>
            <Route path="/register" element={<PageRegister />} />
            <Route path="/forget" element={<PageForget />} />
            <Route path="/tfa" element={<PageTFA />} />
            <Route path="/email-sent" element={<PageForgotES />} />
            <Route path="/not-in-system" element={<PageForgotNIS />} />
            <Route path="/registered" element={<PageRegisterTY />} />
            <Route path="/login" element={<PageLogin />} />
            <Route path="/tfaverify" element={<PageTFAVerify />} />
          </>
        )}

        <Route
          path="*"
          element={isLoggedIn ? <Home /> : <Navigate to="/login" />}
        />

        {/* Routes accessible only by 'client' role */}
        <Route
          path="/home-client"
          element={
            <ProtectedRoute role="client">
              <PageHomeClient />
            </ProtectedRoute>
          }
        />
        <Route
          path="/submit-a-request"
          element={
            <ProtectedRoute role="client">
              <PageSubmitRequest />
            </ProtectedRoute>
          }
        />
        <Route
          path="/submit-review"
          element={
            <ProtectedRoute role="client">
              <PageSubmitRequestReview />
            </ProtectedRoute>
          }
        />
        <Route
          path="/track-my-request"
          element={
            <ProtectedRoute role="client">
              <PageTrackMyRequest />
            </ProtectedRoute>
          }
        />
        <Route
          path="/guide"
          element={
            <ProtectedRoute role="client">
              <PageGuide />
            </ProtectedRoute>
          }
        />

        {/* Routes accessible only by 'receive-release' role */}
        <Route
          path="/home-receive-release"
          element={
            <ProtectedRoute role="receive-release">
              <PageHomeRecRel />
            </ProtectedRoute>
          }
        />
        <Route
          path="/pending-requests"
          element={
            <ProtectedRoute role="receive-release">
              <PagePendingRequest />
            </ProtectedRoute>
          }
        />
        <Route
          path="/request-details"
          element={
            <ProtectedRoute role="receive-release">
              <PageRequestDetails />
            </ProtectedRoute>
          }
        />
        <Route
          path="/show-control-number"
          element={
            <ProtectedRoute role="receive-release">
              <PageShowControlNumber />
            </ProtectedRoute>
          }
        />
        <Route
          path="/request-add-info"
          element={
            <ProtectedRoute role="receive-release">
              <PageRequestAddInfo />
            </ProtectedRoute>
          }
        />
        <Route
          path="/for-release"
          element={
            <ProtectedRoute role="receive-release">
              <PageForReleaseList />
            </ProtectedRoute>
          }
        />
        <Route
          path="/receive-release-database"
          element={
            <ProtectedRoute role="receive-release">
              <PageViewDatabaseRR />
            </ProtectedRoute>
          }
        />

        {/* Routes accessible only by 'testing' role */}
        <Route
          path="/home-testing"
          element={
            <ProtectedRoute role="testing">
              <PageHomeTesting />
            </ProtectedRoute>
          }
        />
        <Route
          path="/for-testing"
          element={
            <ProtectedRoute role="testing">
              <PageForTesting />
            </ProtectedRoute>
          }
        />
        <Route
          path="/test-results"
          element={
            <ProtectedRoute role="testing">
              <PageTestResults />
            </ProtectedRoute>
          }
        />
        <Route
          path="/testing-database"
          element={
            <ProtectedRoute role="testing">
              <PageViewDatabaseT />
            </ProtectedRoute>
          }
        />
      </Routes>
    </>
  );
}

export default App;
