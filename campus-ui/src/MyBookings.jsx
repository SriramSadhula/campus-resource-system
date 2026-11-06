
import { ClipboardList } from "lucide-react";

function MyBookings() {
    const myBookings = [
        {
            id: 1,
            resource: "Computer Lab 1",
            date: "05 Nov 2026",
            time: "10 AM - 12 PM",
            status: "Pending",
        },
        {
            id: 2,
            resource: "Seminar Hall",
            date: "06 Nov 2026",
            time: "2 PM - 4 PM",
            status: "Approved",
        },
        {
            id: 3,
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
                   <h1>My Bookings</h1>
                    <p>View and track your resource booking requests.</p>
                </div>

                <ClipboardList size={30} />
            </div>

            <div className="reservation-section">
                <table className="reservation-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Resource</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tbody>
                    {myBookings.map((booking) => (
                        <tr key={booking.id}>
                            <td>{booking.id}</td>
                            <td>{booking.resource}</td>
                            <td>{booking.date}</td>
                            <td>{booking.time}</td>
                            <td>
                  <span className={booking.status.toLowerCase()}>
                    {booking.status}
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

export default MyBookings;
