
import { Search, Bell, UserCircle } from "lucide-react";

function Navbar() {
    return (
        <header className="navbar">
            <div className="navbar-right">
                <div className="search-box">
                    <Search size={18} />
                    <input
                        type="text"
                        placeholder="Search resources..."
                    />
                </div>

                <Bell size={21} />
                <UserCircle size={25} />
            </div>
        </header>
    );
}

export default Navbar;
