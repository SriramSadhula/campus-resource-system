
import { CalendarDays } from "lucide-react";

function Reservations() {
    const reservations = [
        {
            id: 1,
            user: "Rahul",
            resource: "Computer Lab 1",
            date: "05 Nov 2026",
            time: "10 AM - 12 PM",
            status: "Pending",
        },
        {
            id: 2,
            user: "Priya",
            resource: "Seminar Hall",
            date: "06 Nov 2026",
            time: "2 PM - 4 PM",
            status: "Approved",
        },
        {
            id: 3,
            user: "Arjun",
            resource: "Projector 1",
            date: "07 Nov 2026",
            time: "9 AM - 10 AM",
            status: "Rejected",
        },
    ];

    return (
        <section className="reservation-page">
            <div className="page-heading">
                <div>
                    <h1>Reservations</h1>
                    <p>Manage and track campus resource reservations.</p>
                </div>

                <CalendarDays size={30} />
            </div>

            <div className="reservation-section">
                <table className="reservation-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>User</th>
                        <th>Resource</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tbody>
                    {reservations.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.user}</td>
                            <td>{item.resource}</td>
                            <td>{item.date}</td>
                            <td>{item.time}</td>
                            <td>
                  <span className={item.status.toLowerCase()}>
                    {item.status}
                  </span>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </section>
    );
}

export default Reservations;
