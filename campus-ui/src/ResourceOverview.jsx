import { Monitor, Projector, Laptop, Building2 } from "lucide-react";

function ResourceOverview() {
    const resources = [
        {
            name: "Computer Lab 1",
            type: "Computer Lab",
            location: "Block A, Floor 2",
            capacity: 60,
            status: "Available",
            icon: Monitor,
        },
        {
            name: "Projector 1",
            type: "Projector",
            location: "Block B, Room 101",
            capacity: 1,
            status: "Available",
            icon: Projector,
        },
        {
            name: "Laptop Set",
            type: "Laptops",
            location: "Library",
            capacity: 20,
            status: "Under Maintenance",
            icon: Laptop,
        },
        {
            name: "Seminar Hall",
            type: "Seminar Hall",
            location: "Main Building",
            capacity: 150,
            status: "Available",
            icon: Building2,
        },
    ];

    return (
        <section className="resource-section">
            <h2>Resource Overview</h2>
            <p className="section-description">
                Explore the resources available on campus.
            </p>

            <div className="resource-grid">
                {resources.map((resource) => {
                    const Icon = resource.icon;

                    return (
                        <div className="resource-card" key={resource.name}>
                            <div className="resource-icon">
                                <Icon size={25} />
                            </div>

                            <h3>{resource.name}</h3>
                            <p>{resource.type}</p>

                            <div className="resource-details">
                                <span>Location</span>
                                <strong>{resource.location}</strong>

                                <span>Capacity</span>
                                <strong>{resource.capacity}</strong>
                            </div>

                            <span
                                className={`status ${
                                    resource.status === "Available"
                                        ? "available"
                                        : "maintenance"
                                }`}
                            >
                {resource.status}
              </span>
                        </div>
                    );
                })}
            </div>
        </section>
    );
}

export default ResourceOverview;