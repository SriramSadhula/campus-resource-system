import { Building2, CheckCircle, Wrench, Clock } from "lucide-react";

function StatsCards() {
    const stats = [
        {
            title: "Total Resources",
            value: 120,
            icon: Building2,
            color: "#3b82f6",
        },
        {
            title: "Available",
            value: 85,
            icon: CheckCircle,
            color: "#16a34a",
        },
        {
            title: "Under Maintenance",
            value: 15,
            icon: Wrench,
            color: "#f59e0b",
        },
        {
            title: "Pending Reservations",
            value: 20,
            icon: Clock,
            color: "#8b5cf6",
        },
    ];

    return (
        <div className="stats-container">
            {stats.map((item) => {
                const Icon = item.icon;

                return (
                    <div className="stat-card" key={item.title}>
                        <div>
                            <p>{item.title}</p>
                            <h2>{item.value}</h2>
                        </div>

                        <Icon size={28} color={item.color} />
                    </div>
                );
            })}
        </div>
    );
}

export default StatsCards;