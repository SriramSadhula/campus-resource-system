import { Search, Monitor, Laptop, Projector } from "lucide-react";

function Resources() {
    const resources = [
        {
            id: 1,
            name: "Computer Lab 1",
            type: "Computer Lab",
            location: "Block A",
            status: "Available",
            icon: Monitor,
        },
        {
            id: 2,
            name: "Laptop Set",
            type: "Laptops",
            location: "Library",
            status: "Available",
            icon: Laptop,
        },
        {
            id: 3,
            name: "Projector 1",
            type: "Projector",
            location: "Block B",
            status: "Under Maintenance",
            icon: Projector,
        },
    ];

    return (
        <section>
            <h1>Campus Resources</h1>
            <p className="section-description">
                Browse and explore campus resources.
            </p>

            <div className="resource-search">
                <Search size={18} />
                <input placeholder="Search resources..." />
            </div>

            <div className="resource-grid">
                {resources.map((resource) => {
                    const Icon = resource.icon;

                    return (
                        <div className="resource-card" key={resource.id}>
                            <div className="resource-icon">
                                <Icon size={25} />
                            </div>

                            <h3>{resource.name}</h3>
                            <p>{resource.type}</p>

                            <div className="resource-details">
                                <span>Location</span>
                                <strong>{resource.location}</strong>
                            </div>

                            <span className={`status ${
                                resource.status === "Available"
                                    ? "available"
                                    : "maintenance"
                            }`}>
                {resource.status}
              </span>

                            <button className="view-button">
                                View Details
                            </button>
                        </div>
                    );
                })}
            </div>
        </section>
    );
}

export default Resources;