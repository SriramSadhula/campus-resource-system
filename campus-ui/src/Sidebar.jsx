import {
    LayoutDashboard,
    Building2,
    CalendarDays,
    ClipboardList,
    Settings
} from "lucide-react";

function Sidebar({ activePage, setActivePage }) {
    const menuItems = [
        { name: "Dashboard", icon: LayoutDashboard },
        { name: "Resources", icon: Building2 },
        { name: "Reservations", icon: CalendarDays },
        { name: "My Bookings", icon: ClipboardList },
    ];

    return (
        <aside className="sidebar">

            <div className="brand">
                <Building2 size={25} />
                <h2>CampusIQ</h2>
            </div>

            <p className="menu-title">MAIN MENU</p>

            <nav>
                {menuItems.map((item) => {
                    const Icon = item.icon;

                    return (
                        <button
                            key={item.name}
                            className={`nav-link ${
                                activePage === item.name ? "active" : ""
                            }`}
                            onClick={() => setActivePage(item.name)}
                        >
                            <Icon size={19} />
                            {item.name}
                        </button>
                    );
                })}
            </nav>

            <div className="sidebar-bottom">
                <button
                    className="nav-link"
                    onClick={() => setActivePage("Settings")}
                >
                    <Settings size={19} />
                    Settings
                </button>
            </div>

        </aside>
    );
}

export default Sidebar;