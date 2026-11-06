function RecentReservations() {
    const reservations = [
        {
            id: 1,
            resource: "Computer Lab 1",
            user: "Rahul",
            date: "05 Nov 2026",
            time: "10:00 AM - 12:00 PM",
            status: "Pending",
        },
        {
            id: 2,
            resource: "Seminar Hall",
            user: "Priya",
            date: "06 Nov 2026",
            time: "02:00 PM - 04:00 PM",
            status: "Approved",
        },
        {
            id: 3,
            resource: "Projector 1",
            user: "Arjun",
            date: "07 Nov 2026",
            time: "09:00 AM - 10:00 AM",
            status: "Rejected",
        },
    ];

    return (
        <section className="reservation-section">
            <h2>Recent Reservations</h2>
            <p className="section-description">
                Latest campus resource booking requests.
            </p>

            <div className="reservation-table-wrapper">
                <table className="reservation-table">
                    <thead>
                    <tr>
                        <th>Resource</th>
                        <th>Requested By</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tbody>
                    {reservations.map((reservation) => (
                        <tr key={reservation.id}>
                            <td>{reservation.resource}</td>
                            <td>{reservation.user}</td>
                            <td>{reservation.date}</td>
                            <td>{reservation.time}</td>
                            <td>
                  <span className={`reservation-status ${reservation.status.toLowerCase()}`}>
                    {reservation.status}
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

export default RecentReservations;