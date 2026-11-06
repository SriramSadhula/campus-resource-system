
import { useState } from "react";

import Sidebar from "./Sidebar";
import Navbar from "./Navbar";
import StatsCards from "./StatsCards";
import ResourceOverview from "./ResourceOverview";
import RecentReservations from "./RecentReservations";
import Resources from "./Resources";
import Reservations from "./Reservations";
import MyBookings from "./MyBookings";
import "./App.css";

import Settings from "./Settings";

function App() {
  const [activePage, setActivePage] = useState("Dashboard");

  return (
      <div>
        <Sidebar
            activePage={activePage}
            setActivePage={setActivePage}
        />

        <main className="main-content">
          <Navbar activePage={activePage} />

          {activePage === "Dashboard" && (
              <>
                <h1>Welcome to CampusIQ!</h1>
                <p>Manage your campus resources easily.</p>

                <StatsCards />
                <ResourceOverview />
                <RecentReservations />
              </>
          )}

          {activePage === "Resources" && <Resources />}
          {activePage === "Reservations" && <Reservations />}
          {activePage === "My Bookings" && <MyBookings />}
          {activePage === "Settings" && <Settings />}
        </main>
      </div>
  );
}

export default App;
