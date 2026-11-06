
import { UserCircle, Shield, Bell } from "lucide-react";

function Settings() {
    return (
        <section className="settings-page">
            <div className="page-heading">
                <div>
                    <h1>Settings</h1>
                    <p>Manage your account and preferences.</p>
                </div>
            </div>

            <div className="settings-card">
                <div className="settings-icon">
                    <UserCircle size={25} />
                </div>

                <div>
                    <h3>Profile Information</h3>
                    <p>Manage your personal account details.</p>
                </div>

                <div className="settings-info">
                    <label>Name</label>
                    <p>Campus User</p>

                    <label>Email</label>
                    <p>user@campus.edu</p>

                    <label>Role</label>
                    <p>Student</p>
                </div>
            </div>

            <div className="settings-card">
                <Shield size={25} />
                <div>
                    <h3>Security</h3>
                    <p>Password and account security settings.</p>
                </div>
            </div>

            <div className="settings-card">
                <Bell size={25} />
                <div>
                    <h3>Notifications</h3>
                    <p>Manage reservation notification preferences.</p>
                </div>
            </div>
        </section>
    );
}

export default Settings;
