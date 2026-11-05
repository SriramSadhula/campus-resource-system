package com.ram.campusresourcesystem.controller;

import com.ram.campusresourcesystem.entity.Resource;
import com.ram.campusresourcesystem.service.ResourceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hoppscotch.io"
})
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @PostMapping
    public Resource addResource(@Valid @RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable Long id,@Valid @RequestBody Resource resource)
    {
        return resourceService.updateResource(id,resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable  Long id)
    {
        resourceService.deleteResource(id);
    }

    @GetMapping("/type/{type}")
    public List<Resource> getResourcesByType(@PathVariable String type)
    {
        return resourceService.getResourcesByType(type);
    }

    @GetMapping("/location/{location}")
    public List<Resource> getResourcesByLocation(@PathVariable String location)
    {
        return resourceService.getResourcesByLocation(location);
    }

    @GetMapping("/status/{status}")
    public List<Resource> getResourcesByStatus(@PathVariable String status) {
        return resourceService.getResourcesByStatus(status);
    }

    @GetMapping("/{id}/availability")
    public boolean checkAvailability(@PathVariable Long id) {
        return resourceService.isResourceAvailable(id);
    }
}