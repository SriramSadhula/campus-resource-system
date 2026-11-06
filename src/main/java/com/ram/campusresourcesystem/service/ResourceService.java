
package com.ram.campusresourcesystem.service;

import com.ram.campusresourcesystem.entity.Resource;
import com.ram.campusresourcesystem.repo.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Long id, Resource resource) {

        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Resource not found with id: " + id
                ));

        existingResource.setName(resource.getName());
        existingResource.setType(resource.getType());
        existingResource.setLocation(resource.getLocation());
        existingResource.setCapacity(resource.getCapacity());
        existingResource.setStatus(resource.getStatus());

        return resourceRepository.save(existingResource);
    }

    //DELETING THE RESOURCE
    public void deleteResource(Long id) {

        if (!resourceRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Resource not found with id: " + id
            );
        }

        resourceRepository.deleteById(id);
    }
    public List<Resource> getResourcesByType(String type) {
        return resourceRepository.findByTypeContainingIgnoreCase(type);
    }

    public List<Resource> getResourcesByLocation(String location) {
        return resourceRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Resource> getResourcesByStatus(String status)
    {
        return resourceRepository.findByStatusIgnoreCase(status);
    }
    //Resource Available or not checking using by id
    public boolean isResourceAvailable(Long id) {

        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Resource not found with id: " + id
                ));

        return resource.getStatus().equalsIgnoreCase("Available");
    }

}